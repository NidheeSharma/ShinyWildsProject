package Utils;

import com.github.javafaker.Faker;
import model.SignupData;

public class FakerDataGenerator {

    private static final Faker faker = new Faker();

    public static SignupData generateValidSignupData() {
        SignupData data = new SignupData();
        String password = "Test@" + faker.number().digits(4);

        data.setEmail(faker.internet().emailAddress());
        data.setUsername(faker.name().username());
        data.setPassword(password);
        data.setConfirmPassword(password);
        data.setFirstName(faker.name().firstName());
        data.setLastName(faker.name().lastName());
        data.setAddress(faker.address().streetAddress());
        data.setPhoneNumber(faker.phoneNumber().subscriberNumber(10));
        data.setCity(faker.address().city());
        data.setPostCode(faker.address().zipCode());

        return data;
    }
}
