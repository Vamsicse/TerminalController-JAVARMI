import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableColumn;
import java.util.*;
public class MyTableModel
	{

		String found[];;
		    
		String path,name;
	    int fcount=0;
	    String s1;
		String sfile;
		LinkedList l;
 MyTableModel(String drive,String filename)
	{
	l=new LinkedList();
	s1=drive;
	sfile=filename;
	
	}
public LinkedList exec()
	{
 try{
	    if (s1.length() > 0)
	      {
            System.out.println("recursive Dir from " + s1);
            recurseInDirFrom(s1,sfile);
            System.out.println("end");

			
          
		  }
	   }
	   catch(Exception e)
	 {
  System.out.println(e);
          
	 }
	return l;

	}
	
        
public void recurseInDirFrom(String dirItem,String sfile) throws Exception {    
  File file;
  String tfile,ufile,search,usearch,startwith;
  String list[];
  int ext=sfile.indexOf(".");
  String strfile=sfile;
   file = new File(dirItem);
   getlength len=new getlength();
   if (file.isDirectory()) 
	  {
		  found = new String[4];
	   if(dirItem.equals(sfile)){
	   found[0]=sfile;
	   found[1]=dirItem;
	   found[2]="";
	   found[3]="File Folder";
	   System.out.println(sfile+"   "+dirItem);	   
	    fcount++;
	   l.add(found);
			
	   }
	list = file.list();
    for (int i = 0; i < list.length; i++)
	  {
		String type;
		if(list[i].endsWith("System Volume Information"))
		continue;
		recurseInDirFrom
       (dirItem + File.separatorChar + list[i],sfile);
		if(list[i].indexOf('.')>0)
		type=list[i].substring(list[i].indexOf(".")+1,list[i].length())+" File";
	     else
			 type="File Folder";
	   if(ext<0)
		  {
	      if(sfile.indexOf("*")>=0)
			  {
				strfile=sfile.substring(0,sfile.indexOf("*"));
			  if((list[i].toLowerCase().startsWith(strfile.toLowerCase())))
				  {
					  found = new String[4];
				 found[0]=list[i];
	             found[1]=dirItem;
				found[2]=type;
				 if(list[i].indexOf('.')<0)
				  found[3]="";
				 else{
	   		double flength=len.len(dirItem,list[i]);
		       	 found[3]=""+flength+"KB";}
				 fcount++;				 
				l.add(found);
                  
				  }
			  }
			else if((list[i].toLowerCase().lastIndexOf(strfile.toLowerCase()))>=0)
			  {
				  found = new String[4];
	          found[0]=list[i];
	          found[1]=dirItem;
			  found[2]=type;
				 if(list[i].indexOf('.')<0)
				  found[3]="";
				 else{
	   		double flength=len.len(dirItem,list[i]);
		       	found[3]=""+flength+"KB";}
			  fcount++;			  
				l.add(found);
                  
			  }
		  }
		  else 
		  {
			 if(strfile.indexOf('*')>=0)
			  {
		   startwith=strfile.substring(0,strfile.indexOf("*"));             
		   startwith=startwith.toLowerCase();
		   search=list[i].substring(list[i].indexOf(".")+1,list[i].length());     
			search=search.toLowerCase();
			usearch=strfile.substring(strfile.indexOf(".")+1,strfile.length());     
			 
			  if(list[i].toLowerCase().startsWith(startwith))
				  {
					if(usearch.equalsIgnoreCase(search))
					  {
						  found = new String[4];
				 found[0]=list[i];
	             found[1]=dirItem;
				 found[2]=type;
				 if(list[i].indexOf('.')<0)
				  found[3]="";
				 else{
	   		double flength=len.len(dirItem,list[i]);
		       	found[3]=""+flength+"KB";}
				 fcount++;
				 
				l.add(found);
		 }
			      }
				
			 }
			 else if(strfile.equalsIgnoreCase(list[i]))
			  {
				  found = new String[4];
				 found[0]=list[i];
	             found[1]=dirItem;
				 found[2]=type;
				 if(list[i].indexOf('.')<0)
				  found[3]="";
				 else{
	   			double flength=len.len(dirItem,list[i]);
		      	 found[3]=""+flength+"KB";}
				 fcount++;
				 
				l.add(found);


			  }
			  
		  }

	  
	 
        }
     }
	  	
 }
   
            
       
        
}