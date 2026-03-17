package ru.qa_scooter.praktikum_services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By headerOrderButton = By.xpath(".//Button[@class='Button_Button__ra12g']");
    private By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private By accordionButton;
    private By accordionPanel;

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

    public void setAccordionButton(String question) {
        accordionButton = By.xpath(".//div[text()='"+question+"']");
    }

    public void  setAccordionPanel(String question) {
        accordionPanel = By.xpath(".//div[text()='" + question + "']/parent::div/parent::div/div[@class='accordion__panel']");
    }

    public void clickAccordionButton() {
        WebElement element = driver.findElement(accordionButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionButton).click();
    }
    public String getTextAccordionPanel() {
        return driver.findElement(accordionPanel).getText();
    }
    public void waitAccordionPanel() {
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel));
    }
}
