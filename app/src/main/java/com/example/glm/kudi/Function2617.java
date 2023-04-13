package com.example.glm.kudi;

import android.content.Context;
import android.security.keystore.*;

import java.io.IOException;
import java.security.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.crypto.Cipher;

public class Function2617 {
  
private final Cipher getEncodeCipher(Context context, String str, boolean z) throws PFSecurityException {
    try {
        // Create a Cipher instance
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);

        // Generate a key if necessary
        if (!keyStore.containsAlias("my_key_alias")) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA, "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(
                    "my_key_alias",
                    KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                    .build());
            keyPairGenerator.generateKeyPair();
        }

        // Initialize the Cipher with the keystore and a string
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("my_key_alias", null);
        PublicKey publicKey = privateKeyEntry.getCertificate().getPublicKey();
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher;
    } catch (IOException | CertificateException | KeyStoreException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | UnrecoverableEntryException | NoSuchProviderException | InvalidKeyException e) {
        throw new PFSecurityException(e);
    }
}
}