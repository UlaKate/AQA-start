package tests;

import org.junit.jupiter.api.*;

public class SimpleJunitTest {

    int result;

    @BeforeAll
    static void BeforeAll(){
        System.out.println("BeforeAll()\n");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("AfterAll()\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach(){
        System.out.println("afterEach()\n");
        result = 0;
    }

    @Test
    void firstTest() {
        System.out.println("firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("thirdTest()");
                Assertions.assertTrue(result > 0);
    }

    private int getResult(){
        return 3;
    }

}