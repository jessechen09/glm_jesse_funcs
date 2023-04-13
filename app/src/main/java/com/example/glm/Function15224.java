package com.example.glm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Function15224 {
    private final KeyStore keyStore = null;

    private SecretKey getOrCreateSecretKey(String str) throws GeneralSecurityException, IOException {
        // Check if a SecretKey with the given alias already exists

        SecretKey secretKey = (SecretKey) keyStore.getKey(str, null);
        if (secretKey != null) {
            return secretKey;
        }

        // If a SecretKey does not exist, create a new one using AES encryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        secretKey = keyGen.generateKey();

        // Retrieve or create a PublicKey with the same alias
        PublicKey publicKey = getOrCreatePublicKey(str);

        // Encrypt the SecretKey using the PublicKey and store it in a file
        byte[] encryptedKey = encryptKey(secretKey, publicKey);
        storeKey(str, encryptedKey);

        // Return the newly generated SecretKey
        return secretKey;
    }

    private PublicKey getOrCreatePublicKey(String str) throws GeneralSecurityException, IOException {
        // Check if a PublicKey with the given alias already exists
        PublicKey publicKey = keyStore.getCertificate(str).getPublicKey();
        if (publicKey != null) {
            return publicKey;
        }

        // If a PublicKey does not exist, create a new one
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        // Store the new PublicKey in the keystoreÒ
        CertificateFactory certificateFactory = null;
        Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(keyPair.getPublic().getEncoded()));
        keyStore.setCertificateEntry(str, certificate);

        // Return the newly generated PublicKey
        return keyPair.getPublic();
    }

    private byte[] encryptKey(SecretKey secretKey, PublicKey publicKey) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(secretKey.getEncoded());
    }

    private void storeKey(String str, byte[] encryptedKey) throws IOException, GeneralSecurityException {
        FileOutputStream fos = new FileOutputStream(str);
        fos.write(encryptedKey);
        fos.close();
    }
}