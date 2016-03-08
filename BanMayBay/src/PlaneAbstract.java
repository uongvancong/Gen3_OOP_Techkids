
public abstract class PlaneAbstract extends GameObject {

    public PlaneAbstract(int x, int y, int speed) {
        super(x, y, speed);
    }

    protected abstract void move();

    public abstract void update();

    public abstract void shot();
}
