import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class Parrot extends Bird{
    public Parrot() {
        super();
        this.name = "Parrot";
        this.color = "  Red";
        this.weight = 1;
        try {
            this.sprite = ImageIO.read( new File("Resources/Parrot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sound() {
        System.out.println("Sao mày ngu thế");
    }

    @Override
    public void move() {
        System.out.println("Flying");
    }

}
