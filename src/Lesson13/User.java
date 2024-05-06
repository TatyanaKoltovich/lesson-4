package Lesson13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String login;
    private String password;
    private String confirmPassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws LoginException {
        Pattern pattern = Pattern.compile("^[A-Za-z]{5,20}$");
        Matcher matcher = pattern.matcher(login);
        if (matcher.find()) {
            this.login = login;
        } else {
            throw new LoginException("Login is incorrect");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordException {
        //Pattern pattern = Pattern.compile("[\\S][A-Za-z]{5,20}[\\d]{1,10}]");
        Pattern pattern = Pattern.compile("^[A-Za-z]{5,20}[\\d]{1,10}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            this.password = password;
        } else {
            throw new PasswordException("Password is incorrect");
        }
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String password, String confirmPassword) throws ConfirmPasswordException {
        if (password.equals(confirmPassword)) {
            this.confirmPassword = confirmPassword;
        } else {
            throw new ConfirmPasswordException("Confirm password is incorrect");
        }
    }
}
