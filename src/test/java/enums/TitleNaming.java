package enums;

public enum TitleNaming {
    PRODUCTS("Products", "Prod"),
    CART("Your Cart", "Cart"),
    CHECKOUT("Checkout: Your Information", "Your Inform");
    private final String displayName;
    private final String shortName;


    TitleNaming(String displayName, String shortName) {
        this.displayName = displayName;
        this.shortName = shortName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getShortName() {
        return shortName;
    }
}

