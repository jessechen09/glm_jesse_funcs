package com.example.glm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Function23053 {
  
public static final String m40439a(String str) {
    try {
        // Create message digest object using MD5 algorithm
        MessageDigest md = MessageDigest.getInstance("MD5");
        // Update the message digest with the input string
        md.update(str.getBytes());
        // Generate the hash from the updated message digest
        byte[] digest = md.digest();
        // Convert the hash to a BigInteger
        BigInteger bigInt = new BigInteger(1, digest);
        // Convert the BigInteger to a string with radix 16 (hexadecimal)
        String hash = bigInt.toString(16);
        // Pad the string with zeroes on the left until it is 32 characters long
//        hash = hash.padStart(32, '0');
        hash = ("00000000000000000000000000000000" + str).substring(hash.length());
        return hash;
    } catch (NoSuchAlgorithmException e) {
        // Handle error if algorithm is not available
        e.printStackTrace();
        return null;
    }
}
}