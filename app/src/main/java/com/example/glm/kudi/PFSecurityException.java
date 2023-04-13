package com.example.glm.kudi;

import java.security.GeneralSecurityException;

public class PFSecurityException extends Exception {
    public static final int ERROR_CODE_INVALID_KEY = 0;
    public static final int ERROR_CODE_INIT_CIPHER = 0;
    public static final int KEYSTORE_LOADING_ERROR = 0;
    public static final int CODE_DELETE_KEY_ERROR = 0;
    public static final int ERROR_LOADING_KEYSTORE = 0;

    public PFSecurityException(String errorMessage, int errorCode, GeneralSecurityException e) {
    }

    public PFSecurityException(Exception e) {
    }

    public PFSecurityException(String error_initializing_encryption_cipher, Exception e) {
    }

    public PFSecurityException(String key_is_not_a_privateKey, int errorCodeInvalidKey) {
    }

    public PFSecurityException(String error_while_decoding_data) {
    }

    public PFSecurityException(String keystoreAliasNotFound, String s, Exception e) {
    }
}
