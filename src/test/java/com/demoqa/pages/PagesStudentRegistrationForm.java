package com.demoqa.pages;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


public class PagesStudentRegistrationForm {


    public PagesStudentRegistrationForm openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public PagesStudentRegistrationForm firstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PagesStudentRegistrationForm lastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PagesStudentRegistrationForm email(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public PagesStudentRegistrationForm gender(String gender) {
        switch (gender) {
            case "Male":
                $("#genterWrapper").$(byText("Male")).click();
                break;
            case "Female":
                $("#genterWrapper").$(byText("Female")).click();
                break;
            case "Other":
                $("#genterWrapper").$(byText("Other")).click();
                break;
        }
        return this;
    }

    public PagesStudentRegistrationForm mobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
        return this;
    }

    public PagesStudentRegistrationForm dateOfBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__month-select").selectOption(month);
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").selectOptionByValue(year);
        $("#dateOfBirth-wrapper").$(format(".react-datepicker__day--0%s", day)).click();
        return this;
    }

    public PagesStudentRegistrationForm subject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PagesStudentRegistrationForm hobbies(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public PagesStudentRegistrationForm currentAddress(String add) {
        $("#currentAddress").setValue(add);
        return this;
    }

    public PagesStudentRegistrationForm states(String state) {
        $("#state").$("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public PagesStudentRegistrationForm city(String city) {
        $("#city").$("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public PagesStudentRegistrationForm picture(String file) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + file));
        return this;
    }

    public PagesStudentRegistrationForm clickSubmit() {
        $("#submit").scrollTo().click();
        return this;
    }

    public PagesStudentRegistrationForm checkStudentName(String firstName, String lastname) {
        $x("//td[text()='Student Name']/following::td")
                .shouldHave(text(firstName + " " + lastname));
        return this;
    }

    public PagesStudentRegistrationForm checkEmail(String email) {
        $x("//td[text()='Student Email']/following::td").shouldHave(text(email));
        return this;
    }

    public PagesStudentRegistrationForm checkGender(String gender) {
        $x("//td[text()='Gender']/following::td").shouldHave(text(gender));
        return this;
    }

    public PagesStudentRegistrationForm checkMobile(String mobile) {
        $x("//td[text()='Mobile']/following::td").shouldHave(text(mobile));
        return this;
    }

    public PagesStudentRegistrationForm checkDateOfBirth(String day, String month, String year) {
        $x("//td[text()='Date of Birth']/following::td").shouldHave(text(day + " " + month + "," + year));
        return this;
    }

    public PagesStudentRegistrationForm checkSubject(String subject) {
        $x("//td[text()='Subjects']/following::td").shouldHave(text(subject));
        return this;
    }

    public PagesStudentRegistrationForm checkHobby(String hobby) {
        $x("//td[text()='Hobbies']/following::td").shouldHave(text(hobby));
        return this;
    }

    public PagesStudentRegistrationForm checkPicture(String picture) {
        $x("//td[text()='Picture']/following::td").shouldHave(text(picture));
        return this;
    }

    public PagesStudentRegistrationForm checkAddress(String address) {
        $x("//td[text()='Address']/following::td").shouldHave(text(address));
        return this;
    }

    public PagesStudentRegistrationForm checkStateAndCity(String state, String city) {
        $x("//td[text()='State and City']/following::td").shouldHave(text(state + " " + city));
        return this;
    }

}
