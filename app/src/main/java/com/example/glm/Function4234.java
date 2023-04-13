package com.example.glm;

import android.content.SharedPreferences;

public class Function4234 {
  public final void setPassword(String loginDetail, String emailPass, String password) {
    if(!loginDetail.isEmpty() && !emailPass.isEmpty()){
        String[] parts = emailPass.split(":");
        String decryptedEmail = decrypt(parts[0]);
        if(decryptedEmail.equals(loginDetail)){
            String encryptedPassword = encrypt(password);
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString(emailPassKey, decryptedEmail + ":" + encryptedPassword);
            editor.apply();
        }
    }
} 

//Assuming the following helper methods are available:

private String decrypt(String s) {
    //implementation
    return "";
}

private String encrypt(String s) {
    //implementation
    return "";
} 

//Assuming the following sharedPrefs object is initialized:

SharedPreferences sharedPrefs; 
String emailPassKey = "emailPass";
}