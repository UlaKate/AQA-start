package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxtests {

    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1400*450";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTests(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //executeJavaScript("$('#fixedban').remove()");
        //executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Имя");
        $("#lastName").setValue("Емейл");
        $("#userEmail").setValue("test@mail.ru");
        $("input[type=radio][value=Other]").click();
        $("#userNumber").setValue("89998886655");
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#currentAddress").setValue("sfsewfrewr");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOptionByValue("1984");
        $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Lucknow").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/001.png"));
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //$(".table-responsive").shouldHave(text("89998886655"), text("test@mail.ru"));
        //Selenide.refresh();


    }


}