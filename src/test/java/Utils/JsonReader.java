
//    public static final String FILE_PATH = "src/test/resource/urlConfig.json";
//
//    public static String getValue(String key){
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            Map<String,String> data = mapper.readValue(new File(FILE_PATH),Map.class);
//            return data.get(key);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//}

package Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.LoginData;
import model.LoginDataWrapper;
import model.SignupDataWrapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {

    // Generic method for reading key-value JSON like urlConfig.json
//    public static String getValueFromConfig(String key, String filePath) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            Map<String, String> data = mapper.readValue(new File(filePath), Map.class);
//            return data.get(key);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public static String getValueFromConfig(String siteKey, String innerKey, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Map<String, String>> data = mapper.readValue(new File(filePath), Map.class);
            return data.get(siteKey).get(innerKey);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static LoginDataWrapper getLoginData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), LoginDataWrapper.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SignupDataWrapper getSignupData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), SignupDataWrapper.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
