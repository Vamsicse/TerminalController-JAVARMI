
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
public class Serverimpl extends UnicastRemoteObject implements intf
{
	

	public Serverimpl() throws RemoteException
	{
	
	}

	public char Alert(String msg) throws RemoteException
	{
		dialog d=new dialog("Admin  : This is a msg from admin");
		d.setSize(400, 200);
		d.setVisible(true);
		System.out.println("i1");
		System.out.println("i1");
		try
		{
			Thread.sleep(600);
		}
		catch (Exception e)
		{
		}
		d.setVisible(false);
		System.out.println(d.ch);
		return 'y';
	}


	public void shutdown() throws RemoteException
	{
		try
		{
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("shutdown -l");
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
	public void restart() throws RemoteException
	{
		try
		{
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("shutdown -l");
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
	public void logoff() throws RemoteException
	{
		try
		{
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("shutdown -l");
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
	public LinkedList search(String type, String drive) throws RemoteException
	{
		System.out.println("Searching..");
		MyTableModel t = new MyTableModel(drive, type);

		LinkedList l = t.exec();

		return l;



	}

	public LinkedList checkService() throws RemoteException
	{

		String s = "";
		LinkedList l = new LinkedList();
		Iterator it = l.iterator();
		try
		{
			Runtime Rt = Runtime.getRuntime();
			// Get available Process 
			InputStream ip = Rt.exec("tasklist").getInputStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(ip));
			while ((s = in.readLine()) != null)
			{
				l.add(s);
				//str=str+s+"\n";

			}
		}
		catch (IOException e)
		{


		}

		return l;
	}

	public void taskkill(String pid) throws RemoteException
	{
		try
		{
			Runtime rt = Runtime.getRuntime();
			String str = "taskkill /pid " + pid;
			Process proc = rt.exec(str);
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
	public LinkedList systeminfo() throws RemoteException
	{

		String s = "";
		LinkedList l = new LinkedList();
		Iterator it = l.iterator();
		try
		{
			Runtime Rt = Runtime.getRuntime();
			InputStream ip = Rt.exec("systeminfo").getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(ip));
			while ((s = in.readLine()) != null)
			{
				l.add(s);

			}
		}
		catch (IOException e)
		{


		}

		return l;
	}

	public StringBuffer downloadfile(String s) throws RemoteException
	{
		String x = "";
		StringBuffer sb = new StringBuffer("");
		try
		{
			FileInputStream in = new FileInputStream(s);
			DataInputStream din = new DataInputStream(in);
			while ((x = din.readLine()) != null)
			{
				System.out.println(x);
				sb.append(x);
			}
			System.out.println(sb.toString().getBytes());
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return sb;
	}



        public byte[] downloadbyte(String s) throws RemoteException
          {
          byte[] b= new byte[10];
          return b;
          }

}
