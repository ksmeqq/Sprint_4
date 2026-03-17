package ru.qa_scooter.praktikum_services.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected static final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
