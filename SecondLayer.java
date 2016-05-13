

public class SecondLayer extends Solver
{
   final static Algorithm flip = new Algorithm("LULUFUF-U-LULUFUF", "1000011-0-1000011");
   
   final static Algorithm top    		= new Algorithm("ULULUFUF", "11000011");
   final static Algorithm leftBack		= new Algorithm("X-LULUFUF-XU-LULUFUF","1-1000011-00-1000011");
   final static Algorithm rightBack    	= new Algorithm("XX-LULUFUF-XXU-LULUFUF","00-1000011-000-1000011");
   final static Algorithm rightFront    = new Algorithm("X-LULUFUF-XU-LULUFUF","0-1000011-10-1000011");

   
   public static void solve(Rubiks cube)
   {
	   solvePiece(cube, "red", "blue");
	   solvePiece(cube, "blue", "orange");
	   solvePiece(cube, "orange", "green");
	   solvePiece(cube, "green", "red");
	   System.out.println("Second layer done!");
   }
   
   public static int findPiece(Rubiks cube, String c1, String c2)
   {
	   char piece1 = cube.stringToChar(c1);
	   char piece2 = cube.stringToChar(c2);
	   
	   boolean ts1;
	   boolean ts2;
	   
	   ts1 = cube.getF(3) == piece1 && cube.getL(5) == piece2;
	   ts2 = cube.getF(3) == piece2 && cube.getL(5) == piece1;
	   if (ts1 || ts2)
		   return 0;
	   ts1 = cube.getL(3) == piece1 && cube.getB(5) == piece2;
	   ts2 = cube.getL(3) == piece2 && cube.getB(5) == piece1;
	   if (ts1 || ts2)
		   return 1;
	   ts1 = cube.getB(3) == piece1 && cube.getR(5) == piece2;
	   ts2 = cube.getB(3) == piece2 && cube.getR(5) == piece1;
	   if (ts1 || ts2)
		   return 2;
	   ts1 = cube.getR(3) == piece1 && cube.getF(5) == piece2;
	   ts2 = cube.getR(3) == piece2 && cube.getF(5) == piece1;
	   if (ts1 || ts2)
		   return 3;
	   
	   for (int k = 0; k < 4; k++)
	   {
		   ts1 = cube.getF(1) == piece1 && cube.getU(7) == piece2;
		   ts2 = cube.getF(1) == piece2 && cube.getU(7) == piece1;
		   if (ts1 || ts2)
			   return 4;
		   cube.U(0);
	   }
	   System.out.println("Could not find edge piece for second layer");
	   return -1;
   }
   
   public static void pieceToPlace(Rubiks cube, int num)
   {
	   switch (num)
	   {
	   		case 0 : break;
	   		case 1 : cube.algorithm(leftBack); break;
	   		case 2 : cube.algorithm(rightBack); break;
	   		case 3 : cube.algorithm(rightFront); break;
	   		case 4 : cube.algorithm(top); break;
	   }
	   if (!(cube.getF(3) == cube.getF(4)))
	   {
		   cube.algorithm(flip);
	   }
   }
   
   public static void solvePiece(Rubiks cube, String piece1, String piece2)
   {
	   cube.setFace(piece1, "yellow");
	   pieceToPlace(cube, findPiece(cube, piece1, piece2));
   }
}