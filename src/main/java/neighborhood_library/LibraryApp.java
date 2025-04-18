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
            books[i] = new Book()
        }
    }
}
