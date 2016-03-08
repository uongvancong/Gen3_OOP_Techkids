import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class GameWindow extends Frame {
    BufferedImage background;
    Graphics seconds;
    Image image;
    Animals lion = new Lion();
    Animals tiger = new Tiger();
    Animals dolphin = new Dolphin();
    Animals parrot = new Parrot();
    Animals peng = new Peng();
    Animals shark = new Shark();

    public GameWindow() {
        this.setTitle(" MiniHackathon - Team 2 ");
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.setLocation(0,0);
        this.setSize(900,400);
//        try {
//            background = ImageIO.read(new File("Resources/background.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getX() > 0 && e.getX() < 300 && e.getY() > 0 && e.getY() < 200) {
                    tiger.display();
                }
                else if(e.getX() > 300 && e.getX() < 600 && e.getY() > 0 && e.getY() < 200) {
                    dolphin.display();
                }
                else if(e.getX() > 600 && e.getX() < 900 && e.getY() > 0 && e.getY() < 200) {
                    peng.display();
                }
                else if(e.getX() > 0 && e.getX() < 300 && e.getY() < 400 && e.getY() > 200) {
                    lion.display();
                }
                else if(e.getX() > 300 && e.getX() < 600 && e.getY() < 400 && e.getY() > 200) {
                    shark.display();
                }
                else if(e.getX() > 600 && e.getX() < 900 && e.getY() < 400 && e.getY() > 200) {
                    parrot.display();
                }



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
    public void update(Graphics g){ // lam cho man hinh khong nhay
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds= image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    public void paint( Graphics g) {
        //g.drawImage(background, 0, 0, null);
        g.drawImage(tiger.sprite, 0, 0, null);
        g.drawImage(dolphin.sprite, 300, 0, null);
        g.drawImage(peng.sprite, 600, 0, null);
        g.drawImage(lion.sprite, 0, 200, null);
        g.drawImage(shark.sprite, 300, 200, null);
        g.drawImage(parrot.sprite, 600, 200, null);
    }

}
