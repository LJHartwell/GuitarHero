import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main implements ActionListener, KeyListener
{
	static JFrame frame = new JFrame();
	static Background background = new Background();
	Timer timer = new Timer(20, this);
	int note = 0;
	static ArrayList<Squares> squares = new ArrayList<Squares>();
	static Squares current;
	File one = new File("F:/Coding/Fun/test.wav");
	File two = new File("F:/Coding/Fun/two.wav");
	File three = new File("F:/Coding/Fun/three.wav");
	File four = new File("F:/Coding/Fun/four.wav");
	static int currentScore = 0;

	public Main()
	{
		timer.start();
		setupFrame();
	}

	public static void main(String[] args)
	{
		new Main();
	}

	public void setupFrame()
	{
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(497, 960);
		frame.setLocationRelativeTo(null);
		frame.add(background);
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		update();
	}

	public void update()
	{
		for (int i = 0; i < squares.size(); i++)
		{
			background.repaint();
			squares.get(i).repaint();
			squares.get(i).y += 8;
			if (checkOut(squares.get(i)))
			{
				removeNote(squares.get(i));
			}
		}
		note++;
		if (note == 20)
		{
			note = 0;
			squares.add(new Squares());
			background.add(squares.get(squares.size() - 1));
		}
		try
		{
			current = squares.get(0);
		} catch (IndexOutOfBoundsException e)
		{
		}
	}

	public boolean checkOut(Squares square)
	{
		if (square.y > 730)
		{
			return true;
		}
		return false;
	}

	public void keyPressed(KeyEvent event)
	{
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
	}

	@Override
	public void keyTyped(KeyEvent event)
	{
		int key = event.getKeyChar();
		if (key == 49)
			check(1);
		if (key == 50)
			check(2);
		if (key == 51)
			check(3);
		if (key == 52)
			check(4);
		if (key == 53)
			check(5);
		if (key == 54)
			check(6);
	}

	public void check(int lane)
	{
		if (current != null && current.num == lane)
		{
			if (current.y <= 750 && current.y >= 630)
			{
				playSound();
				removeNote(current);
				currentScore++;
			}
		}
	}

	public void playSound()
	{
		try
		{
			File yes = null;
			if (current.num == 1)
			{
				yes = one;
			}
			if (current.num == 2)
			{
				yes = two;
			}
			if (current.num == 3)
			{
				yes = three;
			}
			if (current.num == 4)
			{
				yes = four;
			}
			AudioInputStream audio1 = AudioSystem.getAudioInputStream(yes);
			Clip clip = AudioSystem.getClip();
			clip.open(audio1);
			clip.start();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void removeNote(Squares square)
	{
		background.remove(square);
		squares.remove(square);
	}
}
