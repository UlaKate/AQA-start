package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.BirdsLoginAreaComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
}
