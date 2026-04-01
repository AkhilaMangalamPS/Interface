/**
 * Interface for storing different types of books.
 * Defines method to read and write.
 */

import java.util.*;

interface Storage{
    /**
     * Reads the list of books from storage.
     * @return a list of Book objects recieved from storage.
     */
    List<Book> read();

    /**
     * Writes the list of books to the storage.
     * @param books list of books objects to be stored
     */
    void write(List<Book> books);

}