package com.example.glm;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Function9769 {
  
private final String sha256(String str) {
    try {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = messageDigest.digest(str.getBytes("UTF-8"));
        BigInteger hashBigInt = new BigInteger(1, hashBytes);
        String hashString = hashBigInt.toString(16);
        int paddingLength = 32 - hashString.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hashString;
        } else {
            return hashString;
        }
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        // Handle exception
        return null;
    }
}
}