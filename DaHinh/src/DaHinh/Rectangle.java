package DaHinh;


public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
        super();
        this.width = 0;
        this.height = 0;
    }

    @Override
    public double area() {
        return (this.width * this.height);
    }

//    @Override
//    public double area() {
//        return (this.width * this.height);
//    }

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double iArea() {
        return 0;
    }
}
