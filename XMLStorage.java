/**
 * CSV Storage implementing storage interface.
 * Methods to read and write files in CSV format.
 * This class handles reading and writing from a file named "book.csv".
 */
import java.io.*;
import java.util.*;

class XMLStorage implements Storage {

    private final String FILE = "book.xml";
    /**
     * Reads book from the CSV file.
     * @return list of Book objects from the file.
     */
    public List<Book> read() {
        List<Book> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            int id = 0;
            String title = "";
            String author = "";

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<id>")) {
                    String value = line.replace("<id>", "")
                                       .replace("</id>", "")
                                       .trim();
                    id = Integer.parseInt(value);
                } 
                else if (line.startsWith("<title>")) {
                    title = line.replace("<title>", "")
                                .replace("</title>", "")
                                .trim();
                } 
                else if (line.startsWith("<author>")) {
                    author = line.replace("<author>", "")
                                 .replace("</author>", "")
                                 .trim();
                } 
                else if (line.equals("</book>")) {
                    list.add(new Book(id, title, author));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No XML file found, starting fresh...");
        } catch (Exception e) {
            System.out.println("Error reading XML");
        }

        return list;
    }
    /**
     * Write book to the CSV file.
     * @param books The list of objects to be written to the file
     */
    public void write(List<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            bw.write("<books>\n");

            for (Book b : books) {
                bw.write("  <book>\n");
                bw.write("    <id>" + b.getId() + "</id>\n");
                bw.write("    <title>" + b.getTitle() + "</title>\n");
                bw.write("    <author>" + b.getAuthor() + "</author>\n");
                bw.write("  </book>\n");
            }

            bw.write("</books>");

        } catch (Exception e) {
            System.out.println("Error writing XML");
        }
    }
}
