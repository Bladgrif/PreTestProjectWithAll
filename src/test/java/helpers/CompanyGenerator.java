package helpers;

import com.github.javafaker.Faker;
import model.CreateCompany;


import java.util.Locale;

public class CompanyGenerator {
    static Faker faker = new Faker(new Locale("en"));

    public static CreateCompany generateCompany() {
        CreateCompany company = new CreateCompany()
                .setName((faker.company().name()))
                .setDescription(faker.company().industry());
        return company;
    }
}
