package com.example.glm;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Function4228 {
  
public final String decrypt(String str, String secret) throws Exception {
    if (secret == null) {
        throw new IllegalArgumentException("Secret key must not be null");
    }
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secret.getBytes(), "AES"));
    byte[] decodedBytes = Base64.getDecoder().decode(str);
    byte[] decryptedBytes = cipher.doFinal(decodedBytes);
    return new String(decryptedBytes);
}
}