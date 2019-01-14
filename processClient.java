import java.rmi.*;
import java.rmi.server.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.BreakIterator;
public class processClient extends AbstractTableModel
{
	JFrame f=new JFrame();
	JTable ta;
	String str="";
	String[] columnNames = {"PROCESS NAME","P ID","SESSION ID","Session#","Mem Usage"};
	String found[][]=new String[50][5];
	int row=0,col=0;
	//AbstractTableModel a = new AbstractTableModel();

processClient(String ip) throws Exception
{
	LinkedList l=new LinkedList();
	Iterator it=l.iterator();
	String url = "//" + ip + ":1099/RObjectServer";
	intf intf1 = (intf)Naming.lookup(url);
	System.out.println("c1");
	l=intf1.checkService();
	it=l.iterator();
	it.next();
	it.next();
	it.next();
	it.next();
	while(it.hasNext())
	{
		String str=(String)it.next();
		BreakIterator brkit = BreakIterator.getLineInstance () ; 
		brkit.setText ( str ) ;
		int start = brkit.first (  ) ; 
		int end = brkit.next (  ) ; 

		String x[]=new String[500];

		col=0;
		String sentence ;

		while  ( end != BreakIterator.DONE )   
		{  
			sentence = str.substring (start, end ) ;
			sentence=sentence.trim();
			System.out.println(sentence + "  " + sentence.equals("exe"));
			
			if(!sentence.equals("exe"))
			{
				x[col]=sentence;
				col++;
			}
			else
				x[col-1]=x[col-1]+ sentence ;
			
			start = end;
			end = brkit.next () ;			
		}
		System.out.println("");		
		for(col=0;col<5;col++)
		{
				found[row][col]=x[col];
		}	
		row++;
	}
	ta=new JTable(found,columnNames);
	ta.setCellSelectionEnabled(true);
	ta.setRowHeight(25);
	ta.setColumnSelectionAllowed(false);
	ta.setShowVerticalLines(false);
	ta.setShowHorizontalLines(false); 
	JScrollPane sp=new JScrollPane(ta);
	f.getContentPane().add(sp);
	ListSelectionModel listMod = ta.getSelectionModel();
	listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	f.setSize(400, 400);
	f.setVisible(true);	
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


public Class getColumnClass(int c)
{
	return getValueAt(0, c).getClass();
}


public boolean isCellEditable(int row, int col)
{

	
		return false;
	
}
	

}
