package Utils;

public class ConfigManager {
    public static String getSite() {
        return System.getProperty("site", "shinyWilds");
    }

    public static String getValidationMessage(){
        return System.getProperty("loginValidation", "loginValidationMessage");
    }
}
