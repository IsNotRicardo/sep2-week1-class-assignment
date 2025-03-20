import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        this.shoppingCart = new ShoppingCart();
    }

    @Test
    void testAddItem() {
        shoppingCart.addItem(10.0, 3);
        shoppingCart.addItem(5.6, 4);
        shoppingCart.addItem(2.52, 5);
        assertEquals(3, shoppingCart.getItems().size());
    }

    @Test
    void testGetTotalValue() {
        shoppingCart.addItem(10.0, 3);
        shoppingCart.addItem(5.6, 4);
        shoppingCart.addItem(2.52, 5);
        assertEquals(65.0, shoppingCart.getTotalValue());
    }
}
