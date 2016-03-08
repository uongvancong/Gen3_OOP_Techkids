import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class GameWindow extends Frame implements Runnable {
    BufferedImage background;
    MyPlane planeMoveByKey;
    MyPlane planeMoveByMouse;
    Vector<PlaneEnemy> planeEnemyVector;

    // cho hinh k bi giat
    Graphics seconds;
    Image image;

    public void initPlane() {
        planeMoveByKey = new MyPlane(300, 500, 4, 2);
        planeMoveByMouse = new MyPlane(1000, 500, 4, 4);
        planeEnemyVector = new Vector<>();

        //tham so truyen vao cua PlaneEnemy
        //---
        //x, y, speed, planeEnemyType, indexStart, shotType,
        //planeEnemyType 1 di ngang
        //planeEnemyType 2 di hinh sin
        // planeEnemyType 3 di chuyen hinh tron
        //----
        //indexStart (sin) vi tri bat dau
        //----
        //shotType 1 ban 3 dan theo 3 huong
        //shotType 2 ban 2 dan lien tuc

        planeEnemyVector.add(new PlaneEnemy(100, 50, 2, 1, 0, 1, 360, 120));
        planeEnemyVector.add(new PlaneEnemy(500, 50, 2, 1, 300, 1, 360, 60));
        planeEnemyVector.add(new PlaneEnemy(900, 50, 2, 1, 900, 1, 360, 0));
////
        planeEnemyVector.add(new PlaneEnemy(900, 100, 2, 2, 100, 2, 360, 200));
        planeEnemyVector.add(new PlaneEnemy(900, 100, 2, 2, 600, 2, 360, 140));
        planeEnemyVector.add(new PlaneEnemy(900, 100, 2, 2, 1100, 2, 360, 80));
        //
        planeEnemyVector.add(new PlaneEnemy(900, 100, 2, 3, 100, 2, 360, 200));
        planeEnemyVector.add(new PlaneEnemy(400, 100, 2, 3, 100, 2, 360, 200));


    }

    //
    public GameWindow() {

        initPlane();
        this.setTitle("PLANE 1945 ");
        this.setSize(1300, 700);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        try {
            background = ImageIO.read(new File("Resources/violet2.png"));
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
                planeMoveByMouse.move(e.getX(), e.getY());
                // Hàm ẩn chuột
                BufferedImage cursorImg = new BufferedImage(planeMoveByMouse.getPositionX(), planeMoveByMouse.getPositionY(), BufferedImage.TYPE_INT_ARGB);
                Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
                setCursor(blankCursor);
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

    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        planeMoveByMouse.draw(g);
        planeMoveByKey.draw(g);

//        g.drawString("   May Bay 1", enemy.getPositionX(), enemy.getPositionY() - 5);
//        g.drawString("   May Bay 3", enemy2.getPositionX(), enemy2.getPositionY() - 5);


        for (PlaneEnemy i : planeEnemyVector) {
            i.draw(g);
        }
    }

    @Override
    public void run() {
        while (true) {
            planeMoveByKey.update();
            planeMoveByMouse.update();
            for (PlaneEnemy i : planeEnemyVector) {
                i.update();
            }

            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
