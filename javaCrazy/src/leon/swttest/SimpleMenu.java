package leon.swttest;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleMenu
{
	private Frame f = new Frame("test");
	private MenuItem m1 = new MenuItem("m1");
	private MenuItem m2 = new MenuItem("m2");
	private Menu m = new Menu("m");
	private MenuBar ba = new MenuBar();

	public void init()
	{
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("close");
				System.exit(0);
			}
		});
		m.add(m1);
		m.add(m2);
		ba.add(m);
		f.setMenuBar(ba);
		f.pack();
		f.setVisible(true);

	}

	public static void main(String[] args)
	{
		new SimpleMenu().init();
	}
}
