/**
 * Main class serves as entry point to the book management system.
 * It handles input and output.
 * Initialize different types of storage like xml,csv etc.
 * 
 */

public class Main {
    /**
     * Main method is the starting point of the porgram.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Storage storage = new CSVStorage();
        Storage xmlstorage = new XMLStorage();
        

        LibraryService service = new LibraryService(storage);
        LibraryService xmlservice = new LibraryService(xmlstorage);


        xmlservice.addBook(new Book(1, "Harry Potter", "J.K. Rowling"));
        xmlservice.addBook(new Book(2, "The Hobbit", "J.R.R. Tolkien"));
        xmlservice.addBook(new Book(3, "Da Vinci Code", "Dan Brown"));

        
        xmlservice.viewAll();

        
        xmlservice.update(2, "The Hobbit - Updated", "J.R.R. Tolkien");

        
        xmlservice.viewAll();

        
        xmlservice.delete(1);

       
        xmlservice.viewAll();
    }
}