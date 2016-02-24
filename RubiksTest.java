import java.awt.*;
import java.applet.*;																
import java.util.*;

public class RubiksTest extends Applet
{
   public void paint(Graphics g)
   //public static void main(String[]args)
   {
      Rubiks cube = new Rubiks();
      
      cube.L(10);
      
      cube.drawCubeNet(g);

   
   
      
   
   }
}