package com.example.glm.kudi;

import android.util.Log;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class Function2620 {
    private static final String TAG = "";

    private final KeyStore loadKeyStore() throws PFSecurityException {
   KeyStore keyStore;
   try {
       keyStore = KeyStore.getInstance("AndroidKeyStore");
       keyStore.load(null);
   } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
       String errorMessage = "Error loading keystore: " + e.getMessage();
       int errorCode = PFSecurityException.KEYSTORE_LOADING_ERROR;
       PFSecurityException pfSecurityException = new PFSecurityException(errorMessage, errorCode);
       Log.e(TAG, errorMessage, e);
       throw pfSecurityException;
   }
   return keyStore;
}
}