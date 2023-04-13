package com.example.glm.kudi;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class Function2613 {
  private final String decode(String str, Cipher cipher) throws PFSecurityException {
    try {
        byte[] decodedBytes = Base64.getDecoder().decode(str);
        byte[] originalBytes = cipher.doFinal(decodedBytes);
        return new String(originalBytes, StandardCharsets.UTF_8);
    } catch (BadPaddingException | IllegalBlockSizeException e) {
        String errorMessage = "Error decoding string: " + e.getMessage();
        int errorCode = PFSecurityUtilsErrorCodes.DECODING_ERROR;
        PFSecurityUtils.logError(errorMessage, errorCode);
        throw new PFSecurityException(errorMessage, errorCode, e);
    }
}

}