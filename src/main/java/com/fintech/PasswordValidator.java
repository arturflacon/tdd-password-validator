package com.fintech;

public class PasswordValidator {

    public boolean validate(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;
        return true;
    }
}
