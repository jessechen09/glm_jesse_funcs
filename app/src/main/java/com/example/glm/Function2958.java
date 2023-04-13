package com.example.glm;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.jetbrains.annotations.NotNull;

public class Function2958 {
  
public static final String aesEncrypt(@NotNull String keyAlias, @NotNull String stringToEncrypt) {
    try {
        // Generate a secret key using the given key alias
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom(keyAlias.getBytes(StandardCharsets.UTF_8));
        keyGenerator.init(new KeyGenParameterSpec.Builder(keyAlias, KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build(), secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();

        // Create a cipher object and initialize it with the secret key
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Get the initialization vector and convert it to a byte array
        byte[] iv = cipher.getIV();

        // Convert the string to be encrypted to a byte array using UTF-8 encoding
        byte[] stringToEncryptBytes = stringToEncrypt.getBytes(StandardCharsets.UTF_8);

        // Encrypt the byte array using the cipher object
        byte[] encryptedBytes = cipher.doFinal(stringToEncryptBytes);

        // Encode the encrypted data and the IV using Base64 encoding
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        String ivBase64 = Base64.getEncoder().encodeToString(iv);

        // Concatenate the encrypted data and IV with an underscore and return the result
        return encryptedBase64 + "_" + ivBase64;

    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
        // Log the error message and return null
        System.err.println("Error encrypting string: " + e.getMessage());
        return null;
    }
}
}