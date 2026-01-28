package tests;

import org.testng.annotations.Test;
import pages.ProductsPage;
public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isTitleIsDisplayed();
        productsPage.addGoodsToCart("Sauce Labs Onesie");
        productsPage.addGoodsToCart("Sauce Labs Fleece Jacket");
        productsPage.addGoodsToCart("Test.allTheThings() T-Shirt (Red)");
assertEquals
    }
}
