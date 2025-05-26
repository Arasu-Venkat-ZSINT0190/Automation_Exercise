package utils;

import com.github.javafaker.Faker;

public class FakeDataGenerator {

    static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        // Use timestamp to avoid duplicates
        return "testing_" + System.currentTimeMillis() + "@testing.com";
    }

    public static String getPassword() {
        return faker.internet().password(8, 15);
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getZip() {
        return faker.address().zipCode();
    }

    public static String getMobileNumber() {
        return faker.phoneNumber().cellPhone().replaceAll("[^\\d]", "").substring(0, 10);
    }
}
