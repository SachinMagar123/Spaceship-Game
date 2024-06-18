
import javax.swing.JFrame;

public class First {
    public static void main(String[] args) {
        JFrame f =new JFrame();
        FirstBox box =new FirstBox();

        f.add(box);

        box.startgame();
        
        f.setSize(700,700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
    }
}
 