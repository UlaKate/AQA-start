package quru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import model.TestJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.Json;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.impl.Cleanup.of;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileParsingTest {

    private ClassLoader cl = FileParsingTest.class.getClassLoader();
    private static final Gson gson = new Gson();

    @Test
    void pdfFileParsingTest() throws Exception {
        open("https://samplelib.com/ru/sample-pdf.html");
        File downloaded = $("[href*='pdf/sample5.pdf']").download(); // метод download() возвращает обьект с типом File
        PDF pdf = new PDF(downloaded);
        Assertions.assertEquals("samplelib.com", pdf.author);
        Assertions.assertTrue(pdf.numberOfPages == 5);

}
    @Test
    void xslsFileParsingTest() throws Exception{
        open("https://excelvba.ru/programmes/Teachers?ysclid=lfcu77j9j9951587711");
        File downloaded = $("[href*='https://ExcelVBA.ru/sites/default/files/teachers.xls']").download();
        XLS xls = new XLS(downloaded);
        //System.out.println("");
        String actualValue = xls.excel.getSheet("База данных").getRow(7).getCell(11).getStringCellValue();
        Assertions.assertTrue(actualValue.contains("ИТУС"));
    }

    @Test
    void csvFileParsingTest() throws Exception{
        try(InputStream is = cl.getResourceAsStream("tabl/data_password.csv"); // мы прочитали в этот InputStream содержимое вот этого файла data_password.csv и можем его от туда достать
            CSVReader csvReader = new CSVReader(new InputStreamReader(is))){    // все что пишем в try все будет потом закрыто
            List<String[]> data = csvReader.readAll();

            Assertions.assertEquals(9, data.size());
            Assertions.assertArrayEquals(new String[] {"30", "Неверный логин или пароль."}, data.get(8));

        }
    }

    @Test
    void zipFileParsingTest() throws Exception{
        try(InputStream is = cl.getResourceAsStream("001.zip");
            ZipInputStream zis = new ZipInputStream(is)){
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null){
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void jsonFileParsingTest() throws Exception{
        try(InputStream is = cl.getResourceAsStream("testjson.json");
        Reader reader = new InputStreamReader(is)){
            JsonObject actual = gson.fromJson(reader, JsonObject.class);

            Assertions.assertEquals("ROZETOCHKA@mail.com", actual.get("email").getAsString());
            Assertions.assertEquals(19, actual.get("companies").getAsInt());

            JsonObject inner = actual.get("tasks").getAsJsonObject();

            Assertions.assertEquals("Екатерина", inner.get("Title").getAsString());
        }
    }

    @Test
    void jsonFileParsingImproovedTest() throws Exception{
        try(InputStream is = cl.getResourceAsStream("testjson.json");
            Reader reader = new InputStreamReader(is)){
            TestJson actual = gson.fromJson(reader, TestJson.class);

            Assertions.assertEquals("ROZETOCHKA@mail.com", actual.getEmail());
            Assertions.assertEquals(19, actual.getCompanies());
            Assertions.assertEquals("Екатерина", actual.getTasks().getTitle());
        }
    }
}
