import java.awt.*;
import java.applet.*;	
import java.io.IOException;
import java.util.*;


public class Test extends Applet 
{
   public void paint(Graphics g)
   //public static void main(String[]args)
   {
	  try 
	  {

		  this.setSize(1800, 250);
		  Rubiks cube = new Rubiks();
		  char[] f = {'o', 'y', 'y', 'o', 'b', 'g', 'r', 'b', 'y'};
		  char[] b = {'b', 'y', 'w', 'w', 'g', 'o', 'o', 'w', 'b'};
		  char[] r = {'o', 'r', 'r', 'r', 'o', 'g', 'r', 'o', 'y'};
		  char[] l = {'b', 'w', 'g', 'w', 'r', 'y', 'o', 'y', 'g'};
		  char[] u = {'r', 'b', 'y', 'b', 'y', 'b', 'w', 'r', 'g'};
		  char[] d = {'w', 'o', 'g', 'g', 'w', 'g', 'w', 'r', 'b'};
		  
		  cube = CubeInputs.getCube(f,b,r,l,u,d);
		  cube.drawCubeNet(g);
		  
		  /*cube.beginStepRecord();
		  Solver.solve(cube);
		  cube.drawCubeNet(g);
		  cube.endStepRecord();*/
	  
	  
	  
	  
	  
	  }
	  catch (IOException e) 
	  {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  }
   }
}
