package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class BaseBirds {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1400*450";
        Configuration.baseUrl = "https://bb1birds.ru/";
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
