import java.io.*;
public  class getlength 
{
	public double len(String dir,String file) throws Exception
	{
	 String path=dir+"\\"+file;
	 double len=0;
	 
		File f=new File(path);
	   FileInputStream fin=new FileInputStream(f);
	   
	   while((fin.read())!=-1)
		   len++;
	   fin.close();
	   len=len/1024;
	   len=Math.ceil(len);
	   return len;
	
	}
}
