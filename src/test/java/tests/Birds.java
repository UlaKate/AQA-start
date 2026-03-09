package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.BirdsLoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class Birds extends BaseBirds{

    BirdsLoginPage birdsLoginPage = new BirdsLoginPage();

    @Test
    void fillFormTests(){
        birdsLoginPage.openPage();
        //$(".cookie-alert__content__text").shouldBe(hidden);
        $(withText("Мы используем файлы cookie. ")).shouldBe(visible);
        //$(withText("Мы используем файлы cookie. ")).shouldBe(hidden);
        Configuration.holdBrowserOpen=false;
    }

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

   //@Test
    //void fieldLoginEmpty(){
        //open("https://bb1birds.ru/");
        //$(".i-user").click();
       //$("[name=USER_PASSWORD]").setValue("123456789");
       // $("input[type=submit][name=Login]").click();
        //$(withText("Неверный логин или пароль.")).shouldBe(visible);
        //Configuration.holdBrowserOpen=false;

    //}

    //@Test
    //void fieldPasswordEmpty(){
        //open("https://bb1birds.ru/");
        //$(".i-user").click();
        //$("[name=USER_LOGIN]").setValue("логин-почта");
        //$("input[type=submit][name=Login]").click();
        //$(withText("Неверный логин или пароль.")).shouldBe(visible);
        //Configuration.holdBrowserOpen=false;
    //}
}
