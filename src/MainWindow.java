import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow  extends JFrame {
    private JButton jb1;
    public  MainWindow() {
        setTitle("Snake-level1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(480, 480);
        setLocation(600, 200);
        add(new GameField());
        setVisible(true);
//        setLayout(new FlowLayout());
//        jb1 = new JButton("Start");
//        add(jb1);
//        Start op = new Start();
//        jb1.addActionListener(op);


    }
    public class Start implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           // add(new GameField());

        }

        }

}

//    public static void main(String[] args) {
//        MainWindow mw = new MainWindow();
//        JButton start = new JButton();
//        start.setText("   Start  ");
//        start.setSize(100, 20);
//        start.setLocation(185, 240);
//        ActionListener listener1 = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//            }
//
//        };start.addActionListener(listener1);
