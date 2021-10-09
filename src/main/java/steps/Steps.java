package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import managers.PageManager;

public class Steps {
    private final PageManager pageManager = PageManager.getPageManager();

    @Допустим("^Закрытия сообщения cookies$")
    public void closeCookiesDialog() {
        pageManager.getHomePage().closeCookiesDialog();
    }

    @И("^Выбираем \"(.+)\" в главном меню$")
    public void selectBaseMenu(String nameMenu) {
        pageManager.getHomePage().selectBaseMenu(nameMenu);
    }

    @Пусть("^Выбираем \"(.+)\" в подменю главного меню$")
    public void closeCookiesDialog(String nameSubMenu) {
        pageManager.getHomePage().selectSubMenu(nameSubMenu);
    }

    @И("^Убираем галочку с поля \"(.+)\"$")
    public void checkBox(String operation, String checkBoxName) {
        pageManager.getMortgagePage().checkOrUncheckBox(operation,checkBoxName);
    }
    @И("^Проверяем заполнение полей$")
    public void checkData(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getCheckAndInputPage().checkMessageAtField((String) key, (String) value));
    }

    @И("^Подождать загрузку данных")
    public void sleep() {
        pageManager.getCheckAndInputPage().sleep();
    }
}
