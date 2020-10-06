import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

/**This class reads the file, counts the number of total students
 *  and holds the students names in an arraylist **/
public class Reader {
    ArrayList<String> studentsAr = new ArrayList<String>();

    public Reader(String file){
        try {
            //store the file in a string and create a buffered reader to read it
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();

            //while loop to read the file and count the number of students and students in each block
            while (line != null) {
                studentsAr.add(line);
                line = br.readLine(); //read a new line each time
            }
        } catch(IIOException | FileNotFoundException e){
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}