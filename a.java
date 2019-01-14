import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class a extends JFrame {
   
  public static void main (String args[])
	  {
       a t = new a();
       t.createMainFrame();
      }

  private void createMainFrame() 
	  {
       Splash mySplash= new Splash(this, "icons/plash1.gif");
	   for(int i = 0; i < 100000; i++)
	     {
          System.out.println() ;
         }
		 
	    mySplash.dispose();
		createAndShowGUI();
	   

	}
	public static void createAndShowGUI() 
		{
        JFrame.setDefaultLookAndFeelDecorated(true);
		login frame = new login();
        frame.pack();
		frame.setVisible(true);
		frame.createAndShowGUI();
		
	    }

}


 