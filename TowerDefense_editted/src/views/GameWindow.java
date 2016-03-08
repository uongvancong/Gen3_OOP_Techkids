/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.BulletController;
import controller.EnemyController;
import controller.TowerController;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import models.*;
import sun.audio.AudioDataStream;

/**
 *
 * @author ADMIN
 */
public class GameWindow extends Frame implements Runnable {

    public static int Round = 0;
    public static int countWay = 0;
    public static int noWay = 0;
    int countTime;
    static int mouseClickState = 0;
    static int type = -1;
    private final Drawer[] drawers = new Drawer[]{
        new SquareDrawer(),
        new PathDrawer(),
        //new EnemyDrawer(),        
        new ShitManagerDrawer(),
        new EnemyManagerDrawer(),
        // new TowerDrawer(),
        new TowerManagerDrawer(),
        new BulletDrawer(),
        new ItemManagerDrawer(),
        new ItemBarDrawer(),
        new GameControllerBarDrawer()
    };
    EnemyController enemyController = new EnemyController(this);
    TowerController towercontroller = new TowerController(this);
    BulletController bulletcontroller = new BulletController(this);

    public GameWindow() {
        //form
        this.setTitle("T.F.1.1");
        this.setVisible(true);
        this.setSize(900, 800);
        this.setBackground(Color.LIGHT_GRAY);

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

                int x = e.getX();
                int y = e.getY();
                if (e.getButton() == 3) {
                    Ultility.checkRemoveTower(e.getX(), e.getY());
                    ItemManager.getInst().getItemVect().removeAllElements();
                }
                if (Ultility.checkPosItem(e.getX(), e.getY()) >= 0 && e.getButton() == 1) {
                    type = Ultility.checkPosItem(e.getX(), e.getY());
                    ItemManager.getInst().getItemVect().removeAllElements();
                    if (Ultility.getCostAvai(type)) {
                        ItemManager.getInst().addItem(new Item(x, y, type));
                    }
                }
                //change unit
                ViewLocation vl_row = ViewConfig.covertpixeltocelrow(e.getX(), e.getY());
                ViewLocation vl_pix = ViewConfig.calculateViewLocation(vl_row.posX, vl_row.posY);
                //create item
                if (Ultility.checkItemPathAvai(e.getX(), e.getY()) && type == 0) {
                    System.out.println("vao roi");
                    ShitManager.getInst().addShit(new Shit(vl_pix.posX, vl_pix.posY));
                    ItemManager.getInst().getItemVect().removeAllElements();

                } //create tower
                else if (Ultility._checkPosAvai(e.getX(), e.getY()) && type != 0) {
                    System.out.println("type" + type);
                    Ultility.createTowerAvai(type, vl_pix);
                    ItemManager.getInst().getItemVect().removeAllElements();
                }


            }
        });
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (ItemManager.getInst().getItemVect().size() != 0) {
                    ItemManager.getInst().getItemVect().get(0).setXY(e.getX(), e.getY());
                }
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        //game start 
        //if{ true
        // System.out.println(models.EnemyManager.getInst().getEnemyVect().size());
        for (Drawer drawer : drawers) {
            drawer.draw(g);
        }
        if (Game_State.finish) {
            System.out.println("OUT GAME");
            GameOver gameOver = new GameOver();
            gameOver.draw(g);
        }
        if ((Game_State.Win) && (Game_State.finish == false)) {
            System.out.println("WIN");
            GameWin gameWin = new GameWin();
            gameWin.draw(g);
        }

        //g.drawString(models.Game_State.live+"", 700 , 60);
    }

    public void start() {
        Thread mainThread = new Thread(this);
        mainThread.start();

    }

    @Override
    public void run() {
        int countdown = 0;
        int countperWay = 0;
        int countType = 5;
        int wave = 1;
        int countXanh = 0;
//        ViewLocation viewlocation1 = ViewConfig.calculateViewLocation(3, 6);
//        Shit shit = new Shit(viewlocation1.posX, viewlocation1.posY);
//        ShitManager.getInst().addShit(shit);
//        viewlocation1 = ViewConfig.calculateViewLocation(1, 5);
//        Shit shit1 = new Shit(viewlocation1.posX, viewlocation1.posY);
//        ShitManager.getInst().addShit(shit1);
        ViewLocation viewlocation = ViewConfig.calculateViewLocation(6, 0);
////        EnemyManager.getInst().addEnemy(new EnemyFly(viewlocation.posX, viewlocation.posY));
        while (true) {
            countTime++;
            // System.out.println("no_en" + Game_State.NO_EN);
//            if (Game_State.NO_EN == 0) {
//                Round++;
//                Game_State.NO_EN = 10;
//            }
//            if (Round == 3 && Game_State.live >= 1&&EnemyManager.getInst().getEnemyVect().size()==0) {
//                System.exit(0);
//            }
            try {
                if (Game_State.live <= 0) {
                    Game_State.finish = true;
                    break;
                }
                Thread.sleep(17);
                countdown++;
                if (countdown > 17 * 9 && countdown % (17 * 2) == 0 && countperWay < 3) {
                    EnemyManager.getInst().addEnemy(new Enemy1(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 1;
                }

                if (countdown > 17 * 5 * 20 && countdown % (17 * 2) == 0 && countperWay < 4 + 4) {
                    EnemyManager.getInst().addEnemy(new Enemy1(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 2;
                }

                if (countdown > 17 * 5 * 30 && countdown % (17 * 2) == 0 && countperWay < 4 + 4 + 4) {
                    EnemyManager.getInst().addEnemy(new Enemy1(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 3;
                }

                if (countdown > 17 * 5 * 30 && countdown % (17 * 2) == 0 && countperWay < 4 + 4 + 4 + 1) {
                    if (countXanh == 0) {
                        EnemyManager.getInst().addEnemy(new Enemy4(viewlocation.posX, viewlocation.posY));
                        countperWay++;
                        Game_State.NO_EN = 3;
                        countXanh = 1;
                    }

                }






                if (countdown > 17 * 5 * 40 && countdown % (17 * 2) == 0 && countperWay < 4 * 4) {
                    EnemyManager.getInst().addEnemy(new Enemy2(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 4;
                }


                if (countdown > 17 * 5 * 50 && countdown % (17 * 2) == 0 && countperWay < 4 * 5) {
                    EnemyManager.getInst().addEnemy(new Enemy2(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 5;
                }


                if (countdown > 17 * 5 * 60 && countdown % (17 * 2) == 0 && countperWay < 4 * 6) {
                    EnemyManager.getInst().addEnemy(new Enemy2(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 6;
                }

                if (countdown > 17 * 5 * 78 && countdown % (17 * 2) == 0 && countperWay < 4 * 7) {
                    EnemyManager.getInst().addEnemy(new Enemy2(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 7;
                }

                if (countdown > 17 * 5 * 80 && countdown % (17 * 2) == 0 && countperWay < 4 * 8) {
                    EnemyManager.getInst().addEnemy(new Enemy2(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 8;
                }

                if (countdown > 17 * 5 * 90 && countdown % (17 * 2) == 0 && countperWay < 4 * 9) {
                    EnemyManager.getInst().addEnemy(new Enemy3(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 9;
                }

                if (countdown > 17 * 5 * 100 && countdown % (17 * 2) == 0 && countperWay < 4 * 10) {
                    EnemyManager.getInst().addEnemy(new Enemy3(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                    Game_State.NO_EN = 10;
                }



                if (countdown > 17 * 5 * 110 && countdown % (17 * 2) == 0 && countperWay < 4 * 11 + 3) {
                    EnemyManager.getInst().addEnemy(new Enemy3(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                }

                if (countdown > 17 * 5 * 120 && countdown % (17 * 2) == 0 && countperWay < 4 * 11 + 4) {
                    EnemyManager.getInst().addEnemy(new EnemyFly(viewlocation.posX, viewlocation.posY));
                    countperWay++;
                }
//                if (countdown > 15 * 5 * 125) {
//                    if (EnemyManager.getInst().getEnemyVect().size() == 0) {
//                        Game_State.Win = true;
//                    }
//                }

                for (models.Bullet bullet : Bullet.deadBullet) {
                    models.BulletManager.getInst().getBulletVect().remove(bullet);
                }
                Bullet.deadBullet.clear();

                enemyController.move();
                bulletcontroller.move();
                towercontroller.shoot();
                for (models.Bullet bullet : Bullet.deadBullet) {
                    models.BulletManager.getInst().getBulletVect().remove(bullet);
                }
                Bullet.deadBullet.clear();
                //  System.out.println("Game Point: " + Game_State.point);
                //enemyController.shoot();
            } catch (Exception ex) {
                System.out.println("Loi cmnr\n" + ex.toString());
//  Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

            repaint();
        }
    }
    ////////Dung edit phan nay nhe. Thanks\\\\\\\\\
    private Image backImage;
    private Graphics backGraphics;

    @Override
    public void update(Graphics g) {
        //    super.update(g); //To change body of generated methods, choose Tools | Templates.
        if (backImage == null) {
            backImage = createImage(this.getWidth(), this.getHeight());
            backGraphics = backImage.getGraphics();
        }
        backGraphics.setColor(getBackground());
        backGraphics.fillRect(0, 0, getWidth(), getHeight());
        backGraphics.setColor(getForeground());
        paint(backGraphics);
        g.drawImage(backImage, 0, 0, null);
    }
}
