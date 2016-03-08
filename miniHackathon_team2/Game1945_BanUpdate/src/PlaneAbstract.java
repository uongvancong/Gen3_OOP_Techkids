/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public abstract class PlaneAbstract extends GameObject {
    protected int health;
    protected int damage;
    protected int planeType;


    public PlaneAbstract(int x, int y, int speed, int planeType) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.planeType = planeType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
