package com.example.glm;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;

public class Function15233 {
  public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
    Claims[] claimsArray = new Claims[1];
    claimsArray[0] = claims;
    return null;
}
}