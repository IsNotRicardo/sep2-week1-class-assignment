import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartItemTest {
    @Test
    void testGetTotalPrice() {
        CartItem cartItem1 = new CartItem(10.0, 3);
        CartItem cartItem2 = new CartItem(5.6, 4);
        CartItem cartItem3 = new CartItem(2.52, 5);
        assertEquals(30.0, cartItem1.getTotalPrice());
        assertEquals(22.4, cartItem2.getTotalPrice());
        assertEquals(12.6, cartItem3.getTotalPrice());
    }
}
