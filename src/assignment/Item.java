package assignment;

public class Item {
    private String itemCode;
    private String itemName;
    private double price;
    private String supplier;

    public Item(String itemCode, String itemName, double price, String supplier) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.supplier = supplier;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                '}';
    }
}