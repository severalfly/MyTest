package leon.swttest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Timer;

public class PinBall
{
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	private final int RACKET_Y = 340;
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;
	private final int BALL_SIZE = 16;
	private Frame f = new Frame("ball game");
	Random random = new Random();
	private int ySpeed = 10;
	private double xyRate = random.nextDouble() - 0.5;
	private int xSpeed = (int) (ySpeed * xyRate * 2);
	private int ballX = random.nextInt(200) + 20;
	private int ballY = random.nextInt(120) + 10;
	private int racketX = random.nextInt(200);
	private MyCanvas tableArea = new MyCanvas();
	private String shape = "";
	private Timer timer;
	private boolean isLose = false;

	public void init()
	{
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		f.add(tableArea);
		KeyAdapter keyProcessor = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode() == KeyEvent.VK_LEFT)
				{
					if (racketX > 0)
					{
						racketX -= 10;
					}
				}
				if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if (racketX < TABLE_WIDTH - RACKET_WIDTH)
					{
						racketX += 10;
					}
				}
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
				if (isLose)
				{
					if (ke.getKeyCode() == KeyEvent.VK_SPACE)
					{
						timer.start();
						isLose = false;
						ballX = random.nextInt(200) + 20;
						ballY = random.nextInt(120) + 20;
					}
				}
			}
		};
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		ActionListener taskPerformer = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE)
				{
					xSpeed *= -1;
				}
				if(ballY >= RACKET_Y - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH))
				{
					timer.stop();
					isLose = true;
					tableArea.repaint();
				}
				else if (ballY <= 0 || (ballY >= RACKET_Y - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH))
				{
					ySpeed *= -1;
				}
				ballX += xSpeed;
				ballY += ySpeed;
				tableArea.repaint();
			}
		};
		timer = new Timer(100, taskPerformer);
		timer.start();
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		new PinBall().init();
	}

	class MyCanvas extends Panel
	{
		public void paint(Graphics g)
		{
			if (isLose)
			{
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("times", Font.BOLD, 30));
				g.drawString("game over", 50, 200);
			}
			else
			{
				g.setColor(new Color(240, 240, 80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
}
