package tests;

import io.qameta.allure.*;
import net.bytebuddy.build.Plugin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {
    @Test(invocationCount = 1, priority = 2, enabled = true, description = "тест проверяет авторизацию пользователя")
    @Epic("Тестирование интернет-площадки")
    @Feature("Проверка входа на сайт")
    @Story("GGGGGGGGGG")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Nik Rom nik@gmail.com")
    @TmsLink("Testing_automation_jorney_demo")
    @Issue("Testing_automation_jorney_demo")

    public void correctLogin() {
        System.out.println("Login Test!!!!!! in thread: " + Thread.currentThread().getName());

        loginPage.open();
        loginPage.login(withAdminPermission());

        assertTrue(productsPage.isTitleIsDisplayed(), "Заголовок не виден");
        AllureUtils.takeScreenshot(driver);
        assertEquals(productsPage.checkTitleName(), PRODUCTS.getDisplayName(), "Не верный заголовок");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {"", password, "Epic sadface: Username is required"},
                {user, "", "Epic sadface: Password is required"},
                {"Standard_user", password, "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Тестирование интернет-площадки")
    @Feature("Проверка расчета скидки")
    @Story("GGGGGGGGGG")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Nik Rom nik@gmail.com")
    @TmsLink("Testing_automation_jorney_demo")
    @Issue("Testing_automation_jorney_demo")
    @Test(dataProvider = "incorrectLoginData", description = "тест проверяет авторизацию заблокированного пользователя")
    public void incorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        AllureUtils.takeScreenshot(driver);
        assertEquals(loginPage.getErrorText(), errorMsg,
                "Не верный текст сообщения об ошибке");

    }
}
