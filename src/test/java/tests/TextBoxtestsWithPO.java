package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxtestsWithPO extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


        @Test
        void fillFormTests(){
            registrationPage
                    .openPage()
                    .setFirstName("Передали имя")
                    .setLastName("Передали фамилию")
                    .setEmail("Peredali@mail.ru")
                    .setNumber("9062043613")
                    .setCurrentAddress("Передали адрес улица Новая дом 4 квартира 44")
                    .choiceGender()
                    .setDateOfBirth("00", "00","00")
                    .setSubjects("Math")
                    .setHobbies("Reading")
                    .setStateCity("Uttar Pradesh")
                    .setCity("Lucknow")
                    .upload("img/001.png");





           
            $("#submit").click();

            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            //$(".table-responsive").shouldHave(text("89998886655"), text("test@mail.ru"));
            //Selenide.refresh();
        }
}
