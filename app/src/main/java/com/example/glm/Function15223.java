package com.example.glm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class Function15223 {
  public byte[] encryptCipherText(Cipher cipher, byte[] bArr) throws GeneralSecurityException, IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
    cipherOutputStream.write(bArr);
    cipherOutputStream.close();
    return byteArrayOutputStream.toByteArray();
}
}