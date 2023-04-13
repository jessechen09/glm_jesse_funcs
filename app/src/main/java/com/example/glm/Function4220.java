package com.example.glm;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Function4220 {
  public static String decrypt(String str, String str2, String str3) {
    try {
        // Convert str2 to IvParameterSpec
        IvParameterSpec iv = new IvParameterSpec(str2.getBytes("UTF-8"));

        // Convert str to SecretKeySpec
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");

        // Create Cipher with AES/CBC/PKCS5PADDING algorithm
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

        // Decrypt str3
        byte[] decoded = Base64.getDecoder().decode(str3);
        byte[] decrypted = cipher.doFinal(decoded);

        // Convert decrypted byte array to Base64 string
        String result = Base64.getEncoder().encodeToString(decrypted);

        return result;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}