package com.example.glm;

import android.content.Context;
import android.icu.util.Calendar;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.security.auth.x500.X500Principal;

public class Function2630 {
  private final byte[] rsaEncrypt(Context context, byte[] bArr, String str) throws Exception {
    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
    keyStore.load(null);
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_RSA, "AndroidKeyStore");
    if (!keyStore.containsAlias(str)) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.YEAR, 1);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        KeyGenParameterSpec keyInfo = new KeyGenParameterSpec.Builder(str, KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setCertificateSubject(new X500Principal("CN=" + str))
                .setCertificateSerialNumber(BigInteger.ONE)
                .setCertificateNotBefore(start.getTime())
                .setCertificateNotAfter(end.getTime())
                .setUserAuthenticationRequired(false)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                .build();
        keyStore.setEntry(str, new KeyStore.PrivateKeyEntry(keyPair.getPrivate(), new Certificate[]{keyStore.getCertificate("")}), null);
    }
    KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(str, null);
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
    cipher.init(Cipher.ENCRYPT_MODE, privateKeyEntry.getCertificate().getPublicKey());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
    cipherOutputStream.write(bArr);
    cipherOutputStream.close();
    byte[] encryptedBytes = byteArrayOutputStream.toByteArray();
    Log.d("RSA Encryption", "Encrypted Bytes: " + Arrays.toString(encryptedBytes));
    return encryptedBytes;
}
}