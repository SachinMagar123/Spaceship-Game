
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class FirstBox extends JPanel implements Runnable{


    Thread thread;
    Enemy[] enemies=new Enemy[10];
    Player player =new Player();
    FirstBox()
    {
        super();
        this.setPreferredSize(new Dimension(500,300));
        this.setBackground(Color.black);
        for (int i = 0; i < enemies.length; i++) {
            enemies[i]=new Enemy();
        }

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                System.out.println("user pressed the key");
                player.update(e);
            }
            @Override
            public void keyReleased(KeyEvent e)
            {
                player.stop();
            }
        });
    }
@Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0; i < enemies.length; i++) {
             enemies[i]=new Enemy();
        enemies[i].paintComponent(g);
        }
        player.paintComponent(g);
    }

    public void startgame(){
        thread =new Thread(this);
        thread.start();

    }
    public void update(){
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].update();
        }
        player.move();

    }

    @Override
    public void run() {
        double drawInterval = 1000000000/60;
        double deltaTime =0;
        long LastPassedTime =System.nanoTime();
        long currentTime ;

        while(thread!=null)
        {
         currentTime=System.nanoTime();
         deltaTime+=(currentTime - LastPassedTime)/drawInterval;
         LastPassedTime = currentTime;

         if(deltaTime>=1)
         {
            update();
            repaint();
            deltaTime--;
         }
        }
    }
}
