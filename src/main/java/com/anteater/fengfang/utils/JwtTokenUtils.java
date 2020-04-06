package com.anteater.fengfang.utils;

import com.anteater.fengfang.domains.auth.CheckResult;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Map;

public class JwtTokenUtils {
    private static final long expireTime = 3600*1000;
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private static final String JWT_ERRCODE_EXPIRE= "JWT_ERRCODE_EXPIRE";
    private static final String JWT_ERRCODE_FAIL= "JWT_ERRCODE_FAIL";
    private static final String JWT_SECERT="fengfang-secret-code";

    public static SecretKey generalKey() {
        byte[] encodedKey = DatatypeConverter.parseBase64Binary(JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static String generatorToken(Map<String,Object> claims){
        long nowMillis = System.currentTimeMillis();
        SecretKey secretKey = generalKey();
        Date now  = new Date(System.currentTimeMillis());
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setIssuer("")
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + expireTime))
                .signWith(signatureAlgorithm,secretKey);
        return jwtBuilder.compact();
    }

    public static CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(JWT_ERRCODE_EXPIRE);
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrCode(JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    public static Claims parseJWT(String jwtToken) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwtToken)
                .getBody();
    }

}
