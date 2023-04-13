package com.example.glm;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;

public class Function15222 {
  public byte[] encryptCipherText(Cipher cipher, String str) throws GeneralSecurityException, IOException {
    byte[] byteStr = str.getBytes("UTF-8");
    byte[] encrypted = cipher.doFinal(byteStr);
    return encrypted;
}
}