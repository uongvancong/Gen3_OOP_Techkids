/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public class Main {
    public static void main(String [] args) {
        RunGameWindow runGameWindow = new RunGameWindow();
        Thread thread = new Thread(runGameWindow);
        thread.start();
    }
}
