package model;

import java.util.List;

public class Order {
    public int orderNumber;
    public String customerName;
    public String shippingAddress;
    public List<Book> books;

    public Order(int orderNumber, String customerName, String shippingAddress, List<Book> books) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.books = books;
    }

        @Override
    public String toString() {
            return "Order Number: " + orderNumber + " for " + customerName + " - " + shippingAddress + "\nBooks: " + books;
    }
}
