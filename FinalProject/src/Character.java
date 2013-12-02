import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Character {
	private String sprite = "polarpop.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    
    private ArrayList<Arrow> arrows;
    private final int CRAFT_SIZE = 20;

    public Character() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(sprite));
        image = ii.getImage();
        arrows = new ArrayList<Arrow>();
        x = 40;
        y = 60;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }

    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_D && arrows.size() == 0) {
        	arrows.add(new Arrow(x + CRAFT_SIZE, y, 2, 0 , 0));
        }
        
        if (key == KeyEvent.VK_S && arrows.size() == 0) {
        	arrows.add(new Arrow(x, y + CRAFT_SIZE, 0, 2, 1));
        }
        
        if (key == KeyEvent.VK_A && arrows.size() == 0) {
        	arrows.add(new Arrow(x - CRAFT_SIZE, y, -2, 0 , 2));
        }
        
        if (key == KeyEvent.VK_W && arrows.size() == 0) {
        	arrows.add(new Arrow(x, y - CRAFT_SIZE, 0, -2, 3));
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            dy = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            dy = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            dx = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            dx = 0;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if(dx != 1)
        	dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	if(dx != -1)
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
        	if(dy != 1)
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
        	if(dy != -1)
            dy = 0;
        }
    }
}
