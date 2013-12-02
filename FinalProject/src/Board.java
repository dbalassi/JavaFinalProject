import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;


public class Board extends JPanel{
	
	private Timer timer;
	private Character mainChar;
	private BadGuy badGuy;
	
	public Board(){
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
        setDoubleBuffered(true);
		mainChar = new Character();
		badGuy = new BadGuy(300,300,mainChar);
		timer = new Timer();
		timer.schedule(new GameLoop(), 0, 1000 / 125);
		
	}
	
	public boolean isOccupied(int x, int y)
	{
		return false;
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(mainChar.getImage(), mainChar.getX(), mainChar.getY(), this);
		
		g2d.drawImage(badGuy.getImage(), badGuy.getX(), badGuy.getY(), this);
		
		ArrayList ms = mainChar.getArrows();
		
		for (int i = 0; i < ms.size(); i++ ) {
            Arrow m = (Arrow) ms.get(i);
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
        }
		
		Toolkit.getDefaultToolkit().sync();
        g.dispose();
	}
	
	private class GameLoop extends java.util.TimerTask
	{
		public void run()
		{
			ArrayList ms = mainChar.getArrows();

	        for (int i = 0; i < ms.size(); i++) {
	            Arrow m = (Arrow) ms.get(i);
	            if (m.isVisible()) 
	                m.move();
	            else ms.remove(i);
	        }
	        
	        badGuy.ai();
	        badGuy.move();
			mainChar.move();
			repaint();
		}
		
	}
	
	
	 private class TAdapter extends KeyAdapter {

	        public void keyReleased(KeyEvent e) {
	            mainChar.keyReleased(e);
	        }

	        public void keyPressed(KeyEvent e) {
	            mainChar.keyPressed(e);
	        }
	    }
	
}
