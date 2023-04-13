package com.example.glm;

import java.security.KeyStore;
import java.security.KeyStoreException;

public class Function15231 {
    private String getKeyStore() {
        String keyStore = null;
        try {
            keyStore = KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_1).toString();
        } catch (KeyStoreException e1) {
            try {
                keyStore = KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_2).toString();
            } catch (KeyStoreException e2) {
                try {
                    keyStore = KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_3).toString();
                } catch (KeyStoreException e3) {
                    // all attempts failed, return null
                    return null;
                }
            }
        }
        return keyStore;
    }

    private class Constants {
        public static final String KEYSTORE_PROVIDER_1 = "";
        public static final String KEYSTORE_PROVIDER_2 = "";
        public static final String KEYSTORE_PROVIDER_3 = "";
    }
}