package com.example.glm;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

import javax.crypto.Cipher;

public class Function15226 {
  
private byte[] decryptRsaCipherText(PrivateKey privateKey, byte[] bArr) throws GeneralSecurityException, IOException {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    return cipher.doFinal(bArr);
}
}