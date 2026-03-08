package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
     private   SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            gender = $("input[type=radio][value=Other]"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            stateCityList = $("#react-select-3-input"),
            cityList = $("#react-select-4-input"),
            uploadFile = $("#uploadPicture");
            CalendarComponent component = new CalendarComponent();


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //executeJavaScript("$('#fixedban').remove()");
        //executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public  RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage choiceGender(){
        gender.click();

        return this;
    }

    public RegistrationPage setDateOfBirth (String day, String month, String year){
        calendarInput.click();
        component.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value){
         subjectsInput.setValue(value).pressEnter();

         return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesCheckbox.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setStateCity(String value){
           stateCityList.setValue(value).pressEnter();

           return this;
    }

    public RegistrationPage setCity(String value){
        cityList.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage upload(String value) {
        uploadFile.uploadFromClasspath(value);

        return this;
    }
}