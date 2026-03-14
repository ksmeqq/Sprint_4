package ru.qa_scooter.praktikum_services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderStatusPage {
    private WebDriver driver;

    private By orderText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderText() {
        return driver.findElement(orderText).getText();
    }
    public void waitOrderText() {
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(orderText));
    }
}
