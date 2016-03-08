/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;
import views.ViewConfig;

/**
 *
 * @author tuan anh le
 */
public class EnemyMoveFly implements MoveBehavior {

    final int finalX = 644;
    final int finalY = 724;
    public int posX;
    public int posY;

    @Override
    public void move(GameObject a) {
        Location viewLocation = models.Path.getInst().getVector().get(Path.getInst().getVector().size() - 1);
        //int finalX = (viewLocation.x-1) * views.ViewConfig.MAP_CELL_SIZE + views.ViewConfig.MAP_OFFSET_X;                
//        int disX = 0;
//        // x la cot 
//        // y la hang
//        System.out.println(a.x + " " +a.y);
//        int disY = 0;
//        Path path = Path.getInst();
//        if (finalX - a.x > 0){
//            disX = 1;
//        }
//        else if (finalX - a.x < 0){
//            disX = -1;
//        }
//        else disX = 0;
//        
//        if (finalY - a.y > 0){
//            disY = 1;
//        }
//        else if (finalY - a.y < 0){
//            disY = -1;
//        }
//        else disY = 0;
//                //a.setX(a.getX() + 3 * ());
//        a.setX(a.getX() + 1 * disX);
//        a.setY(a.getY() + 1 * disY);
//        //a.setX(a.getX() + a.speed * (locnext.y - loc.y));
//        //a.setY(a.getY() + a.speed * (locnext.x - loc.x));
        a.setY(a.getY() + 1);
        int phandoan = ViewConfig.MAP_NUMBER_ROW;
        int mcs = ViewConfig.MAP_CELL_SIZE;
        if (a.getY() % 3 == 0) {
            a.setX(a.getX() + 1);
        }
        //System.out.println(a.getX()+"+"+a.getY());
        if (finalX - a.getX() <= ViewConfig.MAP_CELL_SIZE -10&& finalY - a.getY() <= ViewConfig.MAP_CELL_SIZE  -10) {
            if (a.isAlive == true) {
                Game_State.live--;
                a.isAlive = false;
                a.position = 0;
            }
        }
    }
}
