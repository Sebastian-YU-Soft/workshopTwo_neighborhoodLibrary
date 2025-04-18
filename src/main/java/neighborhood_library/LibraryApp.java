package neighborhood_library;

import java.util.Scanner;

public class LibraryApp {
    private static Book[] books = new Book[20];

    public static void main(String[] args){
        initializeBooks();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("Neighborhood Library");
            System.out.println("Show Available Books");
            System.out.println("Show Checked Out Books");
            System.out.println("Exit");
            System.out.print("Choose an option:");

            String choice = scanner.nextLine();

            switch (choice){
                case "1" :
                    showAvailableBooks(scanner);
                    break;
                case "2":
                    showCheckOutBooks(scanner);
                    break;
                case "3":
                    running = false;
                    System.out.println("See you next time!");
                    break;
                default:
                    System.out.println("Try Again");
            }
        }
        scanner.close();
    }
    private static void initializeBooks(){
        for (int i = 0; i < 20; i++){
            books[i] = new Book(i + 1, "ISBN" + (1000 +i), false,"Book Title" + (i +1),"");
        }
    }

    private static void showAvailableBooks(Scanner scanner){
        System.out.println("Available Books");
        for (Book book : books){
            if (!book.isCheckedOut()){
                System.out.println(book);
            }
        }
        System.out.print("Enter book ID to check out or 0 to return:" );
        int bookID = Integer.parseInt(scanner.nextLine());

        if (bookID == 0) return;

        Book book = findBookByID(bookID);
        if (book != null & !book.isCheckedOut()){
            System.out.print("Enter your name:");
            String name = scanner.nextLine();
            book.checkOut(name);
            System.out.println("Book checked out to" + name + "!");
        }else{
            System.out.println("Invalid due to ID or being checked out");
        }
    }

    private static void showCheckOutBooks(Scanner scanner){
        System.out.println("Checked Out Books");
        for (Book book : books){
            if (book.isCheckedOut()){
                System.out.println(book.toCheckedOutString());
            }
        }

        System.out.print("Enter X to return or Y to check in:");
        String input = scanner.nextLine().toUpperCase();

        if ("Y".equals(input)){
            System.out.print("Enter book ID to check in:");
            int bookId = Integer.parseInt(scanner.nextLine());

            Book book = findBookByID(bookId);
            if (book != null & book.isCheckedOut()){
                book.checkIn();
                System.out.println("Book checked in.");
            }else {
                System.out.println("Invalid ID or is no checked out.");
            }
        }
    }

    private static Book findBookByID(int id){
        for (Book book : books){
            if (book.getId() == id) return book;
        }
        return null;
    }
}
