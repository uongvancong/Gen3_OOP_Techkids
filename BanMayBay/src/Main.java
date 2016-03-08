import java.util.Random;

public class Main {

    public static void main(String[] args) {
        GameWindow game = new GameWindow();
        Thread thread = new Thread(game);
        thread.start();

    }
}
