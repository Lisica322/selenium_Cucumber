package managers;

import java.util.concurrent.TimeUnit;

import static utils.PropConst.IMPLICITLY_WAIT;
import static utils.PropConst.PAGE_LOAD_TIMEOUT;

/**
 * Класс для инициализации фреймворка
 */
public class InitManager {

    /**
     * Менеджер properties
     */
    private static final TestPropManager props = TestPropManager.getTestPropManager();

    /**
     * Менеджер WebDriver
     */
    private static final DriverManager driverManager = DriverManager.getDriverManager();

    /**

     */
    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
        driverManager.getDriver().get("http://www.sberbank.ru/ru/person");
    }

    /**
     * Завершения работы framework - гасит драйвер и закрывает сессию с браузером
     *
     * @see DriverManager#quitDriver()
     */
    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
