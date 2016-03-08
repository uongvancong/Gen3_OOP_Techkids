/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;
import views.ViewConfig;
import views.ViewLocation;

/**
 *
 * @author ADMIN
 */
public class TowerManager {

    public static final int costTower[] = {20, 40, 60,50};
    public static final int radiusTower[] ={100,100,100,200};
    private Vector<Tower> towerVect;

    private TowerManager() {
        towerVect = new Vector<>();
    }

    public Vector<Tower> getTowerVect() {
        return towerVect;
    }

    public void addTowerType(int posX, int posY, int type) {
        if (Game_State.point < costTower[type]) {
            return;
        }
        Game_State.point -= costTower[type];
        switch (type){
            case 0:
                towerVect.add(new Tower1(posX, posY));
            case 1:
                towerVect.add(new Tower2(posX,posY));
            case 2:
                towerVect.add(new Tower3(posX, posY));
                
        }
      //  towerVect.add(new Tower(posX, posY, costTower[type], radiusTower[type],type));

    }

    public void addTower(Tower tower) {
        if (Game_State.point < tower.cost) {
            return;
        }
        Game_State.point -= tower.cost;
      
        towerVect.add(tower);
    }
    private static TowerManager inst;

    public static TowerManager getInst() {
        if (inst == null) {
            inst = new TowerManager();

//            ViewLocation viewlocation =  ViewConfig.calculateViewLocation(7, 0);
//           inst.addTower(new Tower(viewlocation.posX  , viewlocation.posY, 3  ,400));           
//           viewlocation =  ViewConfig.calculateViewLocation(7, 3);
//           inst.addTower(new Tower(viewlocation.posX  , viewlocation.posY, 3  ,400));           
//           
//           viewlocation =  ViewConfig.calculateViewLocation(7, 5);
//           inst.addTower(new Tower(viewlocation.posX  , viewlocation.posY, 3  ,400));           
        }
        return inst;
    }
}
