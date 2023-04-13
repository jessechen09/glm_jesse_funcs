package com.example.glm;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Function2629 {
  private final byte[] rsaDecrypt(byte[] bArr, String str) throws Exception {
    // Load the keystore
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(new FileInputStream("keystore.jks"), "password".toCharArray());

    // Retrieve the private key entry associated with the given string
    KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(str, new KeyStore.PasswordProtection("password".toCharArray()));

    // Create a cipher with RSA encryption and the provider type
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");

    // Initialize the cipher as a decryption cipher with the private key entry
    cipher.init(Cipher.DECRYPT_MODE, keyEntry.getPrivateKey());

    // Create a ByteArrayInputStream from the byte array
    ByteArrayInputStream bis = new ByteArrayInputStream(bArr);

    // Create a CipherInputStream from the ByteArrayInputStream and the cipher
    CipherInputStream cis = new CipherInputStream(bis, cipher);

    // Create an ArrayList to store the decrypted bytes
    ArrayList<Byte> decryptedBytes = new ArrayList<Byte>();

    // Iterate through the bytes from the CipherInputStream and add them to the ArrayList
    int nextByte;
    while ((nextByte = cis.read()) != -1) {
        decryptedBytes.add((byte) nextByte);
    }

    // Create an array to store the decrypted bytes
    byte[] decryptedArr = new byte[decryptedBytes.size()];

    // Add each byte from the ArrayList to the array
    for (int i = 0; i < decryptedBytes.size(); i++) {
        decryptedArr[i] = decryptedBytes.get(i);
    }

    // Return the decrypted array
    return decryptedArr;
}
}