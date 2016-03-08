import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends Frame implements Runnable {
    BufferedImage background;
    MyPlane planeMoveByKey;
    MyPlane planeMoveByMouse;
    PlaneEnemy enemy, enemy1, enemy2;

    //
    Graphics seconds;
    Image image;

    //
    public GameWindow() {
        planeMoveByKey = new MyPlane(200, 300, 4, 2);
        planeMoveByMouse = new MyPlane(300, 300, 4, 4);
        enemy = new PlaneEnemy(200, 100, 2, 2);
        enemy1 = new PlaneEnemy(100, 100, 2, 2);
        enemy2 = new PlaneEnemy(300, 100, 2, 2);


        this.setTitle("Ban May Bay");
        this.setSize(400, 640);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        try {
            background = ImageIO.read(new File("Resources/Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    planeMoveByKey.setDirection(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    planeMoveByKey.setDirection(2);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    planeMoveByKey.setDirection(3);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    planeMoveByKey.setDirection(4);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    planeMoveByKey.shot();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                planeMoveByKey.setDirection(0);
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                planeMoveByMouse.move(e.getX() - 35, e.getY() - 30);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    planeMoveByMouse.shot();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        repaint();
    }

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        planeMoveByMouse.draw(g);
        planeMoveByKey.draw(g);
        enemy.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);

    }


    @Override
    public void run() {

        while (true) {

            planeMoveByKey.update();
            planeMoveByMouse.update();
            enemy.update();
            enemy1.update();
            enemy2.update();

            repaint();


            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

