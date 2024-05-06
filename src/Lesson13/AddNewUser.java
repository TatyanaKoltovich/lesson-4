package Lesson13;

public class AddNewUser {

    private final String stringLogin;
    private final String stringPassword;
    private final String stringConfirmPassword;

    public AddNewUser(String stringLogin, String stringPassword, String stringConfirmPassword) {
        this.stringLogin = stringLogin;
        this.stringPassword = stringPassword;
        this.stringConfirmPassword = stringConfirmPassword;
    }

    public boolean isAddUser() {

        boolean allSuccess = true;

        User user = new User();

        try {
            user.setLogin(this.stringLogin);
        } catch (LoginException logEx) {
            //logEx.printStackTrace();
            System.err.println(logEx.getMessage());
            allSuccess = false;
        }
        try {
            user.setPassword(this.stringPassword);
        } catch (PasswordException passEx) {
            //logEx.printStackTrace();
            System.err.println(passEx.getMessage());
            allSuccess = false;
        }
        try {
            user.setConfirmPassword(this.stringPassword, this.stringConfirmPassword);
        } catch (ConfirmPasswordException confirmPassEx) {
            //logEx.printStackTrace();
            System.err.println(confirmPassEx.getMessage());
            allSuccess = false;
        }
        return allSuccess;
    }
}
