package DaHinh;


public class Triangle extends Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Triangle() {
        super();
        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
    }

    @Override
    public double area() {
        return 10;
    }

//    @Override
//    public double area() {
//        return 10;
//        }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }

    public Triangle(int x, int y, int x1, int y1, int x2, int y2) {
        //super(x, y);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public double iArea() {
        return 0;
    }
}
