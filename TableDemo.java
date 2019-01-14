import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.text.BreakIterator;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
public class TableDemo implements ListSelectionListener,ActionListener
{
JFrame frame=new JFrame(); 
private boolean DEBUG = true;
	String found[][] = new String[50][5];
int fcount=0;
String s1;
	String ip = "localhost";
		String sfile;
	int row = 0, col = 0;
	JPanel p1 = new JPanel();
	JButton end = new JButton("End Task");
	int rows;
	String addr;
public TableDemo(String ip)
{
	addr = ip;

        MyTableModel myModel = new MyTableModel(ip);
        JTable table = new JTable(myModel);

	  table.setRowHeight(25);
        table.setShowVerticalLines(false);
    table.setShowHorizontalLines(false); 
Color c=new Color(174,255,174);
table.setSelectionBackground(c);
	table.setGridColor(c);

	ListSelectionModel listMod = table.getSelectionModel();
	listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	listMod.addListSelectionListener(this);
   table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        JScrollPane scrollPane = new JScrollPane(table);
		p1.add(end);
       frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	   frame.getContentPane().add(p1, BorderLayout.SOUTH);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
 frame.setSize(400,400);
 frame.setVisible(true);
 end.addActionListener(this);

  }

	public void valueChanged(ListSelectionEvent e)
	{
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();   
		 rows=lsm.getMinSelectionIndex();

		 System.out.println(found[rows][1]);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			String url = "//" + addr + ":1099/RObjectServer";
			intf intf1 = (intf)Naming.lookup(url);
			System.out.println(url);
			intf1.taskkill(found[rows][1]);
			System.out.println(url + "  " + found[rows][1]);

		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
	}

	class MyTableModel extends AbstractTableModel 
{
	final String[] columnNames = { "PROCESS NAME", "P ID", "SESSION ID", "Session#", "Mem Usage" };

	MyTableModel(String ip)
              {
try{
	LinkedList l = new LinkedList();
	Iterator it = l.iterator();
	String url = "//" + ip + ":1099/RObjectServer";
	intf intf1 = (intf)Naming.lookup(url);
	System.out.println("c1");
	l = intf1.checkService();
	it = l.iterator();
	it.next();
	it.next();
	it.next();
	it.next();
	while (it.hasNext())
	{
		String str = (String)it.next();
		BreakIterator brkit = BreakIterator.getLineInstance();
		brkit.setText(str);
		int start = brkit.first();
		int end = brkit.next();
		String x[] = new String[500];

		col = 0;
		String sentence;

		while (end != BreakIterator.DONE)
		{
			sentence = str.substring(start, end);
			sentence = sentence.trim();
			System.out.println(sentence + "  " + sentence.equals("exe"));

			if (!sentence.equalsIgnoreCase("exe"))
			{
				x[col] = sentence;
				col++;
			}
			else
				x[col - 1] = x[col - 1] + sentence;

			start = end;
			end = brkit.next();
		}
		System.out.println("");
		for (col = 0; col < 5; col++)
		{
			found[row][col] = x[col];
		}
		row++;
	}
		
	   }
	   catch(Exception e)
	 {
  System.out.println(e);
          
	 }
		}
        public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            return found.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return found[row][col];
        }

       
        public boolean isCellEditable(int row, int col) 
		{
                 
			               return false;
				
        }



		public void setValueAt(Object value, int row, int col)
		{
			
				System.out.println("Setting value at " + row + "," + col
								   + " to " + value
								   + " (an instance of "
								   + value.getClass() + ")");
			
		}


	}

	
  
 
    public static void main(String[] args) {
        TableDemo frame = new TableDemo("localhost");
      
      
    }

}
