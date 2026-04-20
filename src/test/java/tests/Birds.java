package tests;

import com.codeborne.selenide.Configuration;
import data.Language;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.BirdsLoginPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("КЛАСС ТЕСТОВ НА АВТОРИЗАЦИЮ ПОЛЬЗОВАТЕЛЯ")

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


    @CsvFileSource(resources = "/tabl/data_password.csv")
    @ParameterizedTest(name = "Вводиться неверный пароль {0} и появляется предупреждение {1}")
    @DisplayName("Вводиться неверный пароль и появляется предупреждение")
    @Tag("Web")
    void fieldNotCorrectPassword(String NotCorrectPassword, String errors){
        birdsLoginPage
                .openPage()
                .chooseLogin()
                .setLogin("qaz123@mail.ru")
                .setPassword(NotCorrectPassword)
                .confirmLoginPassword()
                .checkBlockErrors(errors);

    }

    //@Disabled("Пока изучаю emun")
    @EnumSource(Language.class)
    @ParameterizedTest
    void priceEurAndRub(Language lang){
        open("https://selenide.org/");
        $$("#languages a").find(text(lang.name())).click();
        $("h3").shouldHave(text(lang.discription));
    }


    static Stream<Arguments> siteShouldHaveRusAndEndButton(){
        return Stream.of(
                Arguments.of(
                        Language.EN,
                        List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                        Arguments.of(
                        Language.RU,
                        List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    @Disabled("Изучаю еще")
    @MethodSource
    @ParameterizedTest
    void siteShouldHaveRusAndEndButton(Language lang, List<String> expectedLangButton){
        open("https://selenide.org/");
        $$("#languages a").find(text(lang.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(texts(expectedLangButton));
    }
}
