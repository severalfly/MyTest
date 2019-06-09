package leon;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail
{
	public static void main(String[] args) throws Exception {
		final Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.user", "leonmailtest@163.com");
		props.put("mail.password", "ykktoszbczmcajwm");
		Authenticator authenticator = new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};

		Session mailSession = Session.getInstance(props, authenticator);

		MimeMessage message = new MimeMessage(mailSession);

		InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
		message.setFrom(form);


		// set reciever
		InternetAddress to = new InternetAddress("zhangyf_yf@163.com");
		message.setRecipient(RecipientType.TO, to);

		// set chao song
		InternetAddress cc = new InternetAddress("zhangyf@133.cn");
		message.setRecipient(RecipientType.CC, cc);

		message.setSubject("测试邮件");
		message.setContent("<a href='http://www.fkjava.org'>测试的HTML邮件</a>", "text/html;charset=UTF-8");

		Transport.send(message);

	}
}