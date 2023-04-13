package com.example.glm.kudi;

import java.io.IOException;
import java.security.*;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Function2628 {
  private final KeyStore loadKeyStore() throws PFSecurityException {
    KeyStore keyStore;
    try {
        keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore;
    } catch (IOException e) {
        throw new PFSecurityException("Error loading keystore", PFSecurityException.ERROR_LOADING_KEYSTORE);
    } catch (KeyStoreException e) {
        throw new PFSecurityException("Error loading keystore", PFSecurityException.ERROR_LOADING_KEYSTORE);
    } catch (NoSuchAlgorithmException e) {
        throw new PFSecurityException("Error loading keystore", PFSecurityException.ERROR_LOADING_KEYSTORE);
    } catch (CertificateException e) {
        throw new PFSecurityException("Error loading keystore", PFSecurityException.ERROR_LOADING_KEYSTORE);
    }
}
}