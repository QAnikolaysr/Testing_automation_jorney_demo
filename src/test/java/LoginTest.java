import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    WebDriver browser;

    @Test
    public void firstLogin(){
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("[data-test=password]")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean titleIsDisplayed = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
        assertTrue("Заголовок не виден", titleIsDisplayed);

        String titleName = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(titleName, "Products", "Не верный заголовок");

    }
    @Test
    public void incorrectLogin() {

        browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
        browser.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean errorIsDisplayed = browser.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        assertTrue("Нет сообщения об ошибке", errorIsDisplayed);

        assertEquals(browser.findElement(By.cssSelector("[data-test='error']")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Не верный текст сообщения об ошибке");
    }






}