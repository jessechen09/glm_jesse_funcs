package com.example.glm;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Function16835 {
  
public static final String m20725c(@NotNull String str) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes();
        md.update(bytes);
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}
}