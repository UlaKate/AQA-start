package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.BirdsLoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@DisplayName("Класс тестов на авторизацию пользователя")

public class Birds extends BaseBirds{

    BirdsLoginPage birdsLoginPage = new BirdsLoginPage();

    @DisplayName("Проверяем что есть предупреждение о куках")
    @Test
    void fillFormTests(){
        birdsLoginPage.openPage();
        //$(".cookie-alert__content__text").shouldBe(hidden);
        $(withText("Мы используем файлы cookie. ")).shouldBe(visible);
        //$(withText("Мы используем файлы cookie. ")).shouldBe(hidden);
        Configuration.holdBrowserOpen=false;
    }

    @Tags({
            @Tag("Web"),
            @Tag("Smoke")
    })
    @DisplayName("При вводе не корректных данных появляется предупреждение")
    @Test
    void user() {
       birdsLoginPage
               .openPage()
               .chooseLogin()
               .setLogin("Проверка@проверка.ру")
               .setPassword("123456789!")
               .confirmLoginPassword()
               .checkBlockErrors("Неверный логин или пароль");

    }

    @Tag("Web")
    @Disabled("ID44")
    @Test
    void fieldLoginEmpty(){
        open("https://bb1birds.ru/");
        $(".i-user").click();
        $("[name=USER_PASSWORD]").setValue("123456789");
        $("input[type=submit][name=Login]").click();
        $(withText("Неверный логин или пароль.")).shouldBe(visible);
        Configuration.holdBrowserOpen=false;

    }

    @Tag("Web")
    @Disabled("ID45")
    @Test
    void fieldPasswordEmpty(){
        open("https://bb1birds.ru/");
        $(".i-user").click();
        $("[name=USER_LOGIN]").setValue("логин-почта");
        $("input[type=submit][name=Login]").click();
        $(withText("Неверный логин или пароль.")).shouldBe(visible);
        Configuration.holdBrowserOpen=false;
    }
}
