import java.io.IOException;

public class YellowCross extends Solver
{
   final static Algorithm curve   = new Algorithm("FURURF", "000111");
   final static Algorithm line    = new Algorithm("FRURUF", "000111");
   
   public static void solce(Rubiks cube)
   {
	   try{
		   Rubiks target = new Rubiks();
		   solve(cube,target);
		   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   }
   }
   
   public static void solve(Rubiks cube, Rubiks target)
   {
	   try{
	   cube.setFace("blue", "yellow");
	   target.setFace("blue",  "yellow");
	   doAlgorithms(cube, findState(cube, target));
	   } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }
   }
   
   public static int findState(Rubiks cube, Rubiks target) throws IOException
   {
	   if (((cube.getU(1) == target.getU(1) && cube.getB(1) == target.getB(1)) ||
			(cube.getU(1) == target.getU(2) && cube.getB(1) == target.getL(1)) ||
			(cube.getU(1) == target.getU(5) && cube.getB(1) == target.getR(1)) ||
			(cube.getU(1) == target.getU(7) && cube.getB(1) == target.getF(1)))&&
			
		   ((cube.getU(3) == target.getU(1) && cube.getL(1) == target.getB(1)) ||
		    (cube.getU(3) == target.getU(2) && cube.getL(1) == target.getL(1)) ||
		    (cube.getU(3) == target.getU(5) && cube.getL(1) == target.getR(1)) ||
			(cube.getU(3) == target.getU(7) && cube.getL(1) == target.getF(1)))&&
			
		   ((cube.getU(5) == target.getU(1) && cube.getR(1) == target.getB(1)) ||
		    (cube.getU(5) == target.getU(2) && cube.getR(1) == target.getL(1)) ||
			(cube.getU(5) == target.getU(5) && cube.getR(1) == target.getR(1)) ||
			(cube.getU(5) == target.getU(7) && cube.getR(1) == target.getF(1)))&&
					
		   ((cube.getU(7) == target.getU(1) && cube.getF(1) == target.getB(1)) ||
		    (cube.getU(7) == target.getU(2) && cube.getF(1) == target.getL(1)) ||
			(cube.getU(7) == target.getU(5) && cube.getF(1) == target.getR(1)) ||
			(cube.getU(7) == target.getU(7) && cube.getF(1) == target.getF(1))) )
		   return 0;
	   
	   if(!((cube.getU(1) == target.getU(1) && cube.getB(1) == target.getB(1)) ||
			(cube.getU(1) == target.getU(2) && cube.getB(1) == target.getL(1)) ||
			(cube.getU(1) == target.getU(5) && cube.getB(1) == target.getR(1)) ||
			(cube.getU(1) == target.getU(7) && cube.getB(1) == target.getF(1)))||
				
		   ((cube.getU(3) == target.getU(1) && cube.getL(1) == target.getB(1)) ||
			(cube.getU(3) == target.getU(2) && cube.getL(1) == target.getL(1)) ||
			(cube.getU(3) == target.getU(5) && cube.getL(1) == target.getR(1)) ||
		    (cube.getU(3) == target.getU(7) && cube.getL(1) == target.getF(1)))||
				
		   ((cube.getU(5) == target.getU(1) && cube.getR(1) == target.getB(1)) ||
			(cube.getU(5) == target.getU(2) && cube.getR(1) == target.getL(1)) ||
	    	(cube.getU(5) == target.getU(5) && cube.getR(1) == target.getR(1)) ||
		    (cube.getU(5) == target.getU(7) && cube.getR(1) == target.getF(1)))||
						
		   ((cube.getU(7) == target.getU(1) && cube.getF(1) == target.getB(1)) ||
			(cube.getU(7) == target.getU(2) && cube.getF(1) == target.getL(1)) ||
		    (cube.getU(7) == target.getU(5) && cube.getF(1) == target.getR(1)) ||
			(cube.getU(7) == target.getU(7) && cube.getF(1) == target.getF(1))) )
			   return 1;
	   for (int k = 0; k < 4; k++)
	   {
		   if (((cube.getU(3) == target.getU(1) && cube.getL(1) == target.getB(1)) ||
			    (cube.getU(3) == target.getU(2) && cube.getL(1) == target.getL(1)) ||
				(cube.getU(3) == target.getU(5) && cube.getL(1) == target.getR(1)) ||
				(cube.getU(3) == target.getU(7) && cube.getL(1) == target.getF(1))) )
		   {
			   if (((cube.getU(1) == target.getU(1) && cube.getB(1) == target.getB(1)) ||
					(cube.getU(1) == target.getU(2) && cube.getB(1) == target.getL(1)) ||
					(cube.getU(1) == target.getU(5) && cube.getB(1) == target.getR(1)) ||
					(cube.getU(1) == target.getU(7) && cube.getB(1) == target.getF(1))) )
			   {
				   return 2;
			   }
			   else if(((cube.getU(5) == target.getU(1) && cube.getR(1) == target.getB(1)) ||
						(cube.getU(5) == target.getU(2) && cube.getR(1) == target.getL(1)) ||
						(cube.getU(5) == target.getU(5) && cube.getR(1) == target.getR(1)) ||
						(cube.getU(5) == target.getU(7) && cube.getR(1) == target.getF(1))) )
			   {
				   return 3;
			   }
		   }
		   cube.U(0);
	   }
	   System.out.println("Something in the yellow cross is whack");
	   return -1;     
   }
   
   public static void doAlgorithms(Rubiks cube, int state) throws IOException
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
