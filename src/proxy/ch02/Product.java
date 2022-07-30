package proxy.ch02;

interface Product {
    int getPrice();
    String getName();
    String getSku();
}
class ProductImp implements Product{
    private String name;
    private int price;
    private String sku;

    public ProductImp(String name, int price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSku() {
        return sku;
    }
}
class ProductProxy implements Product{
    private ProductImp productImp;
    public ProductProxy(String itsSku){
        ProductData productData = DB.getProductData(itsSku);
        ProductImp productImp = new ProductImp(productData.name, productData.price, productData.sku);
        this.productImp=productImp;
    }

    @Override
    public int getPrice() {
        return productImp.getPrice();
    }

    @Override
    public String getName() {
        return productImp.getName();
    }

    @Override
    public String getSku() {
        return productImp.getSku();
    }
}

class ProductProxyV2 implements Product{
    private String itsSku;
    public ProductProxyV2(String itsSku){
        this.itsSku = itsSku;
    }

    @Override
    public int getPrice() {
        return DB.getProductData(itsSku).price;
    }

    @Override
    public String getName() {
        return DB.getProductData(itsSku).name;
    }

    @Override
    public String getSku() {
        return DB.getProductData(itsSku).sku;
    }
}