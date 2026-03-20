package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestRandomData;


import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxtestsWithPO extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestRandomData data = new TestRandomData();



       @Test
        void fillFormTests(){
            registrationPage
                    .openPage()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.emai)
                    .setNumber(data.phoneNumber)
                    .setCurrentAddress(data.currentAddress)
                    .choiceGender(data.gender)
                    .setDateOfBirth(data.day, data.month, data.year)
                    .setSubjects(data.subject)
                    .setHobbies(data.hobbie)
                    .setStateCity(data.state)
                    .setCity(data.city)
                    .upload(data.picture)
                    .confirmRegistration()
                    .checkResultTable("Student Name",data.firstName + " " + data.lastName)
                    .checkResultTable("Student Email", data.emai)
                    .checkResultTable("Gender", data.gender)
                    .checkResultTable("Mobile", data.phoneNumber)
                    .checkResultTable("Date of Birth",data.day + " " + data.month + "," + data.year)
                    .checkResultTable("Subjects", data.subject)
                    .checkResultTable("Hobbies", data.hobbie)
                    .checkResultTable("Picture", data.picture)
                    .checkResultTable("Address", data.currentAddress)
                    .checkResultTable("State and City", data.state + " " + data.city);

        }

        @Test
    void fillRequiredFields(){
            registrationPage
                    .openPage()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setNumber(data.phoneNumber)
                    .choiceGender(data.gender)
                    .confirmRegistration()
                    .checkResultTable("Student Name",data.firstName + " " + data.lastName)
                    .checkResultTable("Mobile", data.phoneNumber)
                    .checkResultTable("Gender", data.gender);

        }

        @Test
    void missFillingFields(){
            registrationPage
                    .openPage()
                    .confirmRegistration()
                    .checkWindowRegistration();
        }

        @Test
    void fillNotRequiredFields(){
           registrationPage
                   .openPage()
                   .setEmail(data.emai)
                   .setDateOfBirth(data.day, data.month, data.year)
                   .setSubjects(data.subject)
                   .setHobbies(data.hobbie)
                   .upload(data.picture)
                   .setCurrentAddress(data.currentAddress)
                   .setStateCity(data.state)
                   .setCity(data.city)
                   .confirmRegistration()
                   .checkWindowRegistration();
        }


}
