import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.rmi.*;
import java.rmi.server.*;
import javax.swing.JFileChooser.*;
import java.io.*;
class openframe extends JPanel implements ActionListener
{
JPanel mainpanel=new JPanel();
JRadioButton download,upload;
ButtonGroup bg=new ButtonGroup();
JButton b1=new JButton("OK");
String source,addr;
	File dest;
 openframe()
  {
	 //String ip,String src 
	 source = "abc.txt";
	  addr = "localhost";
	setLayout(new FlowLayout());
	mainpanel.setLayout(new GridLayout(3,1,10,10));
	download=new JRadioButton("DOWNLOAD",true);
	upload=new JRadioButton("UPLOAD WITH");
	bg.add(download);
	bg.add(upload);
	mainpanel.add(download);
	mainpanel.add(upload);
	mainpanel.add(b1);
	add(mainpanel);
	b1.addActionListener(this);
  	
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
	if (download.isSelected())
	{
		JFrame sf=new JFrame();
		FileDialog f=new FileDialog(sf,"Save");

		f.show();
		System.out.println(f.getDirectory());
		System.out.println(f.getFile());

			

		try
		{
		String url = "//"+addr+":1099/RObjectServer";
		intf intf1 = (intf)Naming.lookup(url);
		StringBuffer str = intf1.downloadfile(source);
		System.out.println(str);
		FileOutputStream outfile = new FileOutputStream(dest);
			outfile.write(str.toString().getBytes());
			outfile.close();
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
	}
	else if (upload.isSelected())
	{
		JFileChooser chooser = new JFileChooser();
		int status = chooser.showOpenDialog(new frame5());
		chooser.setBackground(Color.pink);
		chooser.setDialogType(JFileChooser.DIRECTORIES_ONLY);
		if (status == JFileChooser.APPROVE_OPTION)
		{
			dest = chooser.getSelectedFile();
			System.out.println("" +dest);
		}
	}

}
}
public static void main(String args[])
{
openframe o=new openframe();
o.setSize(400,400);
o.setVisible(true);
}



}