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
                new Book("The Last Ember of Winter", "Liam Foster", 7),
                new Book("Beneath a Broken Sky", "Isabella Murphy", 10),
                new Book("Data Structures", "Author B", 1));

        List<Book> bookList3 = Arrays.asList(
                new Book("The Enchanted Grove", "Emma Stone", 4),
                new Book("Secrets of the Ancient Sands", "Mason Clarke", 3),
                new Book("Journey to the Far Isles", "Harper James", 8),
                new Book("Java for Beginners", "Author C", 5),
                new Book("Mysteries of the Abyss", "Amelia Hart", 12));

        List<Book> bookList4 = Arrays.asList(
                new Book("Echoes of the Midnight Sea", "Sophia Bennett", 4),
                new Book("Data Science 101", "Author D", 6),
                new Book("Tales from the Wandering Shore", "Noah Grant", 10),
                new Book("The Keeper of Lost Memories", "Ava Cooper", 3),
                new Book("Advanced Algorithms", "Author E", 2));



        Order order1 = new Order(101, "Olivier", "123 Somewhere St", bookList1);
        Order order2 = new Order(102, "Kim", "Nowhere Av", bookList2);
        Order order3 = new Order(103, "David", "352 Road", bookList2);
        Order order4 = new Order(104, "Emily", "456 Sunset Blvd", bookList3);
        Order order5 = new Order(105, "Michael", "789 Ocean Dr", bookList4);

        bookSystem.placeOrder(order2);
        bookSystem.placeOrder(order5);
        bookSystem.placeOrder(order3);
        bookSystem.placeOrder(order4);
        bookSystem.placeOrder(order1);

        boolean exit = false;
        System.out.println("Welcome to the Interactive Bookstore System!");

        while (!exit) {
            System.out.println("//=========== Bookstore System!==================//");
            System.out.println("Choose an option:");
            System.out.println("1. View Current Order");
            System.out.println("2. Process Current Order");
            System.out.println("3. Search An Order");
            System.out.println("4. View All Orders");
            System.out.println("5. Sort Books In Order");
            System.out.println("6. Exit");
            System.out.println("//===============================================//");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> bookSystem.viewCurrentOrder(); // View current order
                case 2 -> bookSystem.processOrder(); // Process current order

                case 3 -> { // Search order
                    System.out.print("Enter the order number to search: ");
                    int orderNumber = scanner.nextInt();
                    bookSystem.searchOrder(orderNumber);
                }

                case 4 -> bookSystem.displayAllOrders(); // View all order

                case 5 -> { // Sort books in orders based on criteria
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
                case 6 -> exit = true; // exiting the code
                default -> System.out.println("Invalid choice. Please select an option from 1 to 6.");
            }
        }

        System.out.println("Thank you for using the Bookstore System!");
    }
}
