package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utils.DriverFactory;

public class LoginPage {
    AppiumDriver driver;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    By username = By.id("com.app:id/username");
    By password = By.id("com.app:id/password");
    By loginButton = By.id("com.app:id/login");

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void tapLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isHomeScreenVisible() {
        return driver.findElement(By.id("com.app:id/home")).isDisplayed();
    }
}
