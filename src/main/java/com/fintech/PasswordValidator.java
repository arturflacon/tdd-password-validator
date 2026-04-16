package com.fintech;

public class PasswordValidator {

    private static final String SPECIAL_CHARS = "!@#$%^&*";

    public boolean validate(String password) {
        if (password == null) return false;
        return hasMinimumLength(password)
            && hasUpperCase(password)
            && hasLowerCase(password)
            && hasDigit(password)
            && hasSpecialChar(password)
            && hasNoWhitespace(password);
    }

    private boolean hasMinimumLength(String password) {
        return password.length() >= 8;
    }

    private boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    private boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

    private boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    private boolean hasSpecialChar(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(c) >= 0) return true;
        }
        return false;
    }

    private boolean hasNoWhitespace(String password) {
        return !password.contains(" ");
    }
}
