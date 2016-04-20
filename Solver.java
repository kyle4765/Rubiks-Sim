import java.awt.*;																
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
      int cases = 6;
      if (middles)
    	  cases = 9;
      for (int k = 0; k < turns; k++)
      {
    	 face = rand.nextInt(cases);
         
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
