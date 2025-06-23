package model;

public class SignupDataWrapper {

    private SignupData signupWithValidData;
    private SignupData signupWithInvalidData;
    private SignupData myAccountData;


    public SignupData getSignupWithValidData() {
        return signupWithValidData;
    }

    public void setSignupWithValidData(SignupData signupWithValidData) {
        this.signupWithValidData = signupWithValidData;
    }

    public SignupData getSignupWithInvalidData() {
        return signupWithInvalidData;
    }

    public void setSignupWithInvalidData(SignupData signupWithInvalidData) {
        this.signupWithInvalidData = signupWithInvalidData;
    }

    public SignupData getMyAccountData() {
        return myAccountData;
    }

    public void setMyAccountData(SignupData myAccountData) {
        this.myAccountData = myAccountData;
    }
}
