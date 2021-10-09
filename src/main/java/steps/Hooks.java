package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.InitManager;
import pages.MortgagePage;


public class Hooks {

    @Before
    public void before() {
        InitManager.initFramework();
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            new MortgagePage().takeScreenshot();
        }
        InitManager.quitFramework();
    }
}
