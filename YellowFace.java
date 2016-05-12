import java.awt.Color;

public class YellowFace extends Solver
{
   final static Algorithm normCorners = new Algorithm("R-U-R-U-R-UU-R", "0-0-1-0-0-00-1");
   final static Algorithm invCorners  = new Algorithm("RUURURUR", "00011010");
   
   public static void solve(Rubiks cube)
   {
	   cube.setFace("blue", "yellow");
	   while (findState(cube) != 0)
		   doAlgorithms(cube, findState(cube));
   }
   
   public static int findState(Rubiks cube)
   {
	   Color y = Color.yellow;
	   for (int k = 0; k < 4; k++)
	   {
		   if (  (cube.getU(0).equals(y)) && (cube.getU(2).equals(y)) &&
			     (cube.getU(6).equals(y)) && (cube.getU(8).equals(y)) )
				   return 0;
		   else if (cube.getR(0).equals(y) && cube.getL(2).equals(y))
			   return 1;
		   else if (cube.getU(6).equals(y) && cube.getR(0).equals(y) &&
				    cube.getB(0).equals(y) && cube.getL(0).equals(y))
			   return 1;
		   else if (cube.getU(6).equals(y) && cube.getF(2).equals(y) &&
				    cube.getB(2).equals(y) && cube.getR(2).equals(y))
			   return 1;
		   else if (cube.getU(0).equals(y) && cube.getU(8).equals(y) &&
				    cube.getL(2).equals(y) && cube.getB(0).equals(y))
			   return 1;
		   else if (cube.getU(0).equals(y) && cube.getU(2).equals(y) &&
				    cube.getF(2).equals(y) && cube.getF(0).equals(y))
			   return 1;
		   cube.U(0);
	   }
	   
	   
	   System.out.println("There's something rotten in Denmark");
	   return -1;   
   }
   
   public static void doAlgorithms(Rubiks cube, int state)
   {
	   switch (state)
	   {
	   case 0  : break;
	   case 1  : cube.algorithm(normCorners); break;
	   case 2  : cube.algorithm(invCorners); break;
	   case -1 : break;

	   }
   }
   

}
