import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;



public class Background extends JPanel
{

	String imageLocation = "F:/git/GuitarHero/Fun/download.jpg";
	Image background = Toolkit.getDefaultToolkit().createImage(imageLocation);
	Image scaledImage = background.getScaledInstance(1280, 720, Image.SCALE_FAST);

	public Background()
	{
		
		setBounds(0, 0, 1000, 1000);
		setLayout(null);
		
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		g.setColor(Color.BLUE);
		g.drawLine(80, 0, 80, 960);
		g.drawLine(160, 0, 160, 960);
		g.drawLine(240, 0, 240, 960);
		g.drawLine(320, 0, 320, 960);
		g.drawLine(400, 0, 400, 960);
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, 480, 920);
		g.setColor(Color.RED);
		g.fillRect(0, 720, 480, 5);
		
	
	}
}
