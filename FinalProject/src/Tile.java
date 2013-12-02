import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Tile {
	private String tileImage = "tile.png";
	private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    
    
    public Tile(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(tileImage));
        image = ii.getImage();
        this.x = x;
        this.y = y;
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
    
    public boolean isOccupied(int x, int y)
  	{
      	if((x > this.x && x < (this.x + this.width)) && (y > this.y && y < (this.y + this.height)))
      		return true;
      	else
      		return false;
  		
  	}
}
