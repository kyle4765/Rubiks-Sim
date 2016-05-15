import java.io.IOException;

public class WhiteCross extends Solver
{
   final static Algorithm topFlip 		= new Algorithm("FRDRFF", "011000");
   
   final static Algorithm topLeft 		= new Algorithm("LLDFF", "00000");
   final static Algorithm topRight  	= new Algorithm("RRDFF", "00100");
   final static Algorithm topBack 		= new Algorithm("BBDDFF", "000000");
   final static Algorithm frontLeft   	= new Algorithm("F", "0");
   final static Algorithm frontBottom 	= new Algorithm("FF", "00");
   
   protected int[] edgeLoc = {1,3,5,7};
   protected boolean[] edgeState = {false, false, false, false};
   
   
   public static void solve(Rubiks cube)
   {
	  try{
      solvePiece(cube, "blue");
      solvePiece(cube, "red");
      solvePiece(cube, "green");
      solvePiece(cube, "orange");
	  } catch (IOException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  }
      System.out.println("White cross done!");
      
   }
   
   public static int findPiece(Rubiks cube, String c) throws IOException
   {
	   char piece = cube.stringToChar(c);
	   
	   boolean ts1;
	   boolean ts2;
	   
	   ts1 = cube.getU(7) == 'w'   && cube.getF(1) == piece;
	   ts2 = cube.getU(7) == piece && cube.getF(1) == '1';
	   if (ts1 || ts2)
		   return 0;
	   ts1 = cube.getU(3) == 'w'   && cube.getL(1) == piece;
	   ts2 = cube.getU(3) == piece && cube.getL(1) == 'w';
	   if (ts1 || ts2)
		   return 1;
	   ts1 = cube.getU(1) == 'w'   && cube.getB(1) == piece;
	   ts2 = cube.getU(1) == piece && cube.getB(1) == 'w';
	   if (ts1 || ts2)
		   return 2;
	   ts1 = cube.getU(5) == 'w'   && cube.getR(1) == piece;
	   ts2 = cube.getU(5) == piece && cube.getR(1) == 'w';
	   if (ts1 || ts2)
		   return 3;
	   
	   for (int k = 0; k < 4; k++)
	   {
		   ts1 = cube.getF(3) == 'w'   && cube.getL(5) == piece;
		   ts2 = cube.getF(3) == piece && cube.getL(5) == 'w';
		   if (ts1 || ts2)
			   return 4;
		   ts1 = cube.getF(7) == 'w'   && cube.getD(1) == piece;
		   ts2 = cube.getF(7) == piece && cube.getD(1) == 'w';
		   if (ts1 || ts2)
			   return 5;
		   cube.X(0);
		   cube.D(1);
	   }
	   System.out.println("Could not find piece");
	   return -1;
   }
   
   public static void pieceToTop(Rubiks cube, int num) throws IOException
   {
	   switch (num)
	   {
	       case 0 : break;
	       case 1 : cube.algorithm(topLeft); break;
	       case 2 : cube.algorithm(topBack); break;
	       case 3 : cube.algorithm(topRight); break;
	       case 4 : cube.algorithm(frontLeft); break;
	       case 5 : cube.algorithm(frontBottom); break;
		   
	   }
	   if (!(cube.getU(7) == 'w'))
	   {
		   cube.algorithm(topFlip);
	   }
   }
   
   public static void solvePiece(Rubiks cube, String piece) throws IOException
   {
	   cube.setFace(piece, "white"); 
	   pieceToTop(cube, findPiece(cube, piece));
	   for (int k = 0; k < 4; k++)
	   {
		   cube.X(0);
		   if (cube.getF(1) == cube.getF(4))
			   break;
	   }
   }
   /*
    * set blue front
    * search for blue
    * do algorithm
    * set red front
    * search red
    * etc
    * 
    * 
    * difficulty: finding pieces when they are on the top
    */
   /*
    * Piece position info:
    * 0 : already in place
    * 1 : top face on the left side
    * 2 : top face on the right side
    * 3 : top face on the back
    * 4 : front face left side
    * 5 : front face bottom
    */
   
}
