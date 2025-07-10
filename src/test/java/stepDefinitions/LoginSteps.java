package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("the app is launched")
    public void launchApp() {}

    @When("I enter valid credentials")
    public void enterCredentials() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("testpass");
        loginPage.tapLogin();
    }

    @Then("I should be navigated to home screen")
    public void verifyHome() {
        Assert.assertTrue(loginPage.isHomeScreenVisible());
    }
}
