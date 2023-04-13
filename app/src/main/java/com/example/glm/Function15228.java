package com.example.glm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Function15228 {
  private byte[] decryptCipherText(Cipher cipher, byte[] bArr) throws IOException {
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
        try (CipherInputStream inputStream = new CipherInputStream(new ByteArrayInputStream(bArr), cipher)) {
            byte[] buffer = new byte[256];
            int numBytesRead;
            while ((numBytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, numBytesRead);
            }
        }
        return outputStream.toByteArray();
    } catch (Exception e) {
        throw new IOException("Error decrypting cipher text", e);
    }
}
}