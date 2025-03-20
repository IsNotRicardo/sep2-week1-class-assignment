public record CartItem(double unitPrice, int quantity) {
    public double getTotalPrice() {
        return unitPrice * quantity;
    }
}
