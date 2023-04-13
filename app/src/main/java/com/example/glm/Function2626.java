package com.example.glm;

import android.content.Context;
import android.security.keystore.*;
import java.security.*;
import javax.crypto.*;

public class Function2626 {
  private final boolean generateKeyIfNecessary(Context context, KeyStore keyStore, String str, boolean z) {
    try {
        if (keyStore.containsAlias(str)) {
            return true;
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(str, KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                .setUserAuthenticationRequired(z)
                .build());
        keyGenerator.generateKey();
        return true;
    } catch (KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
        e.printStackTrace();
        return false;
    }
}
}