import java.io.IOException;

public class YellowFace extends Solver
{
   final static Algorithm normCorners = new Algorithm("R-U-R-U-R-UU-R", "0-0-1-0-0-00-1");
   final static Algorithm invCorners  = new Algorithm("RUURURUR", "00011010");
   
   public static void solve(Rubiks cube)
   {
	   Rubiks target = new Rubiks();
	   solve(cube,target);
   }
   public static void solve(Rubiks cube, Rubiks target)
   {
	   try{
	   cube.setFace("blue", "yellow");
	   while (findState(cube, target) != 0)
		   doAlgorithms(cube, findState(cube, target));
	   } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }
   }
   
   public static int findState(Rubiks cube, Rubiks target) throws IOException
   {
	   char y = 'y';
	   for (int k = 0; k < 4; k++)
	   {
		   /*if (  (cube.getU(0) == y) && (cube.getU(2) == y) &&
			     (cube.getU(6) == y) && (cube.getU(8) == y) )
				   return 0;
		   else if (cube.getR(0) == y && cube.getL(2) == y)
			   return 1;*/
		   if ( ((cube.getU(0) == target.getU(0) && cube.getL(0) == target.getL(0)) ||
				 (cube.getU(0) == target.getU(2) && cube.getL(0) == target.getB(0)) ||
				 (cube.getU(0) == target.getU(6) && cube.getL(0) == target.getF(0)) ||
				 (cube.getU(0) == target.getU(8) && cube.getL(0) == target.getR(0)))&&
						
			    ((cube.getU(2) == target.getU(0) && cube.getB(0) == target.getL(0)) ||
				 (cube.getU(2) == target.getU(2) && cube.getB(0) == target.getB(0)) ||
				 (cube.getU(2) == target.getU(6) && cube.getB(0) == target.getF(0)) ||
				 (cube.getU(2) == target.getU(8) && cube.getB(0) == target.getR(0)))&&
						
				((cube.getU(6) == target.getU(0) && cube.getF(0) == target.getL(0)) ||
			     (cube.getU(6) == target.getU(2) && cube.getF(0) == target.getB(0)) ||
				 (cube.getU(6) == target.getU(6) && cube.getF(0) == target.getF(0)) ||
				 (cube.getU(6) == target.getU(8) && cube.getF(0) == target.getR(0)))&&
								
				((cube.getU(8) == target.getU(0) && cube.getR(0) == target.getL(0)) ||
				 (cube.getU(8) == target.getU(2) && cube.getR(0) == target.getB(0)) ||
				 (cube.getU(8) == target.getU(6) && cube.getR(0) == target.getF(0)) ||
				 (cube.getU(8) == target.getU(8) && cube.getR(0) == target.getR(0))))
				{
					return 0;
				}
			   else
			   if ( ((cube.getR(0) == target.getU(0) && cube.getU(8) == target.getL(0)) ||
					 (cube.getR(0) == target.getU(2) && cube.getU(8) == target.getB(0)) ||
					 (cube.getR(0) == target.getU(6) && cube.getU(8) == target.getF(0)) ||
					 (cube.getR(0) == target.getU(8) && cube.getU(8) == target.getR(0)))&&
									
				    ((cube.getL(2) == target.getU(0) && cube.getF(0) == target.getL(0)) ||
					 (cube.getL(2) == target.getU(2) && cube.getF(0) == target.getB(0)) ||
					 (cube.getL(2) == target.getU(6) && cube.getF(0) == target.getF(0)) ||
					 (cube.getL(2) == target.getU(8) && cube.getF(0) == target.getR(0))))
				    {
				   		return 1;
				    }
		   else if (cube.getU(6) == y && cube.getR(0) == y &&
				    cube.getB(0) == y && cube.getL(0) == y)
			   return 1;
		   else if (cube.getU(6) == y && cube.getF(2) == y &&
				    cube.getB(2) == y && cube.getR(2) == y)
			   return 1;
		   else if (cube.getU(0) == y && cube.getU(8) == y &&
				    cube.getL(2) == y && cube.getB(0) == y)
			   return 1;
		   else if (cube.getU(0) == y && cube.getU(2) == y &&
				    cube.getF(2) == y && cube.getF(0) == y)
			   return 1;
		   cube.U(0);
		   
		   
	   }
	   
	   
	   System.out.println("There's something rotten in Denmark");
	   return -1;   
   }
   
   public static void doAlgorithms(Rubiks cube, int state) throws IOException
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
