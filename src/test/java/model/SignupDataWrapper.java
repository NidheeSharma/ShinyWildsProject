package model;

public class SignupDataWrapper {

    private SignupData signupWithValidData;
    private SignupData signupWithInvalidData;


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
}
