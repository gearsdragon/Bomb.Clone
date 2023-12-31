import java.util.*;
import java.util.HashMap;

public class Player {

    /*
     * git add --all
     * git commit -m "comment"
     * git push --all
     */

    private String name;
    private int lives;
    private boolean isAlive;
    private HashMap<String, Boolean> letters;
    private int score;

    public Player(String nam, int liv) {
        name = nam;
        lives = liv;
        isAlive = true;
        letters = new HashMap();
        score = 0;

        for (char ch = 'A'; ch <= 'Z'; ++ch)
            letters.put(String.valueOf(ch), false);// copped from stack overflow, check if can be used?
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isLetterUsed(String l) {
        return letters.get(l.toUpperCase());
    }

    public void addLife() {
        lives++;
    }

    public void loseLife() {
        lives--;
        if (lives == 0)
            isAlive = false;
    }

    public void increaseScore() 
    {
        score++;
    }

    public int getScore()
    {
        return score;
    }

    public void addLetters(String[] l) {
        for (int i = 0; i < l.length; i++) // adds all of the letters
            if (!letters.get(l[i].toUpperCase()))
                letters.replace(l[i].toUpperCase(), true);

        for (char a = 'A'; a <= 'Z'; a++) // checks if there are any missing letters
            if (!letters.get(String.valueOf(a)))
                return;

        addLife();// if there aren't any missing letters, increase lives and reset all of the
                  // letters
        for (char a = 'A'; a <= 'Z'; a++)
            letters.replace(String.valueOf(a).toUpperCase(), false);
    }
}
