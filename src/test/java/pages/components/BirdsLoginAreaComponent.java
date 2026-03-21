package pages.components;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class BirdsLoginAreaComponent {
    public void checkErrors(String value){
        $("#login-area").shouldHave(text(value));
    }
}
