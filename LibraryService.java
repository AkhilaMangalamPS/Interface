/**
 * Class to validate inputs and perform CRUD operations in book storage.
 * This class performs functions such as adding,updating and deleting and retrieving book object.
 */

import java.util.List;

public class LibraryService {
    Storage storage;

    /**
     * Constructor for Library Service class
     * @param storage storage interface used for book
     */
    public LibraryService(Storage storage){
        this.storage = storage;
    }

    /**
     * Adds a new book to the system after validating inputs
     * @param book the book to be added
     */
    public void addBook(Book book){
        String error = validateBook(book);
        if(error != null){
            System.out.println("Error: " + error);
            return;
        }

        List<Book> books = storage.read();
        for(Book b : books){
            if(b.getId() == book.getId()){
                System.out.println("Error : Duplicate ID");
                return;
            }
        }
        books.add(book);
        storage.write(books);
        System.out.println("Book added successfully");
    
    }

    /**
     * To display the available books.
     */
    public void viewAll(){
        List<Book> books = storage.read();

        if(books.isEmpty()){
            System.out.println("No books available");
            return;
        }
        else{
            System.out.println(books);
        }
    }

    /**
     * Update the details of existing book after validating inputs.
     * @param id Unique Id of the book which is to be updated
     * @param title new title of the new book
     * @param author author of new book
     */
    public void update(int id, String title, String author){
        if(title == null || title.trim().isEmpty()){
            System.out.println("Error: Invalid Title");
            return;
        }
        if (author == null || author.trim().isEmpty()){
            System.out.println("Error: Invalid author");
            return;
        }
        List<Book> books = storage.read();
        boolean found = false;

        for(Book b : books){
            if(b.getId() == id){
                b.setTitle(title.trim());
                b.setAuthor(author.trim());
                found = true;
            }
        }
        if(!found){
            System.out.println("No such book exists");
            return;
        }
        storage.write(books);
        System.out.println("Book updated successfully");
    }

    /**
     * Delete an existing book from the system after validating input.
     * @param id Unique Id of the book to be deleted
     */
    public void delete(int id){
        List<Book> books = storage.read();

        boolean remove = books.removeIf(b -> b.getId() == id);

        if(!remove){
            System.out.println("No such book exist");
            return;
        }
        storage.write(books);
        System.out.println("Book deleted");
    }



    /**
     * Validate the given book object
     * @param book The book object to be validated
     * @return an error message if validation fails , otherwise null
     */
    private String validateBook(Book book){

        if (book == null){
            return "Book cannot be null";
        }
        if(book.getId()<0){
            return "Invalid ID";
            
        }
        if(book.getTitle() == null || book.getTitle().trim().isEmpty()){
            return "Title cannot be empty";
        }
        if(book.getAuthor() == null || book.getAuthor().trim().isEmpty()){
            return "Author cannot be empty";
        }
        return null;
    }
    
}
