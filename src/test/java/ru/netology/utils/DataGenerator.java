package ru.netology.utils;

import com.github.javafaker.Faker;
import ru.netology.models.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {

    }

    /**
     * @param numberOfDaysToAdd the number of days to increment the current date
     * @return Incremented date represented by String in dd.MM.yyyy format
     */
    public static String incrementCurrentDateByDays(int numberOfDaysToAdd) {
        return LocalDate.now().plusDays(numberOfDaysToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static User createRandomUser() {
       return new User(faker.name().firstName(), faker.name().lastName(), faker.phoneNumber().phoneNumber());
    }
}
