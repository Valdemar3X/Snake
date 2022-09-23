import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField2 extends JPanel implements ActionListener {
    private final int SIZE = 480;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 480;
    private Image dot;
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;

    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    public GameField2() {
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);

    }

    public int getDots() {
        return dots;
    }

    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(80, this);
        timer.start();
        createApple();

    }


    public void createApple() {
        appleX = new Random().nextInt(28) * DOT_SIZE;
        appleY = new Random().nextInt(26) * DOT_SIZE;
    }


    public  void  loadImages(){
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }
        } else {
            String str = "Game Over";
            Font f = new Font("My", Font.BOLD, 20);
            g.setColor(Color.WHITE);
            g.setFont(f);
            g.drawString(str, 180, 200);
            button();
        }
    }
    public void  button() {
        JButton continuation = new JButton();
        continuation.setText("New Game");
        continuation.setSize(100, 20);
        continuation.setLocation(185, 240);
        add(continuation);

        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainWindow mw1 = new MainWindow();
            }
        };
        continuation.addActionListener(listener1);
    }



    public  void move(){
        for(int i=dots; i>0; i-- ){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(left){
            x[0] -=DOT_SIZE;
        }
        if(right){
            x[0] +=DOT_SIZE;
        }
        if(up){
            y[0] -=DOT_SIZE;
        }
        if(down){
            y[0] +=DOT_SIZE;
        }

    }
    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            dots++;
            createApple();
        }

    }
    public void checkCollisions(){
        for(int i = dots; i > 0; i--){
            if(i > 4 && x[0] == x[i] && y[0] == y[i]){
                inGame = false;
            }
        }
        if(x[0]>SIZE){
            inGame = false;
        }
        if(x[0]<0){
            inGame = false;
        }
        if(y[0]>SIZE){
            inGame = false;
        }
        if(y[0]<0){
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollisions();
            move();
        }
        repaint();

    }
    class  FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && ! right){
                left = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_RIGHT && ! left){
                right = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_UP && ! down){
                left = false;
                up = true;
                right = false;
            }
            if(key == KeyEvent.VK_DOWN && ! up){
                right = false;
                left = false;
                down = true;
            }

        }
    }
}
