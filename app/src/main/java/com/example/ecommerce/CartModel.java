package com.example.ecommerce;

public class CartModel {
    private String cartId;
    private String productName;
    private String productImage;
    private String productPrice;
    private String productQTY;
    private String sellerUid;
    public boolean is_selected;
    private String orderNumber;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQTY() {
        return productQTY;
    }

    public void setProductQTY(String productQTY) {
        this.productQTY = productQTY;
    }

    public String getSellerUid() {
        return sellerUid;
    }

    public void setSellerUid(String sellerUid) {
        this.sellerUid = sellerUid;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public CartModel(String cartId, String productName, String productImage, String productPrice, String productQTY, String sellerUid,  String orderNumber) {
        this.cartId = cartId;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productQTY = productQTY;
        this.sellerUid = sellerUid;
        this.orderNumber = orderNumber;
    }

    public CartModel() {
    }
}
