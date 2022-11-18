package ru.dns;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    /*
    Подгрузка всех настроек
     */
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled =true;
        Configuration.browserSize = "1122x804";
        Configuration.headless = false;
        Configuration.timeout = 40000;
    }

    /*
инициализация настроек перед каждым тестом
 */
    @Before
    public void init(){
        setUp();
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
