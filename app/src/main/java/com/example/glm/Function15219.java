package com.example.glm;

import android.content.Context;
import android.icu.util.Calendar;
import android.security.KeyPairGeneratorSpec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;

import javax.security.auth.x500.X500Principal;

public class Function15219 {
  public PublicKey getOrCreatePublicKey(String str) throws GeneralSecurityException, IOException {
    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null, null);
    
    if (keyStore.containsAlias(str)) {
        return keyStore.getCertificate(str).getPublicKey();
    } else {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.YEAR, 50);

        Context mContext = null;
        AlgorithmParameterSpec spec = new KeyPairGeneratorSpec.Builder(mContext)
                .setAlias(str)
                .setSubject(new X500Principal("CN=" + str))
                .setSerialNumber(BigInteger.ONE)
                .setStartDate(start.getTime())
                .setEndDate(end.getTime())
                .build();
        
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        generator.initialize(spec);

        KeyPair keyPair = generator.generateKeyPair();
        return keyPair.getPublic();
    }
}
}