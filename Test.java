import java.awt.*;
import java.applet.*;																
import java.util.*;


public class Test extends Applet 
{
   public void paint(Graphics g)
   //public static void main(String[]args)
   {
	  this.setSize(1800, 250);
	  Rubiks cube = new Rubiks();
	  cube.drawCubeNet(g);
	  
      
   }
}
