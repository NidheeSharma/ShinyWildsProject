package model;

public class LoginDataWrapper {
    private LoginData validLogin;
    private LoginData invalidLogin;
    private LoginData emptyFields;
    private LoginData validUsernameEmptyPassword;
    private LoginData reLoginViaChangePassword;

    // Getters and Setters
    public LoginData getValidLogin() {
        return validLogin;
    }

    public void setValidLogin(LoginData validLogin) {
        this.validLogin = validLogin;
    }

    public LoginData getInvalidLogin() {
        return invalidLogin;
    }

    public void setInvalidLogin(LoginData invalidLogin) {
        this.invalidLogin = invalidLogin;
    }

    public LoginData getEmptyFields() {
        return emptyFields;
    }

    public void setEmptyFields(LoginData emptyFields) {
        this.emptyFields = emptyFields;
    }

    public LoginData getValidUsernameEmptyPassword() {
        return validUsernameEmptyPassword;
    }

    public void setValidUsernameEmptyPassword(LoginData validUsernameEmptyPassword) {
        this.validUsernameEmptyPassword = validUsernameEmptyPassword;
    }

    public LoginData getReLoginViaChangePassword() {
        return reLoginViaChangePassword;
    }

    public void setReLoginViaChangePassword(LoginData reLoginViaChangePassword) {
        this.reLoginViaChangePassword = reLoginViaChangePassword;
    }
}
