package DaHinh;


public class Circle extends Shape {
    private int radius; //ban kinh

    public Circle() {
        super();//goi khoi tao khong tham so cua shape
        this.radius = 0;
    }

    @Override
    public double area() {

        return (this.radius * this.radius * Math.PI);
    }

//    @Override
//    public double area() {
//        return (this.radius*this.radius*Math.PI);
//    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double iArea() {
        return 0;
    }
}
