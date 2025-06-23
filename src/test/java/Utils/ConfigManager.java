package Utils;

public class ConfigManager {
    public static String getSite() {
        return System.getProperty("site", "shinyWilds");
    }

    public static String getLoginValidationMessage(){
        return System.getProperty("loginValidation", "loginValidationMessage");
    }

    public static String getAccountValidationMessage(){
        return System.getProperty("myAccountValidation", "myAccountValidationMessage");
    }
}
