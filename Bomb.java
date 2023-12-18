import java.util.TimerTask;
import java.util.Timer;

public class Bomb {

    private int startingFuse;
    private int timeLeft;
    Timer timer;

    public Bomb(int time) {
        startingFuse = time;
    }

    public int getFuse() {
        return startingFuse;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void reduceTime() {
        startingFuse /= 2;
    }

    public void defuseBomb() {
        timer.cancel();
    }

    public void restartBombTimer() {
        timeLeft = startingFuse;
    }

    public void setBomb() {
        System.out.println("\nBomb will explode in " + startingFuse + " seconds");

        timeLeft = startingFuse;
        timer = new Timer();
        timer.schedule(new Countdown(), 1000, 1000);
    }

    class Countdown extends TimerTask {
        public void run() {
            if (timeLeft > 0) {
                // System.out.println(timeLeft);
                timeLeft--;
            } else {
                PlayerManager.loseLifeOnCurrentPlayer();
                if (!PlayerManager.getCurrentPlayer().isAlive())
                {    
                timer.cancel();
                System.out.println("\n" + PlayerManager.getCurrentPlayer().getName() + " has died!");
                } else {
                System.out.println("\n\n" + PlayerManager.getCurrentPlayer().getName() + " has lost a life! \nLives: " + PlayerManager.getCurrentPlayer().getLives() + "\n");
                System.out.println("\u001B[32m" + Words.getBigram() + "\u001B[0m");
                timeLeft = startingFuse;
                }
            }
        }
    }
}
