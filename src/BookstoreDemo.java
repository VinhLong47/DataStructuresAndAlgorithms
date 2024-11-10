import model.Book;
import model.Order;

import java.util.*;

public class BookstoreDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderProcessingSystem bookSystem = new OrderProcessingSystem();

        // Creating some orders and queue them
        List<Book> bookList1 = Arrays.asList(
                new Book("Whispers of the Forgotten Forest", "Andy James", 2),
                new Book("Echoes of the Midnight Sea", "Sophia Bennett", 1),
                new Book("The Last Ember of Winter", "Liam Foster", 5),
                new Book("Beneath a Broken Sky", "Isabella Murphy", 3),
                new Book("Tales from the Wandering Shore", "Noah Grant", 20),
                new Book("The Keeper of Lost Memories", "Ava Cooper", 5),
                new Book("Beyond the Starlit Veil", "Lucas Ramirez", 14));

        List<Book> bookList2 = Arrays.asList(
                new Book("Java Basics", "Author A", 2),
                new Book("Data Structures", "Author B", 1));


        Order order1 = new Order(101, "Olivier", "123 Somewhere St", bookList1);
        Order order2 = new Order(102, "Kim", "Nowhere Av", bookList2);

        bookSystem.placeOrder(order1);
        bookSystem.placeOrder(order1);
        bookSystem.placeOrder(order1);

        bookSystem.placeOrder(order2);
        bookSystem.placeOrder(order1);

        boolean exit = false;
        System.out.println("Welcome to the Interactive Bookstore System!");

        while (!exit) {
            System.out.println("//===========Welcome to the Bookstore System!==================//");
            System.out.println("Choose an option:");
            System.out.println("1. View Current Order");
            System.out.println("2. Process Current Order");
            System.out.println("3. Search An Order");
            System.out.println("4. View All Orders");
            System.out.println("5. Sort Books In Order");
            System.out.println("6. Exit");
            System.out.println("//=============================================================//");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> bookSystem.viewCurrentOrder();
                case 2 -> bookSystem.processOrder();
                case 3 -> {
                    System.out.print("Enter the order number to search: ");
                    int orderNumber = scanner.nextInt();
                    bookSystem.searchOrder(orderNumber);
                }
                case 4 -> bookSystem.displayAllOrders();
                case 5 -> {
                    System.out.println("\nChoose sorting criteria for books:");
                    System.out.println("1. Sort by Title");
                    System.out.println("2. Sort by Author");
                    System.out.println("3. Sort by Quantity");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (sortChoice) {
                        case 1 -> {
                            bookSystem.sortOrdersByBookTitle();
                            System.out.println("Books sorted by Title.");
                        }
                        case 2 -> {
                            bookSystem.sortOrdersByBookAuthor();
                            System.out.println("Books sorted by Author.");
                        }
                        case 3 -> {
                            bookSystem.sortOrdersByBookQuantity();
                            System.out.println("Books sorted by Quantity.");
                        }
                        default -> System.out.println("Invalid choice. Please select an option from 1 to 3.");
                    }
                }
                case 6 -> exit = true;
                default -> System.out.println("Invalid choice. Please select an option from 1 to 6.");
            }
        }

        System.out.println("Thank you for using the Bookstore System. Goodbye!");
    }
}
