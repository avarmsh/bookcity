import inventory.Inventory;
import products.*;

public class Main {
    public static double calculateTotalPrice(Inventory<? extends Product> inventory) {
        double total = 0;
        for (Product p : inventory.getItems()) {
            total += p.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Notebook> notebookInventory = new Inventory<>();
        Inventory<Accessory> accessoryInventory = new Inventory<>();

        Book book1 = new Book("The Maze Runner", 22.99, "James Dashner", "Delacorte Press", "Science Fiction");
        Book book2 = new Book("Harry Potter", 29.99, "J.K. Rowling", "Bloomsbury", "Fantasy");
        bookInventory.addItems(book1);
        bookInventory.addItems(book2);

        Notebook notebook1 = new Notebook("Spiderman Notebook", 12.50, 80, true);
        Notebook notebook2 = new Notebook("Barbie Notebook", 8.50, 50, false);
        notebookInventory.addItems(notebook1);
        notebookInventory.addItems(notebook2);

        Accessory accessory1 = new Accessory("Highlighter", 40.00, "Black");
        Accessory accessory2 = new Accessory("Mug", 150.00, "Silver");
        accessoryInventory.addItems(accessory1);
        accessoryInventory.addItems(accessory2);

        System.out.println("#All Books :");
        bookInventory.displayAll();
        System.out.println("\n#All Notebooks :");
        notebookInventory.displayAll();
        System.out.println("\n#All Accessories :");
        accessoryInventory.displayAll();

        bookInventory.removeItemsById("12");
        notebookInventory.removeItemsById("21");
        System.out.println("\nSome items were sold.");
        System.out.println("Total price of remaining books: " + calculateTotalPrice(bookInventory));
        System.out.println("Total price of remaining notebooks: " + calculateTotalPrice(notebookInventory));
        System.out.println("Total price of remaining accessories: " + calculateTotalPrice(accessoryInventory));

        System.out.println("\nSearching for items:");
        Product foundBook = bookInventory.findItemsById(11);
        if(foundBook != null){
            System.out.println("Found: " + foundBook);
        }

        Product notFound = bookInventory.findItemsById(21);
        if(notFound != null){
            System.out.println("Found: " + notFound);
        }

        bookInventory.applyDiscount("The Maze Runner", 10);
        accessoryInventory.applyDiscount("Mug", 15);

        System.out.println("\n#All of the items in bookstore (after discount) :");
        bookInventory.displayAll();
        notebookInventory.displayAll();
        accessoryInventory.displayAll();
    }
}