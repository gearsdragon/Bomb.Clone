import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Words {
    
private static Set<String> dictionary;
private ArrayList<String> usedWords;
private static ArrayList<String> bigrams;

public Words() 
{
    usedWords = new ArrayList<String>();
}

public void setupDictionary()
{
        try {
          Scanner myReader = new Scanner( new File("dictionary.txt"));
          while (myReader.hasNextLine()) {
            dictionary.add(myReader.nextLine().trim().toLowerCase());
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      
}

}
