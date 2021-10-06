package utils;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class FakeDataGenerator {

    Faker faker = new Faker();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String password = faker.internet().password();
}
