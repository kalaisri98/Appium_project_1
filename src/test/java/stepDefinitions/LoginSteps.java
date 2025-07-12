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
    
    @When("I enter invalid credentials")
    public void enterInvalidCredentials() {
        loginPage.enterUsername("wronguser");
        loginPage.enterPassword("wrongpass");
        loginPage.tapLogin();
    }
    
    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expected) {
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(expected, actual);
    }

    @Then("I should be navigated to home screen")
    public void verifyHome() {
        Assert.assertTrue(loginPage.isHomeScreenVisible());
    }
}
