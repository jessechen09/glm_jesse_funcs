package com.example.glm;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Function2960 {
  public static final String rsaDecrypt(@NotNull String keyAlias, @NotNull String encryptedString) {
    if (keyAlias == null || encryptedString == null) {
        return null;
    }
    try {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        Key key = keyStore.getKey(keyAlias, null);
        if (key != null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedString);
            CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(decodedBytes), cipher);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int nextByte;
            while ((nextByte = cipherInputStream.read()) != -1) {
                byteArrayOutputStream.write((byte) nextByte);
            }
            return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
        }
    } catch (Exception e) {
        System.out.println("An error occurred while decrypting: " + e.getMessage());
    }
    return null;
}
}