package com.example.ecommerce;

public class OrderModel {
    private String OrderNo;
    private String customerName;
    private String customerNumber;
    private String customerCity;
    private String customerAddress;
    private String itemExpense;
    private String deliverCharges;
    private String orderTrackingNumber;
    private String courier;
    private String orderPlacingDate;
    private String orderStatus;
    private String uid;

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getItemExpense() {
        return itemExpense;
    }

    public void setItemExpense(String itemExpense) {
        this.itemExpense = itemExpense;
    }

    public String getDeliverCharges() {
        return deliverCharges;
    }

    public void setDeliverCharges(String deliverCharges) {
        this.deliverCharges = deliverCharges;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getOrderPlacingDate() {
        return orderPlacingDate;
    }

    public void setOrderPlacingDate(String orderPlacingDate) {
        this.orderPlacingDate = orderPlacingDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderModel(String orderNo, String customerName, String customerNumber, String customerCity, String customerAddress, String itemExpense, String deliverCharges, String orderTrackingNumber, String courier, String orderPlacingDate, String orderStatus, String uid) {
        OrderNo = orderNo;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerCity = customerCity;
        this.customerAddress = customerAddress;
        this.itemExpense = itemExpense;
        this.deliverCharges = deliverCharges;
        this.orderTrackingNumber = orderTrackingNumber;
        this.courier = courier;
        this.orderPlacingDate = orderPlacingDate;
        this.orderStatus = orderStatus;
        this.uid = uid;
    }

    public OrderModel() {
    }
}
