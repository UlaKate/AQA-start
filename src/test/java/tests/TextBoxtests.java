package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



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
        $("#firstName").setValue("Имя");
        $("#lastName").setValue("Емейл");
        $("#userNumber").setValue("89998886655");
        $("#gender-radio-3").click();
        $("#submit").click();
        //Selenide.refresh();


    }
}