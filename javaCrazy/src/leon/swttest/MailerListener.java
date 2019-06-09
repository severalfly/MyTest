package leon.swttest;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailerListener implements ActionListener
{
	private TextField mailAddress;

	public MailerListener()
	{
		// TODO Auto-generated constructor stub
	}

	public MailerListener(TextField mailAddress)
	{
		this.mailAddress = mailAddress;
	}

	public void setMailAddress(TextField mailAddress)
	{
		this.mailAddress = mailAddress;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String address = this.mailAddress.getText();
		System.out.println("send email to " + address);;

	}

}


