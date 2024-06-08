package gn.moria.nounkouke.tenin.util;


import gn.moria.nounkouke.tenin.model.TokenInput;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwtParserBuilder;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenUtil {
    private static String secret ="8030828320380202hfdhdh2302-hh3fd-h2h-3fdh";
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(TokenInput input) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime()* 1000000 + 1000000);

        return Jwts.builder()
                .signWith(key)
                .setAudience("tenin-ui")
                .setClaims(input.getClaims())
                .setSubject(input.getSubject())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .compact();
    }

    public static Claims getClaimsFromToken(String token) {
        //JwtParserBuilder.unsecured()
        var builder = new DefaultJwtParserBuilder();
        return builder.build().parseUnsecuredClaims(token).getPayload();
       // return Jwts.parser().build().parseUnsecuredClaims(token).getPayload();

    }

    public static String getSubject(String token) {
        return getClaimsFromToken(token).getSubject();
    }

}