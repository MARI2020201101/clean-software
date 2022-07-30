package proxy.ch02;

import java.util.HashSet;
import java.util.Set;

class DB {
    public static Set<ProductData> productDatas = new HashSet<>();
    public static Set<OrderData> orderDatas = new HashSet<>();

    public static void store(ProductData productData) {
        productDatas.add(productData);
    }

    public static ProductData getProductData(String sku) {
        return productDatas.stream()
                .filter(p-> p.sku.equals(sku))
                .findFirst()
                .orElseThrow();
    }

    public static void deleteProductData(String sku) {
        ProductData productData = productDatas.stream()
                .filter(p -> p.sku.equals(sku))
                .findFirst()
                .orElseThrow();
        productDatas.remove(productData);
    }

    public static OrderData getOrderData(int orderId) {
        return orderDatas.stream()
                .filter(o-> o.orderId==orderId)
                .findFirst()
                .orElseThrow();
    }

    public static OrderData newOrder(String customerName) {
        int orderId = orderDatas.size()+1;
        OrderData orderData = new OrderData(customerName, orderId);
        orderDatas.add(orderData);
        return orderData;
    }
}
