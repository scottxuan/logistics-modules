package com.module.system.utils;

import com.module.system.constants.JwtConstant;
import com.module.system.enums.UserSource;
import com.scottxuan.base.utils.RSAUtils;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : pc
 * @date : 2020/8/26
 */
@Service
public class JwtUtil{

    private static PrivateKey privateKey = null;
    private static PublicKey publicKey = null;

    private static final AtomicBoolean PRIVATE_KEY_IS_LOAD = new AtomicBoolean(true);
    private static final AtomicBoolean PUBLIC_KEY_IS_LOAD = new AtomicBoolean(true);

    public static String createToken(Integer userId, UserSource userSource, List<String> roles, List<String> permissions, Date expireDate) {
        try {
            if(PRIVATE_KEY_IS_LOAD.compareAndSet(true,false) || privateKey == null){
                privateKey = getPrivateKey();
            }
            JwtBuilder builder = Jwts.builder()
                    .setHeaderParam("alg", "RS256")
                    .setHeaderParam("typ", "JWT");
            builder.claim(JwtConstant.USER_ID, userId);
            builder.claim(JwtConstant.USER_SOURCE, userSource.getSource());
            builder.claim(JwtConstant.ROLES, roles);
            builder.claim(JwtConstant.PERMISSIONS, permissions);
            builder.signWith(SignatureAlgorithm.RS256, privateKey)
                    .setExpiration(expireDate);
            return builder.compact();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Claims parseToken(String token) {
        if(PUBLIC_KEY_IS_LOAD.compareAndSet(true,false) || publicKey == null){
            publicKey = getPublicKey();
        }
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token);
        return claimsJws.getBody();
    }

    private static PrivateKey getPrivateKey() {
        BufferedReader bufferedReader = null;
        PrivateKey privateKey = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(JwtUtil.class.getResource("/privateKey.key").getPath()));
            StringBuilder privateKeyBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                privateKeyBuilder.append(line);
            }
            String privateKeyString = privateKeyBuilder.toString().trim();
            privateKeyString = privateKeyString.replaceAll("-----BEGIN PRIVATE KEY-----", "")
                    .replaceAll("-----END PRIVATE KEY-----", "")
                    .replaceAll("\r", "")
                    .replaceAll("\n", "")
                    .replaceAll("\r\n", "");
            privateKey = RSAUtils.getPrivateKey(privateKeyString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return privateKey;
    }

    private static PublicKey getPublicKey() {
        BufferedReader bufferedReader = null;
        PublicKey publicKey = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(JwtUtil.class.getResource("/publicKey.key").getPath()));
            StringBuilder privateKeyBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                privateKeyBuilder.append(line);
            }
            String publicKeyString = privateKeyBuilder.toString().trim();
            publicKeyString = publicKeyString.replaceAll("-----BEGIN PUBLIC KEY-----", "")
                    .replaceAll("-----END PUBLIC KEY-----", "")
                    .replaceAll("\r", "")
                    .replaceAll("\n", "")
                    .replaceAll("\r\n", "");
            publicKey = RSAUtils.getPublicKey(publicKeyString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return publicKey;
    }
}
