import java.awt.*;
import java.applet.*;																
import java.util.*;

public class Solver
{
   final Algorithm test = new Algorithm("LR","01");
   
   public static void shuffleCube(Rubiks cube, int turns, boolean middles, boolean output)
   {
      int face;
      int direction;
      String temp = "";
      Random rand = new Random();
      for (int k = 0; k < turns; k++)
      {
         if (middles)
            face = rand.nextInt(9);
         else
            face = rand.nextInt(6);
         
         direction = rand.nextInt(2);
         
         switch (face)
         {
            case 0 : cube.F(direction); temp += "F" + direction + " "; break;
            case 1 : cube.B(direction); temp += "B" + direction + " ";break;
            case 2 : cube.R(direction); temp += "R" + direction + " ";break;
            case 3 : cube.L(direction); temp += "L" + direction + " ";break;
            case 4 : cube.U(direction); temp += "U" + direction + " ";break;
            case 5 : cube.D(direction); temp += "D" + direction + " ";break;
            case 6 : cube.X(direction); temp += "X" + direction + " ";break;
            case 7 : cube.Y(direction); temp += "Y" + direction + " ";break;
            case 8 : cube.Z(direction); temp += "Z" + direction + " ";break;
         }
      }
      //System.out.println(temp);
      if (output)
         System.out.println(turns + " random turns complete.");
   }
   public static void setFace(Rubiks cube, String f, String t)
   {
      Color front = stringToColor(f);
      Color top   = stringToColor(t);
      
      boolean bg = ((f.equals("blue") && t.equals("green"))   || (t.equals("blue") && f.equals("green")));
      boolean wy = ((f.equals("white") && t.equals("yellow")) || (t.equals("white") && f.equals("yellow")));
      boolean ro = ((f.equals("red") && t.equals("orange"))   || (t.equals("red") && f.equals("orange")));
      if (bg || wy || ro)
      {
         System.out.println("Opposite sides can not be front and top at the same time");
      }
      else
      {
         while (!(front.equals(cube.getF()[4])))
         {
            cube.rotateCubeY(0);
            if (front.equals(cube.getF()[4]))
               break;
            cube.rotateCubeX(0);
         }
         while(!(top.equals(cube.getU()[4])))
            cube.rotateCubeZ(0);
      } 
   }
   
   public static Color stringToColor(String s)
   {
      Color c = new Color(0,0,0);
      switch (s.toLowerCase())
      {
         case "blue"    : c = Color.blue;     break;
         case "green"   : c = Color.green;    break;
         case "red"     : c = Color.red;      break;
         case "orange"  : c = Color.orange;   break;
         case "white"   : c = Color.white;    break;
         case "yellow"  : c = Color.yellow;   break;
      }
      return c;
   }
   
   public static boolean colorMatch(Rubiks cube, String face, String pieces)
   {
      Color[] side = new Color[9];
      int x;
      switch (face.toLowerCase())
      {
         case "front"   : side = cube.getF(); break;
         case "back"    : side = cube.getB(); break;
         case "right"   : side = cube.getR(); break;
         case "left"    : side = cube.getL(); break;
         case "top"     : side = cube.getU(); break;
         case "bottom"  : side = cube.getD(); break;
      }
      for (int k = 0; k < pieces.length(); k++)
      {
         x = Integer.parseInt(pieces.substring(k,k+1));
         if (!(side[x].equals(side[4])))
            return false;
            
      }
      return true;
   }
}
