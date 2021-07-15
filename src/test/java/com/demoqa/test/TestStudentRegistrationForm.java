package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PagesStudentRegistrationForm;
import com.demoqa.helpers.RandomArrayElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;


public class TestStudentRegistrationForm {

    Faker faker = new Faker();
    DecimalFormat dF = new DecimalFormat("00");
    RandomArrayElement rm = new RandomArrayElement();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = rm.getRandomGender();
    String mobileNumber = faker.phoneNumber().subscriberNumber(10);
    String month = rm.getRandomMonth();
    String year = faker.random().nextInt(1900, 2100).toString();
    String day = dF.format(faker.random().nextInt(1, 28));
    String subject = rm.getRandomSubject();
    String hobby = rm.getRandomHobby();
    String address = faker.address().fullAddress();
    String state = rm.getRandomState();
    String city = rm.getRandomCity(state);
    String picture = rm.getRandomPicture();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fakerTest() {
        PagesStudentRegistrationForm registrationForm = new PagesStudentRegistrationForm();

        registrationForm.openPage()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .gender(gender)
                .mobileNumber(mobileNumber)
                .dateOfBirth(month, year, day)
                .subject(subject)
                .hobbies(hobby)
                .picture(picture)
                .currentAddress(address)
                .states(state)
                .city(city)
                .clickSubmit();

        registrationForm
                .checkStudentName(firstName, lastName)
                .checkEmail(email)
                .checkGender(gender)
                .checkMobile(mobileNumber)
                .checkDateOfBirth(day, month, year)
                .checkSubject(subject)
                .checkHobby(hobby)
                .checkPicture(picture)
                .checkAddress(address)
                .checkStateAndCity(state, city);
    }
}

