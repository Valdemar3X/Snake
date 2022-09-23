import javax.swing.*;
import java.awt.*;

public class MainWindow2  extends JFrame {
    public  MainWindow2(){
        setTitle("Snake-level2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(480,480);
        setLocation(600, 200);
        add(new GameField2());
        setVisible(true);

    }

    public static void main(String[] args) {
        MainWindow2 mw = new MainWindow2();



    }
}