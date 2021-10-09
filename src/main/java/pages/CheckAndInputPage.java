package pages;


import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckAndInputPage extends BasePage {

    @FindBy(xpath = "//div[contains(@data-test-id, 'realty')]//input[@inputmode='decimal']")
    private WebElement propertyValue;
    @FindBy(xpath = "//div[contains(@data-test-id, 'initial')]//input[@inputmode='decimal']")
    private WebElement initialPayment;
    @FindBy(xpath = "(//div[@class]//input[@inputmode='decimal'])[3]")
    private WebElement loanTerm;

    @FindBy(xpath = "//div[contains(@*,'result')]//span[contains(text(),'Ежемесячный платеж')]//following-sibling::span/span")
    private WebElement sumCredit;

    @FindBy(xpath = "//div[contains(@*,'result')]//span[contains(text(),'Сумма кредита')]//following-sibling::span/span")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//div[contains(@*,'result')]//span[contains(text(),'Необходимый доход')]//following-sibling::span/span")
    private WebElement icome;

    @FindBy(xpath = "//div[contains(@*,'result')]//div[contains(@*,'hint')]//span[contains(text(),'Процентная ставка')]//following-sibling::span/span")
    private WebElement rate;

    @Допустим("Заполняем поле '{nameField}' значением '{value}'")
    public CheckAndInputPage fillField(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "Стоимость недвижимости":
                fillInputField(propertyValue, value);
                element = propertyValue;
                break;
            case "Первоначальный взнос":
                fillInputField(initialPayment, value);
                element = initialPayment;
                break;
            case "Срок кредита":
                fillDateField(loanTerm, value);
                element = loanTerm;
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Ипотека'");

        }
        wait.until(ExpectedConditions.attributeToBe(element, "value", value));
        Assert.assertEquals("Поле '" + nameField + "' было заполнено некорректно",
                value, element.getAttribute("value"));
        return this;
    }
    /**
     * проверяем данные по кредиту
     */
    @И("Проверяем что под поле '{nameField}' отображается ошибка '{errMassage}'")
    public CheckAndInputPage checkMessageAtField(String nameField, String errMassage) {
        WebElement element = null;
        switch (nameField) {
            case "Сумма кредита":
                element = sumCredit;
                break;
            case "Ежемесячный платеж":
                element = monthlyPayment;
                break;
            case "Необходимый доход":
                element = icome;
                break;
            case "Процентная ставка":
                element = rate;
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Оформления страхования путешественников'");

        }
        element = element.findElement(By.xpath("./..//span"));
        Assert.assertEquals("Проверка ошибки у поля '" + nameField + "' была не пройдена",
                errMassage, element.getText());
        return this;
    }
    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
    }
}




