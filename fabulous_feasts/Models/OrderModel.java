package com.example.fabulous_feasts.Models;

public class OrderModel {
    Integer id;
    String orderName;
    String total;
    String address;
    String contact;

    public OrderModel(int id, String orderName, String total, String address, String contact) {
        this.id = id;
        this.orderName = orderName;
        this.total = total;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getTotal() {
        return total;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}