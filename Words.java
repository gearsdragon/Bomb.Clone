import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Words {

  private static Set<String> dictionary;
  private static Set<String> usedWords = new HashSet<String>();
  private static ArrayList<String> bigrams;
  private static String currentBigram;

  public Words() {
  }

  public static String getBigram()
  {
    return currentBigram;
  }

  public static void setupDictionary() {
    dictionary = new HashSet<String>();
    try {
      Scanner myReader = new Scanner(new File("dictionary.txt"));
      while (myReader.hasNextLine()) {
        dictionary.add(myReader.nextLine());
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void setupBigrams() {
    bigrams = new ArrayList<String>();
    try {
      Scanner myReader = new Scanner(new File("bigrams.txt"));
      while (myReader.hasNextLine()) {
        bigrams.add(myReader.nextLine().trim().toLowerCase());
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void newBigram(int lower, int upper) // frequency is the upper bound, ex: if 50, it'll get random
                                                       // bigram from the top 50 most common bigrams
  {
    int val = (int) (Math.random() * (upper - lower) + lower);
    currentBigram = bigrams.get(val);
  }

  public static void addUsedWord(String w) {
    usedWords.add(w);
  }

  public static boolean isAllowed(String word) {

    return dictionary.contains(word) && word.indexOf(currentBigram) >= 0 && word.length() >= 3 && (!usedWords.contains(word));
  }

}
