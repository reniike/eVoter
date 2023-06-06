package com.example.evoter.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.evoter.exceptions.WrongPasswordException;

public class AppUtils {
    public static final int ONE = 1;
    public static final String VOTER_REGISTERED_SUCCESSFULLY = "Voter with %s registered successfully";
    public static final String VOTER_WITH_EMAIL_EXISTS = "Voter with %s exists";
    public static final String VOTER_SUCCESSFULLY_LOGGED_IN = "Voter successfully logged in";

    public static String hashPassword(String password){
        int complexity = 10;
        BCrypt.Hasher hasher = BCrypt.withDefaults();
        String hashedPassword = hasher.hashToString(complexity, password.toCharArray());
        return hashedPassword;
    }

    public static boolean checkPassword(String password, String hashedPassword) throws WrongPasswordException {
        if (password.equals(hashedPassword)){
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword.getBytes());
            return result.verified;
        }else throw new WrongPasswordException("Password doesn't match!");
    }
}
