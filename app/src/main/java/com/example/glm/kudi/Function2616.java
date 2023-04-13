package com.example.glm.kudi;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.security.*;
import javax.crypto.*;


public class Function2616 {
  private final Cipher getCipherInstance() throws PFSecurityException {
  try {
    return Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
  } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
    String errorMessage = "Error creating Cipher instance";
    int errorCode = PFSecurityUtilsErrorCodes.CIPHER_INSTANCE_CREATION_ERROR;
    PFSecurityException exception = new PFSecurityException(errorMessage, errorCode, e);
    FirebaseCrashlytics.getInstance().recordException(exception);
    throw exception;
  }
}
}