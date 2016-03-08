/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public class PlaneMoveByKey extends Plane {


    public PlaneMoveByKey(int x, int y, int speed, int planeType) {
        super(x, y, speed, planeType);
    }

    public void move() {
        if(direction == 0) {
            return ;
        }
        else if(direction == 1) {
            y -= speed;
        }
        else if(direction == 2) {
            y += speed;
        }
        else if(direction == 3) {
            x -= speed;
        }
        else if(direction == 4) {
            x += speed;
        }
    }

    public void update() {
        super.update();
        this.move();
    }


}
