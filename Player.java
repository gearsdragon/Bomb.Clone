import java.util.*;
import java.util.HashMap;

public class Player{

    /*
     * git add -all
     * git commit -m "comment"
     * git push --all
     */

    private String name;
    private int lives;
    private boolean isAlive;
    private HashMap<String, Boolean> letters;
    
    public Player(String nam, int liv)
    {
     name = nam;
     lives = liv;
     isAlive = true;
     letters = new HashMap();
     
     for (char ch = 'A'; ch <= 'Z'; ++ch) 
        letters.put(String.valueOf(ch), false);// copped from stack overflow, check if can be used?
    }

    public String getName()
    {
        return name;
    }

    public int getLives()
    {
        return lives;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public boolean isLetterUsed(String l)
    {
        return letters.get(l);
    }

    public void addLetter(String[] l)
    {
        for(int i = 0; i < l.length; i++) //adds all of the letters
            if (!letters.get(l[i]))
                letters.replace(l[i].toUpperCase(), true);      


        for (char a = 'A'; a <= 'Z'; a++) //checks if there are any missing letters
            if (!letters.get(a))
                return;
        
        lives++;// if there aren't any missing letters, increase lives and reset all of the letters
        for (char a = 'A'; a <= 'Z'; a++)
            letters.replace(l[a].toUpperCase(), false);
    }
}
