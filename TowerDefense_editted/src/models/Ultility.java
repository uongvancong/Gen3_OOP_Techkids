/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;
import views.ViewConfig;
import static views.ViewConfig.MAP_CELL_SIZE;
import static views.ViewConfig.MAP_OFFSET_X;
import static views.ViewConfig.MAP_OFFSET_Y;
import views.ViewLocation;

/**
 *
 * @author tuan anh le
 */
public class Ultility {

    //public static final int[] arrDirection = {1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1};
    public static final int[] arrDirection = {1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1};
    
    public static int checkPosItem(int x, int y) {
        int posX = ViewConfig.MAP_OFFSET_X + ViewConfig.MAP_CELL_SIZE * ViewConfig.MAP_NUMBER_COLUM + 3;
        int posY = ViewConfig.MAP_OFFSET_Y + ViewConfig.MAP_CELL_SIZE * 2;

        if (x > posX && x < posX + ViewConfig.MAP_CELL_SIZE
                && y > posY && y < posY + ViewConfig.MAP_CELL_SIZE) {
            //  System.out.println("o so 1");
            return 0;
        } else if (x > posX && x < posX + ViewConfig.MAP_CELL_SIZE
                && y > posY && y < posY + ViewConfig.MAP_CELL_SIZE * 2) {
            //   System.out.println("o so 2");
            return 1;
        } else if (x > posX && x < posX + ViewConfig.MAP_CELL_SIZE
                && y > posY && y < posY + ViewConfig.MAP_CELL_SIZE * 3) {
            //   System.out.println("o so 2");
            return 2;
        } else if (x > posX && x < posX + ViewConfig.MAP_CELL_SIZE
                && y > posY && y < posY + ViewConfig.MAP_CELL_SIZE * 4) {
            //   System.out.println("o so 2");
            return 3;
        } else if (x > posX && x < posX + ViewConfig.MAP_CELL_SIZE
                && y > posY && y < posY + ViewConfig.MAP_CELL_SIZE * 5) {
            //   System.out.println("o so 2");
            return 4;
        }
        return -1;
    }

    public static boolean _checkPosAvai(int x, int y) {
        ViewLocation vl_path = Ultility.covertpixeltocelrow(x, y);
        if (ItemManager.getInst().getItemVect().size() == 0) {
            return false;
        }
        if (vl_path.posX >= ViewConfig.MAP_NUMBER_COLUM || vl_path.posY >= ViewConfig.MAP_NUMBER_ROW) {
            return false;
        }
        for (Location l : Path.getInst().getVector()) {
            if (vl_path.posX == l.y && vl_path.posY == l.x) {
                System.out.println("DM! deo chon duoc o nay");
                return false;
            }
        }

        for (Tower t : TowerManager.getInst().getTowerVect()) {
            ViewLocation vl_tower = Ultility.covertpixeltocelrow(t.getX(), t.getY());
            if (vl_path.posX == vl_tower.posX && vl_path.posY == vl_tower.posY) {
                //            System.out.println(t.x + "," + t.y);
                System.out.println("dm! co cai thap nay roi");
                return false;
            }
        }
        return true;
    }

    public static void checkRemoveTower(int x, int y) {
        Vector<Tower> deadObject = new Vector<>();

        ViewLocation locClick = Ultility.covertpixeltocelrow(x, y);

        //     System.out.println("s:" + TowerManager.getInst().getTowerVect().size());
        if (ItemManager.getInst().getItemVect().isEmpty()) {
            if (TowerManager.getInst().getTowerVect().size() >= 1) {
                for (Tower tower : TowerManager.getInst().getTowerVect()) {
                    ViewLocation locTower = Ultility.covertpixeltocelrow(tower.x, tower.y);
                    if (locTower.posX == locClick.posX && locTower.posY == locClick.posY) {
                        System.out.println("deadPos:" + tower.x + "," + tower.y);
                        deadObject.add(tower);
                    }
                }
                if (!deadObject.isEmpty()) {
                    for (Tower tower : deadObject) {
                        TowerManager.getInst().getTowerVect().remove(tower);
                    }
                    deadObject.clear();
                }
            }

        }
    }

    public static boolean checkItemPathAvai(int x, int y) {
        ViewLocation vl_path = Ultility.covertpixeltocelrow(x, y);
        if (ItemManager.getInst().getItemVect().size() == 0) {
            return false;
        }
        for (Location l : Path.getInst().getVector()) {
            if ((vl_path.posX == l.y && vl_path.posY == l.x)) {
                return true;
                //return false;
            }
        }
        System.out.println("Khong phai o tren duong");
        return (false);
    }

    public static ViewLocation calculateViewLocation(int x, int y) {
        return (new ViewLocation(MAP_OFFSET_X + x * MAP_CELL_SIZE, MAP_OFFSET_Y + y * MAP_CELL_SIZE));
    }

    public static ViewLocation calculatemidViewLocation(int x, int y) {
        return (new ViewLocation(MAP_OFFSET_X + x * MAP_CELL_SIZE, MAP_OFFSET_Y + y * MAP_CELL_SIZE));
    }

    public static ViewLocation covertpixeltocelrow(int x, int y) {
        ViewLocation result = null;

        x = (x - MAP_OFFSET_X) / MAP_CELL_SIZE;
        y = (y - MAP_OFFSET_Y) / MAP_CELL_SIZE;
        result = new ViewLocation(x, y);
        return (result);
    }
            public static boolean getCostAvai(int type) {
        Tower t = null;
        Shit s = null;
        switch (type) {//dua tren kieu type de tao Tower/
            case 0:
                s = new Shit(0, 0);
                if (Game_State.point <ShitManager.ShitCost) {
                    return false;
                }
                break;
            case 1:
                t = new Tower1(0, 0);
                if (Game_State.point < t.cost) {
                    return false;
                }
                break;
            case 2:
                t = new Tower2(0, 0);
                if (Game_State.point < t.cost) {
                    return false;
                }
                break;
            case 3:
                t = new Tower3(0, 0);
                if (Game_State.point < t.cost) {
                    return false;
                }
                break;
            case 4:
                t = new Tower4(0, 0);
                if (Game_State.point < t.cost) {
                    return false;
                }
                break;
            default:
                System.out.println("Not Available");
                break;
        }
        return true;
    }

    public static void createTowerAvai(int type, ViewLocation vl_pix) {
        switch (type) {//dua tren kieu type de tao Tower/
//           case 0:
//                ShitManager.getInst().addShit(new Shit(vl_pix.posX, vl_pix.posY));
//                // TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 0);
//                break;
            case 1:
                TowerManager.getInst().addTower(new Tower1(vl_pix.posX, vl_pix.posY));
                // TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 0);
                break;
            case 2:
                TowerManager.getInst().addTower(new Tower2(vl_pix.posX, vl_pix.posY));
//                            TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 1);
                break;
            case 3:
                TowerManager.getInst().addTower(new Tower3(vl_pix.posX, vl_pix.posY));
//                            TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 2);
                break;
            case 4:
                TowerManager.getInst().addTower(new Tower4(vl_pix.posX, vl_pix.posY));
//                            TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 2);
                break;
            default:
                System.out.println("Chon lam ccm gi vay!");
                break;
        }
        ItemManager.getInst().getItemVect().removeAllElements();
    }

//
//    public static boolean getCostAvai(int type) {
//        Tower t = null;
//        Shit s = null;
//        switch (type) {//dua tren kieu type de tao Tower/
//            case 0:
//                s = new Shit(0, 0);
//                if (Game_State.point < s.cost) {
//                    return false;
//                }
//                break;
//            case 1:
//                t = new Tower1(0, 0);
//                if (Game_State.point < t.cost) {
//                    return false;
//                }
//                break;
//            case 2:
//                t = new Tower2(0, 0);
//                if (Game_State.point < t.cost) {
//                    return false;
//                }
//                break;
//            case 3:
//                t = new Tower3(0, 0);
//                if (Game_State.point < t.cost) {
//                    return false;
//                }
//                break;
//            case 4:
//                t = new Tower4(0, 0);
//                if (Game_State.point < t.cost) {
//                    return false;
//                }
//                break;
//            default:
//                System.out.println("Not Available");
//                break;
//        }
//        return true;
//    }
//
//    public static void createTowerAvai(int type, ViewLocation vl_pix) {
//        switch (type) {//dua tren kieu type de tao Tower/
////           case 0:
////                ShitManager.getInst().addShit(new Shit(vl_pix.posX, vl_pix.posY));
////                // TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 0);
////                break;
//            case 1:
//                TowerManager.getInst().addTower(new Tower1(vl_pix.posX, vl_pix.posY));
//                // TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 0);
//                break;
//            case 2:
//                TowerManager.getInst().addTower(new Tower2(vl_pix.posX, vl_pix.posY));
////                            TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 1);
//                break;
//            case 3:
//                TowerManager.getInst().addTower(new Tower3(vl_pix.posX, vl_pix.posY));
////                            TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 2);
//                break;
//            case 4:
//                TowerManager.getInst().addTower(new Tower4(vl_pix.posX, vl_pix.posY));
////                            TowerManager.getInst().addTowerType(vl_pix.posX, vl_pix.posY, 2);
//                break;
//            default:
//                System.out.println("Chon lam ccm gi vay!");
//                break;
//        }
//        ItemManager.getInst().getItemVect().removeAllElements();
//    }

    public static int convertcelltow2stt(int x, int y) {
        int i = 0;

        ViewLocation pos = new ViewLocation(x, y);
        Vector<Location> view = Path.getInst().getVector();
        for (Location location : view) {
            i++;
            //      System.out.println("x: "+pos.posX+" y:"+pos.posY);
            if ((location.y == pos.posX) && (location.x == pos.posY)) {
                break;
            }
        }
        if (i == 54) {
            i = 53;
        }
        return i;
//        result = new ViewLocation(view.get(i).x, view.get(i).y);
//        return (result);
    }

    public static int convertpos2stt(int x, int y) {
        int i = 0;

        ViewLocation pos = covertpixeltocelrow(x, y);
        Vector<Location> view = Path.getInst().getVector();
        for (Location location : view) {
            i++;
            //      System.out.println("x: "+pos.posX+" y:"+pos.posY);
            if ((location.y == pos.posX) && (location.x == pos.posY)) {
                break;
            }
        }
        if (i == 54) {
            i = 53;
        }
        return i;
//        result = new ViewLocation(view.get(i).x, view.get(i).y);
//        return (result);
    }
}
