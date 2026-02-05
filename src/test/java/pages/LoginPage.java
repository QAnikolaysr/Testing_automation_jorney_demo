package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By logIninput = By.id("user-name");
    private final By passwordInput = By.cssSelector("[data-test=password]");
    private final By loginButton = By.cssSelector("[data-test=login-button]");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        fillLoginField(user);
        fillPasswordField(password);
        driver.findElement(loginButton).click();
    }

    public void login(User user) {
        fillLoginField(user.getEmail());
        fillPasswordField(user.getPassword());
        driver.findElement(loginButton).click();
    }

    public void fillLoginField(String user) {
        driver.findElement(logIninput).sendKeys(user);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(errorMsg).getText();
    }
}
