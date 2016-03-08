package DaHinh;

public abstract class Shape implements IArea {
    private int x;
    private int y;

    public Shape(){
        this.x = 0;
        this.y = 0;
    }

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract double area();


    public abstract void draw();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move() {

    }
}
