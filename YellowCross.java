import java.awt.*;

public class YellowCross extends Solver
{
   final static Algorithm curve   = new Algorithm("FURURF", "000111");
   final static Algorithm line    = new Algorithm("FRURUF", "000111");
   
   public static void solve(Rubiks cube)
   {
	   cube.setFace("blue", "yellow");
	   doAlgorithms(cube, findState(cube));
   }
   
   public static int findState(Rubiks cube)
   {
	   if (  (cube.getU()[1].equals(Color.yellow)) && (cube.getU()[3].equals(Color.yellow)) &&
			 (cube.getU()[5].equals(Color.yellow)) && (cube.getU()[7].equals(Color.yellow)) )
		   return 0;
	   if (!((cube.getU()[1].equals(Color.yellow)) || (cube.getU()[3].equals(Color.yellow)) ||
		     (cube.getU()[5].equals(Color.yellow)) || (cube.getU()[7].equals(Color.yellow))) )
		   return 1;
	   for (int k = 0; k < 4; k++)
	   {
		   if (cube.getU()[3].equals(Color.yellow))
		   {
			   if(cube.getU()[1].equals(Color.yellow))
			   {
				   return 2;
			   }
			   else if (cube.getU()[5].equals(Color.yellow))
			   {
				   return 3;
			   }
		   }
		   cube.U(0);
	   }
	   System.out.println("Something in the yellow cross is whack");
	   return -1;     
   }
   
   public static void doAlgorithms(Rubiks cube, int state)
   {
	   switch (state)
	   {
	   case 0 : break;
	   case 1 : cube.algorithm(curve); cube.U(0); cube.algorithm(line); break;
	   case 2 : cube.algorithm(curve); break;
	   case 3 : cube.algorithm(line);; break;
	   }
   }
}
