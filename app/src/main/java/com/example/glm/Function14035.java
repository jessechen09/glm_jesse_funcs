package com.example.glm;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Function14035 {
  public static final String getMd5(String str) {
    if (str == null) {
        return null;
    }
    try {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] byteArray = str.getBytes("UTF-8");
        messageDigest.update(byteArray);
        BigInteger bigInt = new BigInteger(1, messageDigest.digest());
        String hexString = bigInt.toString(16);
        while (hexString.length() < 32) {
            hexString = "0" + hexString;
        }
        return hexString;
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("MD5 algorithm not available", e);
    } catch (UnsupportedEncodingException e) {
        throw new RuntimeException("UTF-8 encoding not available", e);
    }
}
}