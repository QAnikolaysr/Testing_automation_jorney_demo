package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {
       WebDriver driver;

       public LoginPage(WebDriver driver) {
              this.driver = driver;
       }
       public void open() {
       driver.get("https://www.saucedemo.com/");
       }
}
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //driver.findElement(By.id("user-name")).sendKeys(Keys.CONTROL + "A");
        //driver.findElement(By.id("user-name")).sendKeys(Keys.BACK_SPACE);
        //driver.findElement(By.cssSelector("[data-test=password]")).sendKeys("secret_sauce");
        //driver.findElement(By.cssSelector("[name='login-button']")).click();
