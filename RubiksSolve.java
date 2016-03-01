import java.awt.*;
import java.applet.*;																
import java.util.*;

public class RubiksSolve
{
   final Algorithm test = new Algorithm("LR","01");
   
   public static void shuffleCube(Rubiks cube, int turns)
   {
      int face;
      int direction;
      Random rand = new Random();
      for (int k = 0; k < turns; k++)
      {
         face = rand.nextInt(9);
         direction = rand.nextInt(2);
         switch (face)
         {
            case 0 : cube.F(direction); break;
            case 1 : cube.B(direction); break;
            case 2 : cube.R(direction); break;
            case 3 : cube.L(direction); break;
            case 4 : cube.U(direction); break;
            case 5 : cube.D(direction); break;
            case 6 : cube.X(direction); break;
            case 7 : cube.Y(direction); break;
            case 8 : cube.Z(direction); break;
         }
      }
      System.out.println(turns + " random turns complete.");
   }
   public static setFace(Rubiks cube, String f, String t)
   {
      Color front = stringToColor(f);
      Color top = stringToColor(t);
      while (//is front equal to the color of the center of the front face
      
   }
   
   private static Color stringToColor(String s)
   {
      Color c = new Color(0,0,0);
      switch (s.toLowerCase())
      {
         case "blue"    : c = color.blue;     break;
         case "green"   : c = color.green;    break;
         case "red"     : c = color.red;      break;
         case "orange"  : c = color.orange;   break;
         case "white"   : c = color.white;    break;
         case "yellow"  : c = color.yellow;   break;
      }
      return c;
   }
}