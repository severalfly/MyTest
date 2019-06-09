package leon.swttest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class SendMailer
{
	private Frame f = new Frame("email test");
	private TextField tf = new TextField(40);
	private Button bt = new Button("send");

	public void init()
	{
		bt.addActionListener(new MailerListener(tf));
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
		f.add(tf);
		f.add(bt, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		new SendMailer().init();
	}
}
