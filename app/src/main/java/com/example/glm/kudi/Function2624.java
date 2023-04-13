package com.example.glm.kudi;

import java.security.KeyStore;

public class Function2624 {
  public boolean isKeystoreContainAlias(String str) throws PFSecurityException {

   PFSecurityUtils.log("Alias to be checked: " + str);
   try {
      KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
      keystore.load(null, null); // load empty keystore
      if (keystore == null) {
         return false;
      }
      boolean containsAlias = keystore.containsAlias(str);
      if (containsAlias) {
         return true;
      }
      return false;
   } catch (Exception e) {
       PFSecurityUtils.logError("Error checking keystore for alias: " + str, e);
      throw new PFSecurityException("Error checking keystore for alias: " + str, e);
   }
}
}