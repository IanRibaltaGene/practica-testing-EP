package data;

import exception.NullPasswordException;
import exception.WrongFormatPasswordException;

//Password for cl@ve permanente
final public class Password {
    private final String password;

    public Password(String password) throws NullPasswordException, WrongFormatPasswordException {
        if(password == null){
            throw new NullPasswordException("Null password not allowed");
        }
        if(!isValidPassword(password)){
            throw new WrongFormatPasswordException("Password must be longer than 7 characters and have " +
                    "an undersocre letter, an uppercase letter, digits and special characters");
        }
        this.password = password;
    }

    public static boolean isValidPassword(String password){
        if (password.length() < 8) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int position = 0; position < password.length(); position++) {
            char c = password.charAt(position);
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasLowerCase && hasUpperCase && hasDigit && hasSpecialChar;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Password password1 = (Password) o;

        return getPassword().equals(password1.getPassword());
    }

    @Override
    public int hashCode() {
        return getPassword().hashCode();
    }

    @Override
    public String toString() {
        return "Password{" +
                "password='" + password + '\'' +
                '}';
    }
}
