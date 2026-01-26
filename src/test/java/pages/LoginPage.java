package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final By logininput = By.id("user-name");
    private final By passwordInput = By.cssSelector("[data-test=password]");
    private final By loginbutton = By.cssSelector("[data-test=login-button]");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(BASE_URL);
    }
    public void login(String user, String password) {
        driver.findElement(logininput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginbutton).click();
    }
    public boolean isErrorDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }
    public String getErrorText(){
         return driver.findElement(errorMsg).getText();
    }
}

