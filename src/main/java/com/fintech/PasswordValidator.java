package com.fintech;

public class PasswordValidator {

    public boolean validate(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;
        boolean hasUpper = false;
        boolean hasLower = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
        }
        if (!hasUpper) return false;
        if (!hasLower) return false;
        return true;
    }
}
