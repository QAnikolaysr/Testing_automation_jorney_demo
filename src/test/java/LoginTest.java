import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class LoginTest extends BaseTest {
       @Test
    public void firstLogin(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[name='login-button']")).click();
        boolean titleIsDisplayed = driver.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
        assertTrue("Заголовок не виден", titleIsDisplayed);
        String titleName = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(titleName, "Products", "Не верный заголовок");
    }
    @Test
    public void incorrectLogin() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[name='login-button']")).click();
        boolean errorIsDisplayed = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        assertTrue("Нет сообщения об ошибке", errorIsDisplayed);
        assertEquals(driver.findElement(By.cssSelector("[data-test='error']")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Не верный текст сообщения об ошибке");
    }
}
