package ru.qa_scooter.praktikum_services.tests;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.hamcrest.MatcherAssert;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class HomeFAQListWhenClickOpenTheRelevantTextTest {
    public WebDriver driver;
    private final By accordionButton;
    private final By accordionPanel;
    private final String expectedText;

    public HomeFAQListWhenClickOpenTheRelevantTextTest(By accordionButton, By accordionPanel, String expectedText) {
        this.accordionButton = accordionButton;
        this.accordionPanel = accordionPanel;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {By.id("accordion__heading-0"), By.xpath(".//div[@id='accordion__panel-0']/p"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
        };
    }

    @Test
    public void HomeFAQListTest() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(accordionButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel));
        String actual = driver.findElement(accordionPanel).getText();
        MatcherAssert.assertThat(actual, is(expectedText));

    }
    @After
    public void teardown() {
        driver.quit();
    }
}
