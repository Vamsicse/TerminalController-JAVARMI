import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
 
	
public class dialog extends JDialog  implements ActionListener
{
	JButton button=new JButton("ok");
	JLabel label;
	JPanel p1=new JPanel();
	JPanel p2 = new JPanel();
	public  char ch;


	dialog(String msg) 
	{  
		 ch='n';
		 label = new JLabel(msg);
		p1.setLayout(new GridLayout(2,1));
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		p1.add(label);
		p2.add(button);
		p1.add(p2);
		c1.anchor = GridBagConstraints.CENTER;
		getContentPane().add(p1,c1);	
		button.addActionListener(this);
		
		

	}
	public void actionPerformed(ActionEvent e)
	{
		ch='y';
		setVisible(false);

	}	
public static void main(String arg[]) throws Exception
{
dialog d=new dialog("Admin  : This is a msg from admin");
d.setSize(400, 200);
d.setVisible(true);

}
}
