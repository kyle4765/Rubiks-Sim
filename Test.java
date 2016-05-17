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
		  char[] f = {'b', 'g', 'b', 'g', 'b', 'g', 'b', 'g', 'b'};
		  char[] b = {'g', 'b', 'g', 'b', 'g', 'b', 'g', 'b', 'g'};
		  char[] r = {'r', 'o', 'r', 'o', 'r', 'o', 'r', 'o', 'r'};
		  char[] l = {'o', 'r', 'o', 'r', 'o', 'r', 'o', 'r', 'o'};
		  char[] u = {'y', 'w', 'y', 'w', 'y', 'w', 'y', 'w', 'y'};
		  char[] d = {'w', 'y', 'w', 'y', 'w', 'y', 'w', 'y', 'w'};
		  
		  Rubiks target = CubeInputs.getCube(f,b,r,l,u,d);
		  cube.drawCubeNet(g);
		  WhiteCross.solve(cube,target);
		  cube.drawCubeNet(g);
		  
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
	  catch (IOException e) 
	  {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  }
   }
}
