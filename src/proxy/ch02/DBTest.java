package proxy.ch02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DBTest {
    @Test
    public void testStoreProduct(){
        ProductData storedProduct = new ProductData();
        storedProduct.name="MyProduct";
        storedProduct.price=1234;
        storedProduct.sku="999";
        DB.store(storedProduct);
        ProductData retrivedProduct = DB.getProductData("999");
        DB.deleteProductData("999");
        assertEquals(storedProduct,retrivedProduct);
    }
}
