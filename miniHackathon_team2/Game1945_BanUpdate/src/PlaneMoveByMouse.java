/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public class PlaneMoveByMouse extends Plane {
    public PlaneMoveByMouse(int x, int y, int speed, int planeType) {
        super(x, y, speed, planeType);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        super.update();
    }


}
