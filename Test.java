import java.awt.*;
import java.applet.*;	
import java.io.IOException;
import java.util.*;


public class Test extends Applet 
{
   public void paint(Graphics g)
   //public static void main(String[]args)
   {
	  try {
		  
		  
		  
	  this.setSize(1800, 250);
	  Rubiks cube;
	  cube = new Rubiks();
	  cube.drawCubeNet(g);
	  Solver.shuffleCube(cube, 100, true, false);
	  cube.beginStepRecord();
	  Solver.solve(cube);
	  cube.endStepRecord();
	  
	  
	  
	  
	  } catch (IOException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  }
   }
}
