package com.example.glm;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Function4219 {
  
public static String encrypt(String str, String str2, String str3) throws Exception {
    String initializationVector = str.substring(0, 16);
    String secretKey = str2.substring(0, 16);

    IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector.getBytes("UTF-8"));
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

    byte[] encryptedBytes = cipher.doFinal(str3.getBytes());

    return Base64.getEncoder().encodeToString(encryptedBytes);
}
}