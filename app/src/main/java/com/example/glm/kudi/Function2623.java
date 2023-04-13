package com.example.glm.kudi;

import android.content.Context;
import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Function2623 {
  
public String encode(Context context, String str, String str2, boolean z) throws PFSecurityException {
    try {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(str.getBytes());
        String base64Encoded = Base64.encodeToString(encryptedBytes, Base64.DEFAULT);
        return base64Encoded;
    } catch (Exception e) {
        throw new PFSecurityException("Error while encoding", e);
    }
}
}