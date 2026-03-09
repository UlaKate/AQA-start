package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOptionByValue("1984");
        $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
    }
}
