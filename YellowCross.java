import java.io.IOException;

public class YellowCross extends Solver
{
   final static Algorithm curve   = new Algorithm("FURURF", "000111");
   final static Algorithm line    = new Algorithm("FRURUF", "000111");
   
   public static void solve(Rubiks cube)
   {
	   try{
	   cube.setFace("blue", "yellow");
	   doAlgorithms(cube, findState(cube));
	   } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }
   }
   
   public static int findState(Rubiks cube) throws IOException
   {
	   if (  (cube.getU(1) == 'y') && (cube.getU(3) == 'y') &&
			 (cube.getU(5) == 'y') && (cube.getU(7) == 'y') )
		   return 0;
	   if (!((cube.getU(1) == 'y') || (cube.getU(3) == 'y') ||
		     (cube.getU(5) == 'y') || (cube.getU(7) == 'y')) )
		   return 1;
	   for (int k = 0; k < 4; k++)
	   {
		   if (cube.getU(3) == 'y')
		   {
			   if(cube.getU(1) == 'y')
			   {
				   return 2;
			   }
			   else if (cube.getU(5) == 'y')
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
