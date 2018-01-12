import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;



public class Squares extends JPanel
{

	Random random = new Random();
	int num = random.nextInt(4) + 1;
	int loc = 0;
	int s = 60;
	int x = 10;
	int y = 0;

	public Squares()
	{

		setLocation(0, 0);
		setBounds(0, 0, 497, 960);
		setOpaque(false);
	
	}

	@Override
	protected void paintComponent(Graphics g)
	{

		super.paintComponent(g);
		g.setColor(new Color(0, 255, 255));
		g.fillOval(80 * (num - 1) + 10, y, s, s);
		g.setColor(Color.YELLOW);
		
		g.setFont(new Font("Serif", Font.BOLD, 56));
		g.drawString("" + Main.currentScore, 410, 50);
	}
}
