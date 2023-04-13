package com.example.glm;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Function15220 {
  public byte[] encryptRsaPlainText(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException, IOException {
   Cipher cipher = Cipher.getInstance("RSA");
   cipher.init(Cipher.ENCRYPT_MODE, publicKey);
   byte[] encryptedBytes = cipher.doFinal(bArr);
   return encryptedBytes;
}
}