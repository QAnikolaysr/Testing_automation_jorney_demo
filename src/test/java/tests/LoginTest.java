package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isTitleIsDisplayed(),"Заголовок не виден");

        String titleName = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(titleName, "Products", "Не верный заголовок");
    }

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");


        boolean errorIsDisplayed = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        assertTrue("Нет сообщения об ошибке", errorIsDisplayed);
        assertEquals(driver.findElement(By.cssSelector("[data-test='error']")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Не верный текст сообщения об ошибке");
    }
}