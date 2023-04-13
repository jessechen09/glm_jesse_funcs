package com.example.glm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class Function15232 {
  
public static Claims parseClaims(String str) throws UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, ExpiredJwtException {
    Claims claims = null;
    try {
        claims = Jwts.parserBuilder().setSigningKeyResolver(new SigningKeyResolverAdapter()).build().parseClaimsJws(str).getBody();
    } catch (ExpiredJwtException e) {
        claims = e.getClaims();
    } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
        // Do nothing
    }
    return claims;
}

static class SigningKeyResolverAdapter extends io.jsonwebtoken.SigningKeyResolverAdapter {
//    @Override
    public byte[] resolveSigningKeyBytes(io.jsonwebtoken.JwsHeader header, java.security.PublicKey key) {
        return new byte[0];
    }
}
}