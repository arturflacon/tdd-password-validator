package com.fintech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void deveRejeitarSenhaComMenosDe8Caracteres() {
        assertFalse(validator.validate("Ab1!xyz"));
    }

    @Test
    void deveRejeitarSenhaNula() {
        assertFalse(validator.validate(null));
    }

    @Test
    void deveRejeitarSenhaSemLetraMaiuscula() {
        assertFalse(validator.validate("abc1!xyz"));
    }
}
