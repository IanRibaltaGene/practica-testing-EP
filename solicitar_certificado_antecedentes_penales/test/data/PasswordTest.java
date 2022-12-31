package data;

import exception.NullPasswordException;
import exception.WrongFormatPasswordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void constructorNullException(){
        Throwable nullException = assertThrows(NullPasswordException.class,
                () -> {
                    Password password = new Password(null);
                });

        assertEquals("Null password not allowed", nullException.getMessage());
    }

    @Test
    void passwordTooShort(){
        Throwable lengthException = assertThrows(WrongFormatPasswordException.class,
                () -> {
                    Password password = new Password("1aAA/A/");
                });

        assertEquals("Password must be longer than 7 characters and have " +
                        "at least a lowercase letter, an uppercase letter, a digit and a special character",
                lengthException.getMessage());
    }

    @Test
    void passedPasswordWithoutLowerCaseLetter(){
        Throwable formatException = assertThrows(WrongFormatPasswordException.class,
            () -> {
                Password password = new Password("111AA/A/");
            });

        assertEquals("Password must be longer than 7 characters and have " +
                        "at least a lowercase letter, an uppercase letter, a digit and a special character",
                formatException.getMessage());
    }
    @Test
    void passedPasswordWithoutUpperCaseLetter(){
        Throwable formatException = assertThrows(WrongFormatPasswordException.class,
                () -> {
                    Password password = new Password("111aa/a/");
                });

        assertEquals("Password must be longer than 7 characters and have " +
                        "at least a lowercase letter, an uppercase letter, a digit and a special character",
                formatException.getMessage());
    }
    @Test
    void passedPasswordWithoutSpecialCharacter(){
        Throwable formatException = assertThrows(WrongFormatPasswordException.class,
                () -> {
                    Password password = new Password("111aaAaA");
                });

        assertEquals("Password must be longer than 7 characters and have " +
                        "at least a lowercase letter, an uppercase letter, a digit and a special character",
                formatException.getMessage());
    }
    @Test
    void passedPasswordWithoutDigit(){
        Throwable formatException = assertThrows(WrongFormatPasswordException.class,
                () -> {
                    Password password = new Password("AAAaa/a/");
                });

        assertEquals("Password must be longer than 7 characters and have " +
                        "at least a lowercase letter, an uppercase letter, a digit and a special character",
                formatException.getMessage());
    }

    @Test
    void correctPassword() throws NullPasswordException, WrongFormatPasswordException {
        Password passwordLength8 = new Password("111aA/a/");
        Password passwordLength9 = new Password("111aA/a//");
        Password passwordLength20 = new Password("111aA/a//2111aA/a//2");

        assertEquals("111aA/a/", passwordLength8.getPassword());
        assertEquals("111aA/a//", passwordLength9.getPassword());
        assertEquals("111aA/a//2111aA/a//2", passwordLength20.getPassword());
    }
}