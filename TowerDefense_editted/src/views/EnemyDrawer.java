/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;
import models.Enemy;
import models.EnemyManager;
import models.Location;
import models.Path;
import models.Ultility;

/**
 *
 * @author ADMIN
 */
public class EnemyDrawer extends BaseDrawer {

    protected Enemy enemy;
    public static int WIDTH_HP = 50;
    public static int HEIGHT_HP = 5;

    public EnemyDrawer(Enemy enemy) {
        this.enemy = enemy;
        for (int i = 0; i < 4; i++) {
            loadSprite("res/enemy" + i + ".png");    
            spriteVect.add(sprite);
        }
    }

    public EnemyDrawer() {
//        for (int i = 0; i < 4; i++) {
//            loadSprite("res/enemy" + i + ".png");
//            spriteVect.add(sprite);
//        }
    }

    @Override
    protected void loadSprite() {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        loadSprite("res/enemy0.png");
    }
    EnemyManager enemyManager = EnemyManager.getInst().getInst();
    int posDir[] = Ultility.arrDirection;
    Vector<BufferedImage> spriteVect = new Vector<>();

    @Override
    public void draw(Graphics g) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (enemy.isIsAlive() == true) {
//            int posX = enemy.getX();
//            int posY = enemy.getY();
//            g.drawImage(sprite, posX, posY, ViewConfig.MAP_CELL_SIZE, ViewConfig.MAP_CELL_SIZE, null);
//            int widthRemains = enemy.getHpRemains() * WIDTH_HP / enemy.getHp();
//            g.drawRect(posX, posY, WIDTH_HP, HEIGHT_HP);
//            g.setColor(Color.red);
//            g.fillRect(posX, posY, widthRemains, HEIGHT_HP);

            int posX = enemy.getX();
            int posY = enemy.getY();
            int dir = 0;
            int pos = enemy.getPosition() + 1;
            if (pos >= 0) {
                dir = Ultility.arrDirection[pos];
            //dir = Path.getInst().getDirectionVect().get(pos);
            }
            //System.out.println("dir:" + dir);
            g.drawImage(spriteVect.get(dir-1), posX+10, posY+10, ViewConfig.MAP_CELL_SIZE-20, ViewConfig.MAP_CELL_SIZE-20, null);
            // g.drawImage(sprite, posX, posY, ViewConfig.MAP_CELL_SIZE, ViewConfig.MAP_CELL_SIZE, null);
            int widthRemains = enemy.getHpRemains() * WIDTH_HP / enemy.getHp();
            g.drawRect(posX, posY, WIDTH_HP, HEIGHT_HP);
            g.setColor(Color.red);
            g.fillRect(posX, posY, widthRemains, HEIGHT_HP);
        }
    }
}
