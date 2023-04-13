package com.example.glm.kudi;

import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.security.*;
import javax.crypto.*;

public class Function2618 {
  private static final String TAG = "";

  private final void initDecodeCipher(Cipher cipher, String str) throws PFSecurityException {
  try {
    KeyStore keyStore = loadKeyStore();
    Key key = keyStore.getKey(str, null);
    if (key instanceof PrivateKey) {
      PrivateKey privateKey = (PrivateKey) key;
      cipher.init(Cipher.DECRYPT_MODE, privateKey);
    } else {
      throw new PFSecurityException("Key is not a PrivateKey", PFSecurityException.ERROR_CODE_INVALID_KEY);
    }
  } catch (Exception e) {
    PFSecurityException securityException = new PFSecurityException("Error initializing decoding cipher", PFSecurityException.ERROR_CODE_INIT_CIPHER, (GeneralSecurityException) e);
    Log.e(TAG, "Error initializing decoding cipher", e);
    FirebaseCrashlytics.getInstance().recordException(securityException);
  }
}

  private KeyStore loadKeyStore() {
    return null;
  }
}