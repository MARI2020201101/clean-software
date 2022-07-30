package proxy.ch02;

import java.util.Objects;

class ProductData {
    public String name;
    public int price;
    public String sku;

    public ProductData(String name, int price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public ProductData() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return price == that.price && Objects.equals(name, that.name) && Objects.equals(sku, that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, sku);
    }
}
