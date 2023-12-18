import java.util.*;

public class PlayerManager {
    private static int currentPlayer;
    private static ArrayList<Player> players;

    public PlayerManager(int num, int lives) {
    }

    public static void buildPlayers(int num, int lives) {
        players = new ArrayList<Player>();
        currentPlayer = 0;

        for (int i = 0; i < num; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("New Player:");
            System.out.println("What is your name?");
            players.add(new Player(input.nextLine(), lives));

        }
    }

    public static Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public static void loseLifeOnCurrentPlayer() {
        players.get(currentPlayer).loseLife();
    }

}
