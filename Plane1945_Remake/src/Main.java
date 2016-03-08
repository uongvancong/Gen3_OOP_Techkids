import java.awt.*;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
//        int  x;
//        int y;
//        int r = 100;
//        for (float i = 0; i <= 360; i+=0.2) {
//            x =100+ (int) (r * Math.sin(i));
//            y = 100 + (int) (r*Math.cos(i));
////            newPositionX.add(x);
////            newPositionY.add(y);
//            System.out.println("x = " + x + " || y = "+y);

//        }


    }
}
