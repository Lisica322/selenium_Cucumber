package pages;

import io.cucumber.java.bg.И;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс описывающий страничку Ипотеки
 */
public class CreditHomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'xs-bottom')]//h1[contains(@class, 'header')]")
    private WebElement title;

    @FindBy(xpath = "//*[text()='Оформить онлайн']/../../a[@data-test-id]")
    private WebElement buttonCheckoutOnline;

    /**
     * Проверка открытия страницы, путём проверки title страницы
     *
     * @return InsurancePage - т.е. остаемся на этой странице
     */
    @И("Проверяем что открылась страница 'Ипотека от 8,1%* на готовые квартиры'")
    public CreditHomePage checkOpenInsurancePage() {
        Assertions.assertEquals("Ипотека от 8,1%* на готовые квартиры",title.getText().trim(),"Заголовок отсутствует/не соответствует требуемому");
        return this;
    }
}
