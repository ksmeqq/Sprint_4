package ru.qa_scooter.praktikum_services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    private By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodButton = By.xpath(".//span");
    private By orderButton = By.xpath(".//Button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By confirmButton = By.xpath(".//Button[text()='Да']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void setSubway(String subway) {
        driver.findElement(subwayField).sendKeys(subway);
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='" + subway + "']")));
        driver.findElement(By.xpath(".//div[text()='" + subway + "']/parent::button")).click();
    }
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void setDateOrder(String dateOrder) {
        driver.findElement(dateField).sendKeys(dateOrder);
    }
    public void setRentalPeriod(String days) {
        driver.findElement(rentalPeriodButton).click();
        driver.findElement(By.xpath(".//div[text()='"+ days +"']")).click();
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }
    public void waitDateField() {
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(dateField));
    }
    public void waitConfirmButton() {
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
    }

}
