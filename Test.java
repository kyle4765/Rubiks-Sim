import java.awt.*;
import java.applet.*;																
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter; 


public class Test extends Applet implements KeyListener
{
   public void paint(Graphics g)
   //public static void main(String[]args)
   {
      this.setFocusable(true);
      
      Rubiks cube = new Rubiks();
      
      cube.L(10);
      
      cube.drawCubeNet(g);

   
   
      
   
   }
}
