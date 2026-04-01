/**
 * Represent book entity.
 * Contains Id, title and author used to store and manage book details.
 */

public class Book{

    private int id;
    private String title;
    private String author;

    /**
     * Constructor to initialize Book object
     * @param id unique Id of the book.
     * @param title Title fo the book.
     * @param author Author of the book
     */
    public Book(int id,String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }
    /**
     * Gets the book id
     * @return unique Id of the book.
     */
    public int getId(){
        return id;
    }

    /**
     * Gets the title of the book.
     * @return title of the book    
     */
    public String getTitle(){
        return title;
    }

    /**
     * Gets the author of the book.
     * @return Author of the book
     */
    public String getAuthor(){
        return author;
    }
    /**
     * To set the title of the book 
     * @param title Title of the book
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * To set the author of the book.
     * @param author Author of the book.
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * Display book details.
     */
    public String toString(){
        return id + " | " + title + " | "+ author;
    }
}