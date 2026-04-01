import java.util.List;

public class LibraryService {
    Storage storage;
    public LibraryService(Storage storage){
        this.storage = storage;
    }

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
