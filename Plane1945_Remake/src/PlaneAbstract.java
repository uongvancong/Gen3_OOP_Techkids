
public abstract class PlaneAbstract extends GameObject {
    private int hp;


    public PlaneAbstract(int positionX, int positionY, int speed) {
        super(positionX, positionY, speed);
    }

    protected abstract void move();

    public abstract void update();

    public abstract void shot();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
