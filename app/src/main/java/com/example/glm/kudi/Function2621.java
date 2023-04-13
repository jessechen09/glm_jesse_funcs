package com.example.glm.kudi;

import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Function2621 {
  
public String decode(String str, String str2) throws PFSecurityException {
    try {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decodedBytes = Base64.decodeBase64(str2.getBytes());
        String decodedString = new String(decodedBytes, Charset.forName("UTF-8"));
        return decodedString;
    } catch (Exception ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        throw new PFSecurityException("Error while decoding data");
    }
}
}