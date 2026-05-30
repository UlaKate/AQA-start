package quru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFilesTest {

    @Test
    void downloadFileTest() throws Exception{   //throws - это ключевое слово - указываем исключение про которые нужно думать - проверяемые. а значит используем или try catch или в своем методе используем throws Exception, то есть перекладываем на junit эту обработку
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloaded = $(".react-blob-header-edit-and-raw-actions [href*='main/README.md']").download(); // метод download() возвращает объект типа File

        try (InputStream is = new FileInputStream(downloaded)) {
            byte[] data = is.readAllBytes();
            String dataAsString = new String(data, StandardCharsets.UTF_8);
            Assertions.assertTrue(dataAsString.contains("Contributions to JUnit are both welcomed and appreciated"));
        }
// создается InputStream он (метод) читает из него массив байт создает строку в кодировке которую указали и конце закрывает этот InputStream через кончтрукцию try-with-resources
    }

    @Test
    void uploadFileTest(){
        open("https://pdf.io/ru/merge/");
        $("input[type='file']").uploadFromClasspath("0011.png");
        $(".modal-body div.h").shouldHave(text("Данный типа файла не поддерживается"));
    }
}
