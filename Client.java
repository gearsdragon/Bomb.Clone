import java.util.*;

public class Client {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        System.out.println("\n\nBomb party copy " + ANSI_CYAN + "1.0" + ANSI_RESET + ", made for single player");
        System.out.println("Loading in dictionary...");
        long startTime = System.currentTimeMillis();
        Words.setupDictionary();
        System.out.println("Dictionary loaded in " + ANSI_GREEN
                + (String.valueOf(((double) System.currentTimeMillis() - startTime) / 1000)).substring(0, 3)
                + ANSI_RESET + " seconds");
        System.out.println("Loading in bigrams...");
        startTime = System.currentTimeMillis();
        Words.setupBigrams();
        System.out.println("Bigrams loaded in " + ANSI_GREEN
                + (String.valueOf(((double) System.currentTimeMillis() - startTime) / 1000)).substring(0, 3)
                + ANSI_RESET + " seconds\n\n\n");

        System.out.println("------BOMB PARTY SINGLEPLAYER------\n\n" +
                        "HOW TO PLAY\n" +
                        "You are given two letters, and you must\n" +
                        "find a word that contains those two\n" +
                        "letters " + ANSI_BLUE + "IN ORDER.\n" + ANSI_RESET +
                        "No repeats OR words under " + ANSI_BLUE + "3" + ANSI_RESET +" letters.\n" +
                        "EXAMPLE: for letters " + ANSI_GREEN + "al" + ANSI_RESET + ", h" + ANSI_GREEN + "al" + ANSI_RESET + "lway" + "is valid\n" +
                        ", but " + ANSI_GREEN + "a" + ANSI_RESET + "b" + ANSI_GREEN + "l" + ANSI_RESET +  "e is not.\n\n\n"  

        
        );

        PlayerManager.buildPlayers(1, 3);
        Bomb bomb = new Bomb(5);
        bomb.setBomb();
        int rounds = 0;

        Words.newBigram(0, 50);
        System.out.println("\n" + ANSI_GREEN + Words.getBigram() + ANSI_RESET);

        while (PlayerManager.getCurrentPlayer().isAlive()) {
            String answer = input.nextLine();

            if (Words.isAllowed(answer)) {
                int bigramIndex = answer.indexOf(Words.getBigram());
                System.out.println(answer.substring(0, bigramIndex)
                    + ANSI_GREEN +  answer.substring(bigramIndex, bigramIndex + 2) + ANSI_RESET 
                    + answer.substring(bigramIndex + 2) + ", Valid.");

                rounds++;
                Words.addUsedWord(answer);
                Words.newBigram(0, 50 + rounds*5);
                System.out.println("\n" + ANSI_GREEN + Words.getBigram() + ANSI_RESET);
                bomb.restartBombTimer();
                PlayerManager.getCurrentPlayer().increaseScore();
            }
        }

        System.out.println("\n-----GAME OVER------");
        System.out.println("Score: " + PlayerManager.getCurrentPlayer().getScore());

    }


}
