package com.example.glm;

import android.security.keystore.*;
import javax.crypto.*;

public class Function2615 {
  private final boolean generateKeyIfNecessary(android.content.Context r4, java.security.KeyStore r5, java.lang.String r6, boolean r7) {
    try {
        if (r5.containsAlias(r6)) {
            return true;
        } else if (r7) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(r6, KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                    .setUserAuthenticationRequired(true)
                    .setUserAuthenticationValidityDurationSeconds(30)
                    .build());
            keyGenerator.generateKey();
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}