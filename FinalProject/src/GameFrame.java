import javax.swing.JFrame;



public class GameFrame extends JFrame {
	public GameFrame(){
		add(new Board());
        setTitle("Quest for the Polar Pop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
	}

	public static void main(String[] args) {
		new GameFrame();

	}

}
