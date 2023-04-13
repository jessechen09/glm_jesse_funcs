package com.example.glm;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.spec.SecretKeySpec;

public class Function4229 {
  private SecretKeySpec secretKey;

  public final void setKey(String myKey) {
  if (myKey != null) {
    try {
      byte[] keyBytes = myKey.getBytes(Charset.forName("UTF-8"));
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      byte[] keyHash = sha.digest(keyBytes);
      SecretKeySpec secretKeySpec = new SecretKeySpec(keyHash, "AES");
      this.secretKey = secretKeySpec;
    } catch (NoSuchAlgorithmException e) {
      // handle exception
    }
  } else {
    throw new IllegalArgumentException("Key cannot be null.");
  }
}
}