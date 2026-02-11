package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TitleNaming {
    PRODUCTS("Products", "Prod"),
    CART("Your Cart", "Cart"),
    CHECKOUT("Checkout: Your Information", "Your Inform");


    private final String displayName;
    private final String shortName;
}
