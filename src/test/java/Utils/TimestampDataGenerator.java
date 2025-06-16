package Utils;

import model.SignupData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampDataGenerator {
    private static String generateTimestamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static SignupData generateValidSignupData() {
        SignupData data = new SignupData();
        String timestamp = generateTimestamp();
        String password = "Test@" + timestamp.substring(7); // e.g., Test@123456

        data.setEmail("test" + timestamp + "@example.com");
        data.setUsername("User" + timestamp);
        data.setPassword(password);
        data.setConfirmPassword(password);
        data.setFirstName("TestFirst" + timestamp.substring(10));
        data.setLastName("TestLast" + timestamp.substring(10));
        data.setAddress("123 Main Street");
        data.setPhoneNumber(timestamp.substring(8)); // e.g., 999123456
        data.setCity("TestCity");
        data.setPostCode("123456");

        return data;
    }
}
