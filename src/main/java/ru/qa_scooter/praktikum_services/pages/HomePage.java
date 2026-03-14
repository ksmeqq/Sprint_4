package ru.qa_scooter.praktikum_services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By headerOrderButton = By.xpath(".//Button[@class='Button_Button__ra12g']");
    private By middleOrderButton = By.xpath(".//Button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton(String nameButton) {
        if (nameButton == "Верхняя") {
            driver.findElement(headerOrderButton).click();
        } else if (nameButton == "Нижняя"){
            WebElement element = driver.findElement(middleOrderButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(middleOrderButton).click();
        }
    }
}
