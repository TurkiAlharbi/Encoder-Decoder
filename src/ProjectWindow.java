
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ProjectWindow extends JFrame
{
	public static JTextArea instText = new JTextArea ();
	public static JPanel panel = new JPanel ();
		public static JPanel panelE = new JPanel ();
			public static JButton encodeButton = new JButton ("Encode");
			public static JTextField encodeText = new JTextField ("put your input as a stream of 1's and 0's");
		public static JPanel panelD = new JPanel ();
			public static JButton decodeButton = new JButton ("Decode");
			public static JTextField decodeText = new JTextField ("put your input as a stream +, - or 0");
	
	
	
	
	public ProjectWindow ()
	{
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ProjectWindow");
		
			String text = "";
			text+= "This is Encoding/Decoding project for COE241_142 done by:-\n";
			text+= "Abdullah Kaki\n";
			text+= "Turki AlHazmi\n";
			text+= "AbdullElah Abadi\n";
			instText.setText(text);
			
			panel.setLayout(new GridLayout(3,1));
				panelE.setLayout(new FlowLayout() );
					encodeButton.addActionListener(new ButtonsActionListerner ());	
				panelE.add(encodeButton);	
				panelE.add(encodeText);			
				panelD.setLayout(new FlowLayout());
					decodeButton.addActionListener(new ButtonsActionListerner ());
				panelD.add(decodeButton);	
				panelD.add(decodeText);	
		
			panel.add(panelE);
			panel.add(panelD);
			
			
		add(instText,"North");
		add(panel,"Center");
		

		
		setVisible(true);
	}
		
	public static void main (String [] args)
	{
		new ProjectWindow ();
	}
	
	public static  class ButtonsActionListerner implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			if(e.getActionCommand().equals(encodeButton.getActionCommand()))
			{
				new PlotingWindow (encodeText.getText());
			}
			else
			{
				new DecoderWindow (decodeText.getText());
			}
		}
	}
}