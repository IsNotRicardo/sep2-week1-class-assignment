import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(double unitPrice, int quantity) {
        items.add(new CartItem(unitPrice, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalValue() {
        return items.stream()
            .mapToDouble(CartItem::getTotalPrice)
            .sum();
    }
}
