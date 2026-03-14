package ru.qa_scooter.praktikum_services.tests;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.qa_scooter.praktikum_services.base.BaseTest;
import ru.qa_scooter.praktikum_services.pages.HomePage;
import ru.qa_scooter.praktikum_services.pages.OrderPage;
import ru.qa_scooter.praktikum_services.pages.OrderStatusPage;

import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class ScooterOrderPositiveTest {
    public WebDriver driver;

    private final String firstName;
    private final String secondName;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String dateOrder;
    private final String days;
    private final String expected;
    private final String browser;
    private final String nameButton;

    public ScooterOrderPositiveTest(String firstName, String secondName, String address, String subway, String phoneNumber, String dateOrder, String days, String expected, String browser, String nameButton) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
        this.days = days;
        this.expected = expected;
        this.browser = browser;
        this.nameButton = nameButton;
    }

    @Parameterized.Parameters(name = "Тест #{index}, браузер: {8}, ОР: {7}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Иван", "Иванов", "мск, ул улица 2", "Бульвар Рокоссовского", "81234567890", "10.03.2026", "двое суток", "Заказ оформлен", "firefox", "Нижняя"},
                {"Глеб", "Егоров", "спб, гастелло 13", "Черкизовская", "+79999999999", "14.03.2026", "сутки", "Заказ оформлен", "chrome", "Верхняя"},
        };
    }

    @Test
    public void OrderTest() {
        BaseTest baseTest = new BaseTest();
        driver = baseTest.setBrowser(browser);
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButton(nameButton);

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setFirstName(firstName);
        orderPage.setSecondName(secondName);
        orderPage.setAddress(address);
        orderPage.setSubway(subway);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.waitDateField();
        orderPage.setDateOrder(dateOrder);
        orderPage.setRentalPeriod(days);
        orderPage.clickOrderButton();
        orderPage.waitConfirmButton();
        orderPage.clickConfirmButton();

        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        orderStatusPage.waitOrderText();
        String actual = orderStatusPage.getOrderText();
        MatcherAssert.assertThat(actual, startsWith(expected));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
