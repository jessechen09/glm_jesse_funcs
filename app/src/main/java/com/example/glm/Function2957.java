package com.example.glm;

import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jetbrains.annotations.NotNull;

public class Function2957 {
  
public static final String aesDecrypt(@NotNull String keyAlias, @NotNull String stringToDecrypt) {
    try {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        KeyStore.SecretKeyEntry keyEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry(keyAlias, null);
        SecretKeySpec keySpec = new SecretKeySpec(keyEntry.getSecretKey().getEncoded(), "AES");

        String[] parts = stringToDecrypt.split(":");
        byte[] iv = android.util.Base64.decode(parts[0], android.util.Base64.DEFAULT);
        byte[] cipherText = android.util.Base64.decode(parts[1], android.util.Base64.DEFAULT);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        AlgorithmParameterSpec spec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, spec);
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText, StandardCharsets.UTF_8);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}