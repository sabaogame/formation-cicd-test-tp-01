package com.devops.cicd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordPolicyTest {

    @Test
    void testIsStrong_whenHasLessThan8Characters_thenFalse() {
        String password = "1234567";

        Assertions.assertFalse(PasswordPolicy.isStrong(password));
    }

    @Test
    void testIsStrong_whenHas0UppercaseLetter_thenFalse() {
        String password = "abcdefgh123";

        Assertions.assertFalse(PasswordPolicy.isStrong(password));
    }

    @Test
    void testIsStrong_whenHas0LowercaseLetter_thenFalse() {
        String password = "ABCDEFGH123";

        Assertions.assertFalse(PasswordPolicy.isStrong(password));
    }

    @Test
    void testIsStrong_whenHas0Number_thenFalse() {
        String password = "ABCDEFGHdz";

        Assertions.assertFalse(PasswordPolicy.isStrong(password));
    }

    @Test
    void testIsStrong_whenHas0SpecialCharacter_thenFalse() {
        String password = "ABCDEFGHdz";

        Assertions.assertFalse(PasswordPolicy.isStrong(password));
    }

}
