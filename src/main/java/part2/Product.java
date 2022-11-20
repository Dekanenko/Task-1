package part2;

public class Product {
    public static final String KILO = "Kilo";
    public static final String UNIT = "Unit";

    private String name;
    private double amount = -1;
    private String measure;
    private double price = -1;

    public Product() {
    }

    public Product(String name, double amount, String measure, double price) {
        this.name = name;
        this.amount = amount;
        this.measure = measure;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getMeasure() {
        return measure;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name:"+name+"\tamount:"+amount+"\tmeasure:"+measure+"\tprice:"+price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getAmount(), getAmount()) != 0) return false;
        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (!getName().equals(product.getName())) return false;
        return getMeasure().equals(product.getMeasure());
    }
}
