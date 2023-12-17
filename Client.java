import java.util.*;

public class Client {
    
    public static void main(String[] args)
    {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

    
    System.out.println("/n/nBomb party copy " + ANSI_CYAN + "1.0" + ANSI_RESET + ", made for single player");
    System.out.println("Loading in dictionary...");
    long startTime = System.currentTimeMillis();

    
    System.out.println("Dictionary loaded in " + ANSI_GREEN + (System.currentTimeMillis() - startTime)/1000 + ANSI_RESET + " seconds");




    Scanner input = new Scanner(System.in);
    Player p1;
    int STARTING_LIVES = 3;
    int startingFuse;

    System.out.println("New Player:");
    System.out.println("What is your name?");
    p1 = new Player(input.nextLine(), STARTING_LIVES);


    { //testing of the player Class

    String[] wordsTest = {"m", "C", "D", "F", "g"};
    p1.addLetters(wordsTest);

    System.out.println(p1.isLetterUsed("f"));
    System.out.println(p1.isLetterUsed("M"));

    System.out.println(p1.getLives());
    String[] livesTest = {"a", "b", "c", "d", "e", "f", "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    p1.addLetters(livesTest);
    System.out.println(p1.getLives());

    System.out.println(p1.isLetterUsed("A"));
    
       System.out.println(p1.isAlive());
    for(int i = 0; i < 4; i++)
        p1.loseLife();
    System.out.println(p1.isAlive());
    }



    }
}
