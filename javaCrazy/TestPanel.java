import java.awt.*;
public class TestPanel
{
	public static void main(String[] args) {
		Frame f = new Frame("test Window");
		Panel p = new Panel();

		p.add(new TextField(20));
		p.add(new Button("hit me"));

		f.add(p);
		f.setBounds(30,30,250,200);
		f.setVisible(true);
	}
}