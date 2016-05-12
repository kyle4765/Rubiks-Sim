import java.awt.*;
import java.applet.*;																
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter; 


public class Test extends Applet 
{
   public void paint(Graphics g)
   //public static void main(String[]args)
   {
	  this.setSize(1800, 250);
	  boolean allSolved = true;
	  int tests = 100000;
	  for (int k = 0; k < tests; k++)
	  {
		  Rubiks cube = new Rubiks();
		  Solver.shuffleCube(cube, 1000, true, true);
		  Solver.solve(cube);
		  if (!cube.isSolved())
			  allSolved = false;
	  }
	  if (allSolved)
		  System.out.println("Of " + tests + " tests, all were correctly solved");
	  else
		  System.out.println("LOL you done didnt do it!");
      /*Rubiks cube = new Rubiks();
      cube.drawCubeNet(g);
       
      Solver.shuffleCube(cube, 1000, true, true);
      cube.addX(200);
      cube.drawCubeNet(g);
      
      WhiteCross.solve(cube);
      cube.addX(200);
      cube.drawCubeNet(g);
      
      WhiteCorners.solve(cube);
      cube.addX(200);
      cube.drawCubeNet(g);
      
      SecondLayer.solve(cube);
      cube.addX(200);
      cube.drawCubeNet(g);
      
      YellowCross.solve(cube);
      cube.addX(200);
      cube.drawCubeNet(g);
      
      YellowFace.solve(cube);
      cube.addX(200);
      cube.drawCubeNet(g);
      
      FinalLayer.solve(cube);
      cube.addX(200);
      cube.drawCubeNet(g);*/
      
   }
}
