package ru.qa_scooter.praktikum_services.tests;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.qa_scooter.praktikum_services.base.BaseTest;
import ru.qa_scooter.praktikum_services.pages.HomePage;
import ru.qa_scooter.praktikum_services.pages.OrderPage;
import ru.qa_scooter.praktikum_services.pages.OrderStatusPage;

import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class ScooterOrderPositiveTest extends BaseTest {

    private final String firstName;
    private final String secondName;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String dateOrder;
    private final String days;
    private final String expected;
    private final String nameButton;

    public ScooterOrderPositiveTest(String firstName, String secondName, String address, String subway, String phoneNumber, String dateOrder, String days, String expected, String nameButton) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
        this.days = days;
        this.expected = expected;
        this.nameButton = nameButton;
    }

    @Parameterized.Parameters(name = "Тест #{index}, ОР: {7}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Иван", "Иванов", "мск, ул улица 2", "Бульвар Рокоссовского", "81234567890", "10.03.2026", "двое суток", "Заказ оформлен", "Нижняя"},
                {"Глеб", "Егоров", "спб, гастелло 13", "Черкизовская", "+79999999999", "14.03.2026", "сутки", "Заказ оформлен", "Верхняя"},
        };
    }

    @Test
    public void orderTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButton(nameButton);

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillRenterInfo(firstName, secondName, address, subway, phoneNumber);
        orderPage.fillRentalInfo(dateOrder, days);
        orderPage.waitConfirmButton();
        orderPage.clickConfirmButton();

        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        orderStatusPage.waitOrderText();
        String actual = orderStatusPage.getOrderText();
        MatcherAssert.assertThat(actual, startsWith(expected));
    }
}
