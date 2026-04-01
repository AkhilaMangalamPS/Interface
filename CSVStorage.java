/**
 * CSV Storage implementing storage interface.
 * Methods to read and write files in CSV format.
 * This class handles reading and writing from a file named "book.csv".
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class CSVStorage implements Storage{
    private final String FILE = "book.csv";

    /**
     * Reads book from the CSV file.
     * @return list of Book objects from the file.
     */
    public List<Book> read(){
        List<Book> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))){
            String line;
            while((line = br.readLine()) != null){
                try{
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0].trim());
                    String title = data[1].trim();
                    String author = data[2].trim();

                    list.add(new Book(id,title,author));

                }
                catch(Exception e){
                    System.out.println("Skipping invalid line: "+ line);
                }
                
            }
        }
        catch(Exception e){
            System.out.println("Wrong file reading!!");
        }
        return list;
    }

    /**
     * Write book to the CSV file.
     * @param books The list fo objects to be written to the file
     */
    public void write(List<Book> books){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))){
            for (Book b : books){
                bw.write(b.getId() + "," + b.getTitle() +","+ b.getAuthor());
                bw.newLine();
            }
        }
        catch(Exception e){
            System.out.println("Error writing file!!");
        }
    }

    
}
