import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class BadGuy {
	private String sprite = "badguy.png";
	private Character mainChar;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private boolean move = true;
    

    public BadGuy(int x, int y, Character mainChar) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(sprite));
        image = ii.getImage();
        this.x = x;
        this.y = y;
        this.mainChar = mainChar;
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
    
    public void ai(){
    	dx = 0;
    	dy = 0;
    	if(move == true)
    	{
    		if(mainChar.getX() > this.x)
    			dx = 1;
    		else if(mainChar.getX() < this.x)
    			dx = -1;
    		if(mainChar.getY() > this.y)
    			dy = 1;
    		else if(mainChar.getY() < this.y)
    			dy = -1;
    		move = false;
    	}
    	else
    		move = true;
    }

}
