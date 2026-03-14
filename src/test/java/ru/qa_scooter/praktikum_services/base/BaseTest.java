package ru.qa_scooter.praktikum_services.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    private WebDriver driver;



    public WebDriver setBrowser(String browser) {
        if (browser == "chrome") {
            this.driver = new ChromeDriver();
        } else if (browser == "firefox") {
            this.driver = new FirefoxDriver();
        }
        return driver;
    }
}
