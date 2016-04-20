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
	  this.setSize(1280, 720);
	  
      Rubiks cube = new Rubiks();
      
      cube.X(0);
      cube.drawCubeNet(g);
      
      Solver.shuffleCube(cube, 1000, true, true);
      cube.addY(150);
      cube.drawCubeNet(g);
      
      WhiteCross.solve(cube);
      cube.addY(150);
      cube.drawCubeNet(g);
      
      WhiteCorners.solve(cube);
      cube.addY(150);
      cube.drawCubeNet(g);
      
      SecondLayer.solve(cube);
      cube.addY(-450);
      cube.addX(250);
      cube.drawCubeNet(g);
   }
}
