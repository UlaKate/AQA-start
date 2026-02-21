package tests;

import com.codeborne.selenide.Configuration;
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
        Configuration.baseUrl = "https://testpages.eviltester.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTests(){
        open("/pages/forms/text-inputs/");
        $("#text-input").setValue("Имя");
        $("#search-input").setValue("Емейл");
        $("#password-input").setValue("Адрес");
        $("#text-default-input").setValue("fffffffff");
        $(".form-submit-buttons input[value='submit']").scrollIntoView(true).shouldBe(visible).click();
        $(".td-content").shouldHave(text("Form Submission"));

    }
}