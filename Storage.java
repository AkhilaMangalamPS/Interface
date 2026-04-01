import java.util.*;

interface Storage{
    List<Book> read();
    void write(List<Book> books);

}