package assignment;

/**
 *
 * @author theli
 */
public class Daily {
    private Item item;
    private int quantitySold;
    private String salesDate;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantitySold;
    }

    public void setQuantity(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }
    
}
