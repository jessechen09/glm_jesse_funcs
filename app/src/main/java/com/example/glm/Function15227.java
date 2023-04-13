package com.example.glm;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Function15227 {
  private byte[] decryptAesCipherText(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException, IOException {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, secretKey);
    byte[] decryptedData = cipher.doFinal(bArr);
    return decryptedData;
}
}