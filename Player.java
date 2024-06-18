
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class Player extends JPanel{

    int x=0;
    int y=0;
    int speed=5;
    int directionX=0;
    int directionY=0;
    Player(){
        super();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 60, 60);
    }

    public void move(){
        x=x + directionX*speed;
        y=y + directionY*speed;

    }
    public void stop(){
        directionX=0;
        directionY=0;
    }

    public void update(KeyEvent e){
        int code =e.getKeyCode();
        switch (code) {
        //left
            case 37:
                directionX=-1;
                break;
            case 39:
                //right
                directionX=1;
                break;
            case 38:
                //up
                directionY=-1;
                break;
            case 40:
                //down
                directionY=1;
                break;
            default:
                break;
        }
        System.out.println(code);

    }
    
    }

