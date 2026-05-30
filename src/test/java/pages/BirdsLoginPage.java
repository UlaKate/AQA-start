package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import pages.components.BirdsLoginAreaComponent;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.*;

public class BirdsLoginPage {

    private SelenideElement
                            login = $(".i-user"),
                            loginInput = $("[name=USER_LOGIN]"),
                            passwordInput = $("input[type=password][name=USER_PASSWORD]"),
                            submitLoginButton = $("input[type=submit][name=Login]");
                            BirdsLoginAreaComponent loginAreaComponent = new BirdsLoginAreaComponent();


    public BirdsLoginPage openPage(){
        open("https://bb1birds.ru/");

        return this;
    }

    public BirdsLoginPage chooseLogin(){
        login.click();

        return this;
    }

    public BirdsLoginPage setLogin(String value){
        loginInput.setValue(value);

        return this;
    }

    public  BirdsLoginPage setPassword(String value){
        passwordInput.setValue(value);

        return this;
    }

    public BirdsLoginPage confirmLoginPassword(){
        submitLoginButton.click();

        return this;
    }

    public BirdsLoginPage checkBlockErrors(String value){
        loginAreaComponent.checkErrors(value);

        return this;
    }

    public BirdsLoginPage scrinshots(String name){
        byte[] screenshotAsBytes = screenshot(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshotAsBytes));
        return this;
    }
}
