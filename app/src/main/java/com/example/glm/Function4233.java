package com.example.glm;

import java.util.ArrayList;

public class Function4233 {
  public final void checkBioMetricEnable(String loginDetail, String emailPassword) {

    if (loginDetail == null || loginDetail.equals("") || emailPassword == null || emailPassword.equals("")) {
        return;
    }

    ArrayList<String> passwords = new ArrayList<>();
    passwords.add(emailPassword);

    boolean isBioMetricEnabled = true;

    // logic to check if email and password match
    // if they don't match, set isBioMetricEnabled to true

    if (isBioMetricEnabled) {
        // biometric authentication is enabled
        System.out.println("Biometric authentication is enabled");
    } else {
        // biometric authentication is not enabled
        System.out.println("Biometric authentication is not enabled");
    }
}
}