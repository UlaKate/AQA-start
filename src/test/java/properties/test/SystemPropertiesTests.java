package properties.test;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void systemPropertiesTests(){
        System.setProperty("browser", "firefox");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    };
}
