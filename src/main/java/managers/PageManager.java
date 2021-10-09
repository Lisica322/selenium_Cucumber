package managers;


import pages.CreditHomePage;
import pages.HomePage;
import pages.MortgagePage;
import pages.CheckAndInputPage;

public class PageManager {

    private CheckAndInputPage checkAndInputPage;
    private MortgagePage mortgagePage;
    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка страхование путешественников
     */
    private CreditHomePage creditHomePage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация
     */
    public CreditHomePage getCreditHomePage() {
        if (creditHomePage == null) {
            creditHomePage = new CreditHomePage();
        }
        return creditHomePage;
    }

    public CheckAndInputPage getCheckAndInputPage() {
        if (checkAndInputPage == null) {
            checkAndInputPage = new CheckAndInputPage();
        }
        return checkAndInputPage;
    }

    public MortgagePage getMortgagePage() {
        if (mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }
}
