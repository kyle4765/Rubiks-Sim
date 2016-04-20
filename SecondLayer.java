import java.awt.*;

public class SecondLayer extends Solver
{
   final static Algorithm flip = new Algorithm("LULUFUF-U-LULUFUF", "1000011-0-1000011");
   
   final static Algorithm top    		= new Algorithm("ULULUFUF", "11000011");
   final static Algorithm leftBack		= new Algorithm("XXLULUFUFXULULUFUF", "11000011001000011");
   final static Algorithm rightBack    	= new Algorithm("XXLULUFUFXXULULUFUF","0010000110001000011");
   final static Algorithm rightFront    = new Algorithm("XLULUFUFXULULUFUF", "01000011101000011");

   
   public static void solve(Rubiks cube)
   {
	   solvePiece(cube, "red", "blue");
	   solvePiece(cube, "blue", "orange");
	   solvePiece(cube, "orange", "green");
	   solvePiece(cube, "green", "red");
   }
   
   public static int findPiece(Rubiks cube, String c1, String c2)
   {
	   Color piece1 = cube.stringToColor(c1);
	   Color piece2 = cube.stringToColor(c2);
	   
	   boolean ts1;
	   boolean ts2;
	   
	   ts1 = cube.getF()[3].equals(piece1) && cube.getL()[5].equals(piece2);
	   ts2 = cube.getF()[3].equals(piece2) && cube.getL()[5].equals(piece1);
	   if (ts1 || ts2)
		   return 0;
	   ts1 = cube.getL()[3].equals(piece1) && cube.getB()[5].equals(piece2);
	   ts2 = cube.getL()[3].equals(piece2) && cube.getB()[5].equals(piece1);
	   if (ts1 || ts2)
		   return 1;
	   ts1 = cube.getB()[3].equals(piece1) && cube.getR()[5].equals(piece2);
	   ts2 = cube.getB()[3].equals(piece2) && cube.getR()[5].equals(piece1);
	   if (ts1 || ts2)
		   return 2;
	   ts1 = cube.getR()[3].equals(piece1) && cube.getF()[5].equals(piece2);
	   ts2 = cube.getR()[3].equals(piece2) && cube.getF()[5].equals(piece1);
	   if (ts1 || ts2)
		   return 3;
	   
	   for (int k = 0; k < 4; k++)
	   {
		   ts1 = cube.getF()[1].equals(piece1) && cube.getU()[7].equals(piece2);
		   ts2 = cube.getF()[1].equals(piece2) && cube.getU()[7].equals(piece1);
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
	   if (!(cube.getF()[3].equals(cube.getF()[4])))
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