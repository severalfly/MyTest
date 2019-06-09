package leon.swttest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class HandDraw
{
	private final int AREA_WIDTH = 500;
	private final int AREA_HEIGHT = 400;
	private int preX = -1;
	private int preY = -1;
	BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	private Frame f = new Frame("hand draw");
	private DrawCanvas drawArea = new DrawCanvas();
	private Color foreColor = new Color(255, 0, 0);

	public void init()
	{
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		drawArea.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				if (preX > 0 && preY > 0)
				{
					g.setColor(foreColor);
					g.drawLine(preX, preY, e.getX(), e.getY());
				}
				preX = e.getX();
				preY = e.getY();
				drawArea.repaint();
			}
		});
		drawArea.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				preX = -1;
				preY = -1;
			}
		});
		f.add(drawArea);
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent key)
			{
				if (key.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
			}
		});
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		new HandDraw().init();
	}

	class DrawCanvas extends Panel
	{
		public void paint(Graphics g)
		{
			g.drawImage(image, 0, 0, null);
		}
	}
}
