package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegistrationPage;
import utils.TestRandomData;


import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

@DisplayName("Класс Тестов на регистрацию нового пользователя")

public class TextBoxtestsWithPO extends TestBase {


    private static final Logger log = LoggerFactory.getLogger(TextBoxtestsWithPO.class);
    RegistrationPage registrationPage = new RegistrationPage();
    TestRandomData data = new TestRandomData();

       @Tags({
               @Tag("Web"),
               @Tag("Smoke")
       })
       @Test
       @Feature("Создание заявки на регистрацию")
       @Story("Форма регистрации")
       @Owner("Уланова")
       @DisplayName("Тест на заполнение всех полей")
        void fillFormTests() {
           SelenideLogger.addListener("allure", new AllureSelenide());

           step("открываем сайт", () -> {
               registrationPage
                       .openPage()
                       .scrinshots("Делаем скриншот страницы");
                        attachment("Source", webdriver().driver().source());

           });

           step("Вводим персональный данные", () -> {
               registrationPage
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
                       .scrinshots("Сделан скриншот формы с заполненными полями");


           });


           step("Кликаем на кнопку подтвердить", () -> {
               registrationPage
                       .confirmRegistration()
                       .scrinshots("Подтвержденная форма");
           });

           step("Проверяем введенные данные c - " + data.emai, () -> {
               registrationPage
                       .checkResultTable("Student Name", data.firstName + " " + data.lastName)
                       .checkResultTable("Student Email", data.emai)
                       .checkResultTable("Gender", data.gender)
                       .checkResultTable("Mobile", data.phoneNumber)
                       .checkResultTable("Date of Birth", data.day + " " + data.month + "," + data.year)
                       .checkResultTable("Subjects", data.subject)
                       .checkResultTable("Hobbies", data.hobbie)
                       .checkResultTable("Picture", data.picture)
                       .checkResultTable("Address", data.currentAddress)
                       .checkResultTable("State and City", data.state + " " + data.city);
           });




        }

        @Tag("Web")
        @Test
        @DisplayName("Заполнив все обязательные поля должно появиться модальное окно с заполнеными данными")
        void fillRequiredFields(){
            SelenideLogger.addListener("allure", new AllureSelenide());
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

        @Tag("Web")
        @Test
        void missFillingFields(){
            SelenideLogger.addListener("allure", new AllureSelenide());
            registrationPage
                    .openPage()
                    .confirmRegistration()
                    .checkWindowRegistration();
        }

        @Tag("Web")
        @Disabled("ID 4444")
        @Test
        void fillNotRequiredFields(){
            SelenideLogger.addListener("allure", new AllureSelenide());
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
