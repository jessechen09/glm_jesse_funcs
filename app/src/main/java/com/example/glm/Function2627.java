package com.example.glm;

import android.content.Context;
import android.icu.util.Calendar;
import android.security.KeyPairGeneratorSpec;
import java.math.BigInteger;
import java.security.*;
import java.security.NoSuchAlgorithmException;
import javax.security.auth.x500.X500Principal;

public class Function2627 {
  private final boolean generateKeyOld(Context context, String str, boolean z) {
    try {
        // Create a Calendar instance for the current date and one for 25 years from now
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.YEAR, 25);

        // Create a KeyPairGeneratorSpec.Builder instance and set the alias, subject, serial number, start and end date of the key
        KeyPairGeneratorSpec.Builder builder = new KeyPairGeneratorSpec.Builder(context);
        builder.setAlias(str);
        builder.setSubject(new X500Principal("CN=" + str));
        builder.setSerialNumber(BigInteger.ONE);
        builder.setStartDate(start.getTime());
        builder.setEndDate(end.getTime());

        // Build the KeyPairGeneratorSpec and use the KeyPairGenerator to initialize and generate the key
        KeyPairGeneratorSpec spec = builder.build();
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        generator.initialize(spec);

        // Return true if key generation was successful
        return true;
    } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
        e.printStackTrace();
        return false;
    }
}
}