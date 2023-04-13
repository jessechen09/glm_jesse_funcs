package com.example.glm;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Function4221 {
  
public final String encryptText(String plainText, String encryptionKey, String encryptionIV) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptionIV.getBytes("UTF-8"));
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
    byte[] encryptedText = cipher.doFinal(plainText.getBytes());
    return Base64.getEncoder().encodeToString(encryptedText);
}
}