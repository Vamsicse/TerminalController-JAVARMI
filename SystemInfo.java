import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.text.*;
import javax.swing.table.*;
public class SystemInfo extends AbstractTableModel
{
	JFrame frame = new JFrame();
	String str="";
	JTable t;
	String found[][] = new String[300][2];
	String columnNames[] = { "Name", "Description" };
	Font f = new Font("Arial", Font.BOLD, 16);
	SystemInfo(String ip)
	{
		//super("SYSTEM CONFIGURATION");
		try
		{
			LinkedList l = new LinkedList();
			Iterator it = l.iterator();
			String url = "//" + ip + ":1099/RObjectServer";
			intf intf1 = (intf)Naming.lookup(url);
			System.out.println("c1");
			l = intf1.systeminfo();
			it = l.iterator();
			int row = 0;

			while (it.hasNext())
			{				
				StringBuffer sb=new StringBuffer((String)it.next());
				try
				{
					found[row][0]=sb.substring(0, sb.toString().indexOf(":")).trim();
					found[row][1] = sb.substring(sb.toString().indexOf(":") + 1).trim();
					row++;
				}
				catch (Exception e)
				{
				}
				
			}	
		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		t = new JTable(found,columnNames);
		t.setRowHeight(35);
		t.setShowVerticalLines(false);
		t.setShowHorizontalLines(false); 
		JScrollPane spane = new JScrollPane(t);
		frame.getContentPane().add(spane);
		ListSelectionModel listMod = t.getSelectionModel();
		listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.setSize(500, 500);
		frame.setVisible(true);

	}
	public int getColumnCount()
	{
		return columnNames.length;
	}

	public int getRowCount()
	{
		return found.length;
	}

	public String getColumnName(int col)
	{
		return columnNames[col];
	}

	public Object getValueAt(int row, int col)
	{
		return found[row][col];
	}


	public boolean isCellEditable(int row, int col)
	{
		return false;
	}

	public static void main(String args[])
	 {
		SystemInfo c = new SystemInfo("localhost");
 
	 }
}
	