package com.example.glm;

import org.apache.commons.codec.binary.Base64;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class Function2961 {
  
public static final String rsaEncrypt(@NotNull String keyAlias, @NotNull String stringToEncrypt) {
    try {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        Certificate cert = keyStore.getCertificate(keyAlias);
        PublicKey publicKey = cert.getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] stringBytes = stringToEncrypt.getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherStream = new CipherOutputStream(outputStream, cipher);
        cipherStream.write(stringBytes);
        cipherStream.close();
        byte[] encryptedBytes = outputStream.toByteArray();
        return new String(Base64.encodeBase64(encryptedBytes));
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}