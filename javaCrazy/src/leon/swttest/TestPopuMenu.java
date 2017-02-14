package leon.swttest;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestPopuMenu
{
	private TextArea ta = new TextArea();
	private Frame f = new Frame("test ");
	PopupMenu pop = new PopupMenu();
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("auto wrap");
	MenuItem copyItem = new MenuItem("copy");
	MenuItem pasteItem = new MenuItem("paste");
	Menu format = new Menu("format");
	MenuItem connentItem = new MenuItem("comment", new MenuShortcut(KeyEvent.VK_SLASH, true));
	MenuItem cancelItem = new MenuItem("cancel comment");

	public void init()
	{
		ActionListener menuListener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String cmd = e.getActionCommand();
				ta.append("hit " + cmd + " menu\n");
				if (cmd.equals("退出"))
				{
					System.exit(0);
				}
			}
		};
		connentItem.addActionListener(menuListener);
		pop.add(autoWrap);
		pop.addSeparator();
		pop.add(copyItem);
		pop.add(pasteItem);
		format.add(connentItem);
		format.add(cancelItem);
		pop.add(new MenuItem("-"));
		pop.add(format);

		final Panel p = new Panel();
		p.setPreferredSize(new Dimension(300, 160));
		p.add(pop);
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger())
				{
					pop.show(p, e.getX(), e.getY());
				}
			}
		});
		f.add(p);
		f.add(ta, BorderLayout.NORTH);
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				ta.append("trying to close\n");
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TestPopuMenu().init();
	}
}
