package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Birds {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1400*450";
        Configuration.baseUrl = "https://bb1birds.ru/";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTests(){
        open("https://bb1birds.ru/");
        //$(".cookie-alert__content__text").shouldBe(hidden);
        $(withText("Мы используем файлы cookie. ")).shouldBe(visible);
        //$(withText("Мы используем файлы cookie. ")).shouldBe(hidden);
    }

    @Test
    void user(){
        open("https://bb1birds.ru/");
        $(".i-user").click();
        //$(byName("USER_LOGIN")).setValue("qwert");
        $("[name=USER_LOGIN]").setValue("7878454");
        //$("input[type=password][name=USER_PASSWORD]").setValue("gfhgfh");
        $("[name=USER_PASSWORD]").setValue("4545df");
        $("input[type=submit][name=Login]").click();
        $(withText("Неверный логин или пароль.")).shouldBe(visible);
    }
}
