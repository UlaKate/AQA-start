package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helper.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BaseBirds {
    @BeforeAll
    static void BeforeAll(){
        System.out.println("======= ДИАГНОСТИКА =======");
        System.out.println("Browser param: " + System.getProperty("browser"));

        Configuration.browser = System.getProperty("browser", "chrome");

        System.out.println("Configuration.browser: " + Configuration.browser);
        System.out.println("======= КОНЕЦ ДИАГНОСТИКИ =======");

        Configuration.browserSize = "1366x768";
        //Configuration.baseUrl = "https://bb1birds.ru/";
        //Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.holdBrowserOpen = false;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }

    @AfterEach
    void afterEach(){
        Attach.addVideo();
        WebDriverRunner.closeWebDriver();
    };
}
