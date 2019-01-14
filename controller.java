import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.rmi.*;
import java.rmi.server.*;
class controller extends JPanel implements ActionListener
{
	JRadioButton shutdown,restart,logoff;
	ButtonGroup bg=new ButtonGroup();
	JButton ok;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel p4;
	Font f=new Font("Arial",Font.BOLD,16);
	JLabel lab=new JLabel("What do you want terminal controller to do?");
	JLabel sysid=new JLabel("Enter the system id :");
	JTextField tf1=new JTextField(15);
	ImageIcon ok_default=new ImageIcon("icons/ok_button.gif");
	ImageIcon ok_mouseover=new ImageIcon("icons/ok_button1.gif");
	
	 Color c=new Color(185,255,220);
	 Color c1=new Color(224,226,228);
    public controller()
	{	

		tf1.setBackground(c1);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p3.setLayout(new GridLayout(4,1));
		setLayout(new FlowLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		setBackground(c);
		p1.setBackground(c);
		p2.setBackground(c);
		p3.setBackground(c);
		p4.setBackground(c);
		p2.setLayout(new FlowLayout());
		p1.setLayout(new GridLayout(5,1));
		shutdown=new JRadioButton("shutdown",true);
		restart=new JRadioButton("Restart");
		logoff=new JRadioButton("Log off");
		shutdown.setBackground(c);
		restart.setBackground(c);
		logoff.setBackground(c);
		ok=new JButton(ok_default);
		ok.setRolloverIcon(ok_mouseover);
		ok.setBackground(c);
		ok.setBorder(null);
		sysid.setFont(f);
		p2.add(sysid);
		p2.add(tf1);
		c1.gridy = 0;
		add(p2,c1);
		 c1.gridy = 1;
		lab.setFont(f);
		add(lab,c1);
		shutdown.setFont(f);
		restart.setFont(f);
		logoff.setFont(f);
		bg.add(shutdown);
		bg.add(restart);
		bg.add(logoff);
		p3.add(shutdown);
		p3.add(restart);
		p3.add(logoff);
		c1.gridy = 2;
		add(p3,c1);
   	    p4.add(ok);
		c1.gridy = 3;
		add(p4,c1);
		ok.addActionListener(this);
	
		
		
	}
	public void actionPerformed(ActionEvent ae)
		{
		 try{ if(ae.getSource()==ok)
		 	{  
		if(tf1.getText().length()==0)
			JOptionPane.showMessageDialog(null,"please enter system ipaddress");
			else{
			JOptionPane jpane=new JOptionPane();
			 int result=jpane.showConfirmDialog(null,"Are you sure to logoff the system","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			 if(result==JOptionPane.YES_OPTION)
			{
				String url = "//" + tf1.getText() + ":1099//RObjectServer";
			System.out.println("//" + tf1.getText() + ":1099//RObjectServer");
			intf intf1 = (intf)Naming.lookup(url);
			System.out.println("c1");
			if(shutdown.isSelected())
				{
				if(intf1.Alert("r u there")=='n')
				intf1.shutdown();
	    		else
				{
				JOptionPane jp=new JOptionPane();
				int res=jp.showConfirmDialog(null,"System is being used still you want to continue","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(res==JOptionPane.YES_OPTION)
 				intf1.shutdown();
				}

				 }
				else
				  if(restart.isSelected())
				 	{
					 if(intf1.Alert("r u there")=='n')
				intf1.restart();
	    		                 else
				{
				JOptionPane jp=new JOptionPane();
				int res=jp.showConfirmDialog(null,"System is being used still you want to continue","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(res==JOptionPane.YES_OPTION)
 				intf1.restart();
				}
					}
				else
			               if(logoff.isSelected())
					{
                   			if(intf1.Alert("r u there")=='n')
				intf1.logoff();
	    		                 else
				{
				JOptionPane jp=new JOptionPane();
				int res=jp.showConfirmDialog(null,"System is being used still you want to continue","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(res==JOptionPane.YES_OPTION)
 				intf1.logoff();
				}
			}
				                 }
	    	}
			}
		}
catch(Exception e)
{
	System.out.println(e);
}
}
		}