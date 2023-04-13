package com.example.glm;

import javax.crypto.spec.SecretKeySpec;

public class Function4226 {
  public final SecretKeySpec getSecretKey() {
    byte[] keyBytes = "mySecretKey".getBytes(); // Replace "mySecretKey" with your desired key
    SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES"); // "AES" is the algorithm name
    return secretKey;
}
}