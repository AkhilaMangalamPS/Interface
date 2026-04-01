import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class CSVStorage implements Storage{
    private final String FILE = "book.csv";

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
        // catch(FileNotFoundException e){
        //     System.out.println("No file found!!");
        // }
        catch(Exception e){
            System.out.println("Wrong file reading!!");
        }
        return list;
    }

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
