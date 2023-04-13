package com.example.glm;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Function4230 {
  public final String encrypt(String strToEncrypt, String secret) {
    try {
        if (strToEncrypt == null || secret == null) {
            throw new IllegalArgumentException("strToEncrypt and secret cannot be null.");
        }
        
        SecretKeySpec key = new SecretKeySpec(secret.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        byte[] utf8 = strToEncrypt.getBytes("UTF-8");
        byte[] encrypted = cipher.doFinal(utf8);
        
        return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception e) {
        System.err.println("Error encrypting string: " + e.getMessage());
        return null;
    }
}
}