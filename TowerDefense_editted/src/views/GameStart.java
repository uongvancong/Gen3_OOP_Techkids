/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import models.Item;
import models.ItemManager;
import models.Tower1;
import models.Tower2;
import models.Tower3;
import models.TowerManager;
import models.Ultility;
import static views.GameWindow.type;

/**
 *
 * @author tuan anh le
 */
public class GameStart extends Frame {

    JButton btnStart = new JButton();
    JButton btnExit = new JButton();

    public GameStart() {
        //form
        this.setTitle("T.F.1.1");
        this.setVisible(true);
        this.setSize(900, 800);
       
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                System.exit(0);
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.


                //tu khoang 300 550
                //System.out.println("abc");
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.


        //g.drawString("Start game", 300, 400);
        //g.drawString("Exit", 300 , 500);
    }
}
