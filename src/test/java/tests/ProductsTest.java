package tests;

import org.testng.annotations.Test;
import pages.ProductsPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList = new ArrayList<>(
            List.of("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie")
    );

    @Test
    public void checkGoodsAdded() {
        System.out.println("ProductsTest.correct!!!!! in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.checkTitleName(), "Products");
        assertTrue(productsPage.isTitleIsDisplayed());

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }
        /*for (int i = 0; i < goodsList.size(); i++) {
            productsPage.addGoodsToCart(goodsList.get(i));
        }*/

        assertEquals(productsPage.checkContrValue(), "3");
        assertEquals(productsPage.checkCountrColor(), "rgba(226, 35, 26, 1)");
    }
}
