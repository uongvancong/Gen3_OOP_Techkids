import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class Tiger extends Cat {
    public Tiger() {
        super();
        this.name = "Tiger";
        this.color = "Red";
        this.weight = 40;
        try {
            this.sprite = ImageIO.read( new File( "Resources/Tiger.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void sound() {
        System.out.println("Gừ Gừ");
    }

    @Override
    public void move() {
        System.out.println("Chạy");
    }
}
