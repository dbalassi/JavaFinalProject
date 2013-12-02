import java.awt.Image;

import javax.swing.ImageIcon;

public class Arrow {

    private int x, y, dx, dy;
    private Image image;
    boolean visible;

    private final int BOARD_WIDTH = 800;
    private final int BOARD_HEIGHT = 600;
    private final int RANGE = 400;


    public Arrow(int x, int y, int dx, int dy, int direction) {
    	ImageIcon ii = null;
    	if(direction == 0)
    		ii = new ImageIcon(this.getClass().getResource("arrowRight.png"));
    	else if(direction == 1)
    		ii = new ImageIcon(this.getClass().getResource("arrowDown.png"));
    	else if(direction == 2)
    		ii = new ImageIcon(this.getClass().getResource("arrowLeft.png"));
    	else
    		ii = new ImageIcon(this.getClass().getResource("arrowUp.png"));
    		
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
        x += dx;
        y += dy;
        if (x > BOARD_WIDTH || x < -40)
            visible = false;
        if (y > BOARD_HEIGHT || y < -40)
        	visible = false;
    }
}