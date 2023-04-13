package com.example.glm;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Function15221 {
  public byte[] encryptAesPlainText(SecretKey secretKey, String str) throws GeneralSecurityException, IOException {
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    byte[] encrypted = encryptCipherText(cipher, str);
    return encrypted;
}

/**
* This method takes in a Cipher object and a string as parameters. It creates a byte array of the given string and encrypts it using the Cipher object. It returns the encrypted byte array.
*
* @param  cipher Cipher
* @param  str String
*
* @return  byte[]
*/
private byte[] encryptCipherText(Cipher cipher, String str) throws IOException, GeneralSecurityException {
    byte[] inputBytes = str.getBytes("UTF-8");
    byte[] encrypted = cipher.doFinal(inputBytes);
    return encrypted;
}
}