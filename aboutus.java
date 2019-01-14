import javax.swing.*;
import java.awt.*;
class aboutus extends JPanel
{
	ImageIcon image=new ImageIcon("icons/aboutusdata.gif");
	JLabel data=new JLabel(image);
	Color c=new Color(185,255,220);
	aboutus()
	{	
		add(data);	
		setBackground(c);
		setSize(800,600);
		setVisible(true);
	}
	
}
