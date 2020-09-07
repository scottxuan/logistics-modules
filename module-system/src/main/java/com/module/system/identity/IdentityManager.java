package com.module.system.identity;

import com.module.system.constants.JwtConstant;
import com.module.system.enums.UserSource;
import com.module.system.client.SysUserFeignClient;
import com.module.system.entity.SysUser;
import com.module.system.utils.JwtUtil;
import com.scottxuan.core.utils.EntityUtils;
import com.scottxuan.web.result.ResultDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @author scottxuan
 */
@Component
public class IdentityManager {

    @Autowired
    private SysUserFeignClient sysUserFeignClient;

    private static IdentityManager identityManager;

    @PostConstruct
    public void init(){
        identityManager = this;
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public static Identity currentUser(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String accessToken = request.getHeader(JwtConstant.ACCESS_TOKEN);
        if (StringUtils.isBlank(accessToken)) {
            return null;
        }
        Claims claims;
        try{
            claims = JwtUtil.parseToken(accessToken);
        }catch (ExpiredJwtException e) {
            return null;
        }
        Integer userId = (Integer)claims.get(JwtConstant.USER_ID);
        Integer userSource = (Integer)claims.get(JwtConstant.USER_SOURCE);
        return findByIdAndSource(userId,userSource);
    }

    /**
     * 获取当前登录用户id
     * @return
     */
    public static Integer currentUserId(){
        Identity identity = currentUser();
        if (identity == null) {
            return -1;
        }
        return identity.getId();
    }

    private static Identity findByIdAndSource(Integer userId , Integer source){
        UserSource userSource = UserSource.getUserSource(source);
        if (userSource == null) {
            return null;
        }
        Identity identity;
        switch (userSource){
            case SYS:
                identity = new Identity();
                ResultDto<SysUser> dto = identityManager.sysUserFeignClient.findById(userId);
                if (dto.isPresent()) {
                    EntityUtils.copyPropertiesIgnoreNull(dto.get(),identity);
                }
                break;
            case CUS:
                identity = new Identity();
                break;
            default:
                identity = null;
                break;
        }
        return identity;
    }
}
