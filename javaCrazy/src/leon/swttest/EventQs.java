package leon.swttest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventQs
{
	private Frame f = new Frame("test event");
	private Button ok = new Button("confirm");
	private TextField tf = new TextField(30);

	public void init()
	{
		ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("the user hit OK button");

			}
		});

		f.add(tf);
		f.add(ok, BorderLayout.SOUTH);
		f.addWindowListener(new WindowListener()
		{

			@Override
			public void windowOpened(WindowEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e)
			{
				System.out.println("closing");
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e)
			{
				// TODO Auto-generated method stub

			}
		});
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		new EventQs().init();
	}
}
