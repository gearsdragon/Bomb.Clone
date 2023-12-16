import java.util.*;

public class Client {
    
    public static void main(String[] args)
    {
    System.out.println("Bomb party copy 1.0, made for single player\n\n");

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
