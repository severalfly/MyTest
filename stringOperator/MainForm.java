import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;


class MainForm2 extends JFrame implements ActionListener, DocumentListener
{
	JMenuBar menuBar; //
	JPanel panel;
	JEditorPane textEdit;
	JLabel statusLabel;


	boolean textChangeNoSave;
	boolean docIsNew;

	String filePath;
	String fileName;

	Clipboard clip;
	public MainForm2()
	{
		initGUI();
		//initPara();
	}

	private void initGUI()
	{
		menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        final JMenu[] menu = {new JMenu("File"),// "File"
                new JMenu("Edit"),// "Edit"
                new JMenu("Font"),    //"Font"
                new JMenu("Help")// "Help"
        };
 
        final JMenuItem[][] menuItem = {
                {new JMenuItem("New"), new JMenuItem("Open"),
                        new JMenuItem("Save"), new JMenuItem("Exit")},
                {new JMenuItem("Cut"), new JMenuItem("Copy"),
                        new JMenuItem("Paste")},
                {},
                {new JMenuItem("Help"), new JMenuItem("About")}};
        for(int i = 0; i < menu.length; i++)
        {
        	for (int j = 0 ; j < menuItem[i].length; j++) {
        		menuItem[i][j].setBackground(Color.LIGHT_GRAY);
        		menu[i].add(menuItem[i][j]);
        		menuItem[i][j].addActionListener(this);
        	}
        	menuBar.add(menu[i]);
        }
        JToolBar toolBar = new JToolBar();
        String[] toolButtonText = {"New", "Open", "Exit"};
        JButton[] toolButton = new JButton[toolButtonText.length];
        for (int i = 0; i < toolButtonText.length; i++) {
        	toolButton[i] = new JButton(toolButtonText[i]);
        }
        for (int i=0; i<toolButton.length; i++) {
        	toolButton[i].setActionCommand(toolButtonText[i]);
        	toolButton[i].addActionListener(this);
        	toolBar.add(toolButton[i]);
        }


        textEdit = new JEditorPane();
        textEdit.setBackground(Color.DARK_GRAY);
        textEdit.setForeground(Color.LIGHT_GRAY);
        textEdit.getDocument().addDocumentListener(this);

        JScrollPane scrollPane = new JScrollPane(textEdit);

        JToolBar statusBar = new JToolBar();
        statusBar.setFloatable(false);
        statusBar.setBackground(Color.LIGHT_GRAY);
        statusLabel = new JLabel(" ");
        statusBar.add(statusLabel);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(statusBar, BorderLayout.PAGE_END);

        this.add(panel);
        this.setJMenuBar(menuBar);
        this.setTitle("NoteBook");
        this.setSize(640,480);
        this.setVisible(true);
	}
	@Override
	public void insertUpdate(DocumentEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		seitch(e.getActionCommand())
		{
			case "New":
			break;
		}
		
	}
}
public class MainForm
{
	public static void main(String[] args) {
		MainForm2 m = new MainForm2();
	}
}