package DaHinh;



import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<IArea> shapeVector = new Vector<>();
        shapeVector.add(new Circle(0, 0, 5));
        shapeVector.add(new Rectangle(0, 0, 4, 5));
        shapeVector.add(new Triangle(0, 0, 1, 1, 4, 4));
        double sumArea = 0;

        for(IArea s: shapeVector){
            System.out.println(s.getClass().toString());
//            if(s.getClass().toString().equals("class DaHinh.Circle"))
//            {
//                System.out.println("ok lah");
//            }
            // kiem tra xem thuc the co phai circle k?
            if(s instanceof Rectangle){
                sumArea += ((Rectangle) s).area();
            }
        }
        System.out.println(sumArea);


    }
}
