public class Main {
    public static void main(String[] args) {
// Choose storage (CSV / JSON / XML)
        Storage storage = new CSVStorage();
        Storage xmlstorage = new XMLStorage();
        // FileStorage storage = new XMLStorage();

        LibraryService service = new LibraryService(storage);
        LibraryService xmlservice = new LibraryService(xmlstorage);

        // service.addBook(new Book(1, "Harry Potter", "J.K. Rowling"));
        // service.addBook(new Book(2, "The Hobbit", "J.R.R. Tolkien"));
        // service.addBook(new Book(3, "Da Vinci Code", "Dan Brown"));

        
        // service.viewAll();

        
        // service.update(2, "The Hobbit - Updated", "J.R.R. Tolkien");

        
        // service.viewAll();

        
        // service.delete(1);

       
        // service.viewAll();




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