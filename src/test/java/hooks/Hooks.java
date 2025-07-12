package hooks;

import java.net.MalformedURLException;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import utils.DriverFactory;

public class Hooks {

    // Runs before every scenario
    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        System.out.println("[Before Scenario] " + scenario.getName());
        DriverFactory.initDriver();
    }

    // Runs after every step
    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println("  ← AfterStep: " + scenario.getName());
    }

    // Runs before every step
    @BeforeStep
    public void beforeStep(Scenario scenario) {
        System.out.println("  → BeforeStep: " + scenario.getName());
    }

    // Runs after every scenario
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("[After Scenario] " + scenario.getName() + 
                           " — status: " + scenario.getStatus());
        if (scenario.isFailed()) {
            // optional: take screenshot 
        }
        DriverFactory.quitDriver();
    }
}