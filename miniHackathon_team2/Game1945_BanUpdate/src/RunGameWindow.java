import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public class RunGameWindow extends Frame implements Runnable {
    BufferedImage background;
    BufferedImage island;
    BufferedImage island2;
    Graphics seconds;
    Image image;
    PlaneMoveByKey planeMoveByKey;
    PlaneMoveByMouse planeMoveByMouse;
    PlaneEnemy_1 planeEnemy1;
    PlaneEnemy_2 planeEnemy2;
    Bird bird;

    RunGameWindow() {
        this.setTitle("Techkids Gen 3 - Game 1945");
        this.setSize(400, 640);
        this.setVisible(true);
        // start
        // Tắt Frame bằng nút X
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        } );
        // end
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            island = ImageIO.read(new File("Resources/island.png"));
            island2 = ImageIO.read(new File("Resources/island2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.initPlane();
        bird = new Bird();

        // Bắt sự kiện bàn phím
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    planeMoveByKey.setDirection(1);
                }
                else if(e.getKeyCode() == KeyEvent.VK_S) {
                    planeMoveByKey.setDirection(2);
                }
                else if(e.getKeyCode() == KeyEvent.VK_A) {
                    planeMoveByKey.setDirection(3);
                }
                else if(e.getKeyCode() == KeyEvent.VK_D) {
                    planeMoveByKey.setDirection(4);
                }
                else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    planeMoveByKey.shot(2, 1);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                planeMoveByKey.setDirection(0);
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                planeMoveByMouse.shot(3, 1);
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

        // Bắt sự kiện di chuyển chuột
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Di chuyển theo chuột
                planeMoveByMouse.move(e.getX(), e.getY());
                // Hàm ẩn chuột
                BufferedImage cursorImg = new BufferedImage(planeMoveByMouse.getX(), planeMoveByMouse.getY(), BufferedImage.TYPE_INT_ARGB);
                Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
                setCursor(blankCursor);
            }
        });
    }

    // Vẽ mọi thứ ở đây
    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(island, 100, 500, null);
        g.drawImage(island2, 200, 400, null);

        planeMoveByKey.draw(g);
        planeMoveByMouse.draw(g);
        planeEnemy1.draw(g);
        planeEnemy2.draw(g);
        bird.draw(g);
    }

    // Hàm khởi tạo cho máy bay
    public void initPlane() {
        planeMoveByKey = new PlaneMoveByKey(100, 200, 3, 1);
        planeMoveByMouse = new PlaneMoveByMouse(200, 400, 2, 2);
        planeEnemy1 = new PlaneEnemy_1(150, 300, 2, 3);
        planeEnemy2 = new PlaneEnemy_2(250, 100, 1, 4);
    }

    // Tạo cho màn hình lớp nền => không bị giật màn hình (Ko cần quan tâm hàm này)
    // start
    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image, 0, 0, null);
    }
    // end

    // Chạy mọi thứ ở đây
    @Override
    public void run() {
        while(true) {
            planeMoveByKey.update();
            planeMoveByMouse.update();
            planeEnemy1.update();
            planeEnemy2.update();
            bird.update();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
