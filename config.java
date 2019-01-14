import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;
class config extends JPanel implements ActionListener 
{
	JPanel inputpanel=new JPanel();
	JPanel buttonpanel=new JPanel();
	JPanel mainpanel=new JPanel();
	JPanel textpanel=new JPanel();
	JTextField sysid=new JTextField(15);
	JButton ok=new JButton("  OK  ");
	Color c=new Color(185,255,220);
	Color c1=new Color(200,204,200);
	config()
		{
			setLayout(new GridBagLayout());
			GridBagConstraints c1 = new GridBagConstraints();
			mainpanel.setLayout(new GridLayout(2,1));
			inputpanel.setLayout(new GridLayout(1,2));
			JLabel lab=new JLabel("ENTER THE SYSTEM IP ADDRESS");
			inputpanel.add(lab);
			textpanel.add(sysid);
			inputpanel.add(textpanel);
			buttonpanel.add(ok);
			mainpanel.add(inputpanel);
			mainpanel.add(buttonpanel);
			c1.anchor = GridBagConstraints.CENTER;
			add(mainpanel,c1);
			setcolor();
			ok.addActionListener(this);

		}
	
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() ==ok)
		{
			try
			{
				SystemInfo c = new SystemInfo(sysid.getText());
			}
			catch (Exception e1)
			{
				System.out.println(e1);
			}
		}
	
		
	}
void setcolor()
	{

		setBackground(c);
		inputpanel.setBackground(c);
		buttonpanel.setBackground(c);
		mainpanel.setBackground(c);
		textpanel.setBackground(c);
		sysid.setBackground(c1);
	}


	public static void main(String[] args) 
	{
	config p=new config();
	p.setSize(400,400);
	p.setVisible(true);
	
	}
}
