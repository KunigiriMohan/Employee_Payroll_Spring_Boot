package com.application.EmployeePayrollApp.utility;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @Component : Component of Application
 */
@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SECRET_KEY = "secret";

    /**
     * Method to Create Token
     * @param claims
     * @param subject
     * @return : Token
     */
    public String createToken(Map<String, Object> claims, String subject) {
            return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    /**
     * Mehtod to Generate token
     * @param username
     */
    public String generateToken(String username) {
            Map<String, Object> claims = new HashMap<String, Object>();
            return createToken(claims, username);
    }
   /**
    * Method to get User name from token
    * @param token
    * @return
    */
    public String getUsernameFromToken(String token) {
            Claims claim = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claim.getSubject();
    }

    /**
    * Method to Check token is valid or not
    * @param token
    * @return
    */
    public boolean isValidToken(String token) {
            String username = getUsernameFromToken(token);
            if(username == null || username.equals(""))
                    return false;
            return true;
    }
}
