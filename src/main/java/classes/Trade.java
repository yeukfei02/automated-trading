package classes;

public class Trade {
    private String productName;
    private String direction;
    private double price;
    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if (!direction.isEmpty()) {
            if (direction.toUpperCase().equals("BUY") || direction.toUpperCase().equals("SELL")) {
                this.direction = direction;
            }
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
