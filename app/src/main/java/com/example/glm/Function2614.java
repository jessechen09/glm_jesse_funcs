package com.example.glm;

import java.security.*;
import android.security.keystore.*;

public class Function2614 {
  private final boolean generateKey(String str, boolean z) {
  try {
    //Initialize KeyPairGenerator object with RSA algorithm and the AndroidKeyStore provider
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA, "AndroidKeyStore");
    //Create new KeyGenParameterSpec builder
    KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(str, KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setDigests(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA512)
    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1, KeyProperties.ENCRYPTION_PADDING_RSA_OAEP)
    .setUserAuthenticationRequired(z);

    //Generate key pair with specified parameters
    keyPairGenerator.initialize(builder.build());
    keyPairGenerator.generateKeyPair();
    return true;
  } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
    e.printStackTrace();
    return false;
  }
}
}