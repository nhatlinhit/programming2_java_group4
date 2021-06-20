import java.util.Scanner;

public class CheckPassword {
public static void main(String[] args) throws Exception {
    System.out.println("Enter a password.");
    Scanner input = new Scanner(System.in);

    String password = input.next();

    try {
        validatePassword(password);
    } catch (PasswordException e) {
        System.out.println(e.getMessage());
    }
}

public static void validatePassword(String password) throws PasswordException {
    if (password.length() < 20 && password.length() > 6) {
        throw new PasswordException("Password length is greater than 6 and less than 20 characters");
    }

    boolean upperCheck = false;
    boolean lowerCheck = false;
    boolean digitCheck = false;
    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) {
            upperCheck = true;
        }

        if (Character.isLowerCase(c)) {
             lowerCheck = true;
        }
        if (Character.isDigit(c)) {
              digitCheck = true;  
        }
    }

    if (!upperCheck) {
        throw new PasswordException("There must be an uppercase character");
    }

    if (!lowerCheck) {
        throw new PasswordException ("There must be a lowercase character");
    }

    if (!digitCheck) {
        throw new PasswordException ("There must a be a digit");
    }

    System.out.println("Valid password.");
    validPa
}

static class PasswordException extends Exception {

    public PasswordException() {
        super("Invalid password");
    }

    public PasswordException(String message) {
        super("Invalid password: " + message);
    }
}
}