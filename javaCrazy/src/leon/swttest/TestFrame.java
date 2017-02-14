package leon.swttest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.Box;

import org.junit.Test;

public class TestFrame
{

	Frame f = new Frame("test");
	Button ok = new Button("confirm");
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox male = new Checkbox("male", cbg, true);
	Checkbox female = new Checkbox("female", cbg, false);
	Checkbox married = new Checkbox("wether married", false);
	Choice colorChooser = new Choice();
	List colorList = new List(6, true);
	TextArea ta = new TextArea(5, 20);
	TextField name = new TextField(50);

	public void init()
	{
		colorChooser.add("red");
		colorChooser.add("blue");
		colorChooser.add("green");
		colorList.add("red");
		colorList.add("green");
		colorList.add("blue");

		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);

		f.add(bottom, BorderLayout.SOUTH);
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);

		Box topLeft = Box.createVerticalBox();
		topLeft.add(ta);
		topLeft.add(checkPanel);

		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.add(top);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TestFrame().init();
		Collection<Object> books = new HashSet<>();
		books.add(new String("huoli"));
		books.add(new String("tianhui"));
		books.add(new String("company"));
		for (Object object : books)
		{
			System.out.println(object);
		}
	}

	@Test
	public void testForEach()
	{
		Collection<Object> books = new HashSet<>();
		books.add(new String("huoli"));
		books.add(new String("tianhui"));
		books.add(new String("company"));
		for (Object object : books)
		{
			System.out.println(object);
		}
	}

	@Test
	public void testSysout()
	{
		System.out.println("leon");
		System.out.println("leon");
	}
}
