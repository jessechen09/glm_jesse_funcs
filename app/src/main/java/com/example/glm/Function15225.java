package com.example.glm;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;

public class Function15225 {
  private PrivateKey getPrivateKey(String str) throws GeneralSecurityException, IOException {
    // Get KeyStore instance
    KeyStore ks = KeyStore.getInstance("JKS");
    
    // Load KeyStore with no parameters
    FileInputStream fis = new FileInputStream("keystore.jks");
    ks.load(fis, null);
    
    // Get private key associated with the given string
    PrivateKey privateKey = (PrivateKey) ks.getKey(str, null);
    
    return privateKey;
} 

}