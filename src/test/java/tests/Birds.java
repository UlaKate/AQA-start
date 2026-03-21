package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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
    @DisplayName("При вводе не корректных данных появляется предупреждение22222")
    @ParameterizedTest(name = "При вводе не корректной почты {0} появляется предупреждение")
    @ValueSource(strings = {"яяяяя@яяяя.яя", "1111111@1111.11", "qqqqqq@qqq.qq"
    })
    void user(String login) {
       birdsLoginPage
               .openPage()
               .chooseLogin()
               .setLogin(login)
               .setPassword("123456789!")
               .confirmLoginPassword()
               .checkBlockErrors("Неверный логин или пароль.");

    }


    @CsvSource(value = {
            "1234561111111111111111 | Неверный логин или пароль.",
            "УУУУУУУУУУУУ | Неверный логин или пароль."
    }, delimiter = '|')
    @ParameterizedTest(name = "правильный пароль {0} появляется предупреждение {1}")
    @DisplayName("При вводе пустой почты и правильного пароля появляется предупреждение")
    @Tag("Web")
    void fieldLoginEmpty(String correctPassword, String errors){
        birdsLoginPage
                .openPage()
                .chooseLogin()
                .setLogin("")
                .setPassword(correctPassword)
                .confirmLoginPassword()
                .checkBlockErrors(errors);


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
