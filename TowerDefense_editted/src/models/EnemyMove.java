package models;

import java.util.Vector;
import views.ViewConfig;
import views.ViewLocation;

/**
 *
 * @author ADMIN
 */
public class EnemyMove implements MoveBehavior {

    public Vector<Shit> deadShit = new Vector<Shit>();
    public boolean dachamShit = false;
    public boolean biShit = false;
    public int counttime = 0;
    public long timeSlow;
    public int countdistance = 0;
    public int oldPosShit = 0;

    /*
     * public ViewLocation findnext(ViewLocation viewlocation) { ViewLocation
     * result = null; int count = -1; Path path = Path.getInst();
     * System.out.println("viewlocation " + viewlocation.posX + " " +
     * viewlocation.posY); Vector<Location> vectorlocation = path.getVector();
     * Location keysearch = new Location(viewlocation.posY, viewlocation.posX);
     * for (Location abc : vectorlocation) { count++; if ((abc.x == keysearch.x)
     * && (abc.y == keysearch.y)) { break; } } //System.out.println("count: " +
     * count); Location location = vectorlocation.get(count + 1); result = new
     * ViewLocation(location.y, location.x); return (result);
     *
     * }
     */
    @Override
    public void move(GameObject a) {
        try {
            //    System.out.println(a.getX() + " " + a.getY());
            Path path = Path.getInst();
            for (Shit shit : ShitManager.getInst().getShitVect()) {
                if (a.position == Ultility.convertpos2stt(shit.x, shit.y)) {
                    //    System.out.println("Shit");

                    if (oldPosShit != a.position) {
                        shit.countCar++;
                        oldPosShit = a.position;
                    }
                    oldPosShit = a.position;
                    if (shit.countCar >= 5) {
                        deadShit.add(shit);
                        System.out.println("Hihi");
                    }
                    timeSlow = System.currentTimeMillis() / 1000;
                    biShit = true;
                }
            }

            for (Shit shit : deadShit) {
                ShitManager.getInst().getShitVect().remove(shit);
            }
            deadShit.clear();

            if ((biShit = true) && (dachamShit == false)) {
                a.speed = 1;
                dachamShit = true;
            }

            if (System.currentTimeMillis() / 1000 - timeSlow >= 3) {
                if (biShit == true) {
                    biShit = false;
                    dachamShit = false;
                    if (a instanceof Enemy4) {
                        a.speed = 1;
                    } else if (a instanceof Enemy3) {
                        a.speed = 5;
                    } else if (a instanceof Enemy2) {
                        a.speed = 3;
                    } else if (a instanceof Enemy1) {
                        a.speed = 2;
                    }

                }
            }
            Vector<Location> vectorlocation = path.getVector();
            a = (Enemy) a;
            //System.out.println(a.position);
            Location loc = vectorlocation.get(a.position);
            Location locnext = vectorlocation.get(a.position + 1);

            //System.out.println(counttime);
            counttime++;
            countdistance += Math.abs(a.speed * (locnext.y - loc.y));
            countdistance += Math.abs(a.speed * (locnext.x - loc.x));
            //System.out.println(countdistance);
            a.setX(a.getX() + a.speed * (locnext.y - loc.y));
            a.setY(a.getY() + a.speed * (locnext.x - loc.x));
            if (countdistance >= views.ViewConfig.MAP_CELL_SIZE) {
                countdistance = 0;
//            if (loc.x == locnext.x) {
//                if (loc.y < locnext.y) {
//                    System.out.println("phai");
//                }
//                else 
//                    System.out.println("trai");
//            }
//            else if (loc.y == locnext.y)
//            {
//                if (loc.x < locnext.x){
//                    System.out.println("xuong");
//                }
//                else
//                    System.out.println("len");
//            }
                a.position++;
                counttime = 0;
            }
            if (a.position >= path.getVector().size() - 1) {
                if (a.isAlive == true) {
                    Game_State.live--;
                    a.isAlive = false;
                    a.position = 0;
                    //   System.out.println("Game_State: " + Game_State.live);
                    //   EnemyManager.getInst().getEnemyVect().remove(a);
                }
                //a.isAlive = false;
                //remove
                //a.position = 0;
            }
        } catch (Exception e) {
            // System.out.println(e);
        }

        // xet xem voi a.x a.y dang o o nao
        // tim tiep o tiep theo
        //ve chay theo vector
        /*
         * System.out.println("Postition: " + a.getX() + " " + a.getY());
         * ViewLocation view = ViewConfig.covertpixeltocelrow(a.getX(),
         * a.getY()); // System.out.println(view.posX+" " + view.posY);
         * ViewLocation view1 = findnext(view); System.out.println("view1 " +
         * view1.posX + " " + view1.posY); System.out.println("view " +
         * view.posX + " " + view.posY);
         */
//        a.setX(a.getX() + view1.posX - view.posX);
        //      a.setY(a.getY() + view1.posY - view.posY);
        //return next 
        //System.out.println(view.posX + "     " + view.posY);
    }
}
