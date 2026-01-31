package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']" +
                    "//child::button[text()='Add to cart']";
    private final By title = By.cssSelector("[data-test='title']");
    private final By cartCounter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleIsDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }
    public void addGoodsToCart(int goodsIndex) {

        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(goodsIndex).click();
    }

    public String checkContrValue() {
        return driver.findElement(cartCounter).getText();

    }

    public String checkCountrColor() {
        return driver.findElement(cartCounter).getCssValue("background-color");
    }
}
