import java.awt.*;

public class WhiteCorners extends Solver
{
   final static Algorithm stateCycle = new Algorithm("LDLDLDL","0011001");
   
   final static Algorithm toTopLeft  	= new Algorithm("LDL", "001");
   final static Algorithm topLeftBack 	= new Algorithm("LDLDLDL", "1000001");
   final static Algorithm topRightBack 	= new Algorithm("RDDRLDL", "0001001");
   final static Algorithm topRightFront = new Algorithm("RDRLDL", "110001");
   
   public static void solve(Rubiks cube)
   {
      solvePiece(cube, "blue", "red");
      solvePiece(cube, "red", "green");
      solvePiece(cube, "green", "orange");
      solvePiece(cube, "orange", "blue");
   }
   
   public static int findPiece(Rubiks cube, String c1, String c2)
   {
	   Color piece1 = cube.stringToColor(c1);
	   Color piece2 = cube.stringToColor(c2);
	   
	   boolean ts1;
	   boolean ts2;
	   boolean ts3;
	   
	   ts1 = cube.getU()[6].equals(Color.white) && cube.getF()[0].equals(piece1) && cube.getL()[2].equals(piece2);
	   ts2 = cube.getU()[6].equals(piece1) && cube.getF()[0].equals(piece2) && cube.getL()[2].equals(Color.white);
	   ts3 = cube.getU()[6].equals(piece2) && cube.getF()[0].equals(Color.white) && cube.getL()[2].equals(piece1);
	   if (ts1 || ts2 || ts3)
		   return 0;
	   ts1 = cube.getU()[0].equals(Color.white) && cube.getL()[0].equals(piece1) && cube.getB()[2].equals(piece2);
	   ts2 = cube.getU()[0].equals(piece1) && cube.getL()[0].equals(piece2) && cube.getB()[2].equals(Color.white);
	   ts3 = cube.getU()[0].equals(piece2) && cube.getL()[0].equals(Color.white) && cube.getB()[2].equals(piece1);
	   if (ts1 || ts2 || ts3)
		   return 1;
	   ts1 = cube.getU()[2].equals(Color.white) && cube.getB()[0].equals(piece1) && cube.getR()[2].equals(piece2);
	   ts2 = cube.getU()[2].equals(piece1) && cube.getB()[0].equals(piece2) && cube.getR()[2].equals(Color.white);
	   ts3 = cube.getU()[2].equals(piece2) && cube.getB()[0].equals(Color.white) && cube.getR()[2].equals(piece1);
	   if (ts1 || ts2 || ts3)
		   return 2;
	   ts1 = cube.getU()[8].equals(Color.white) && cube.getR()[0].equals(piece1) && cube.getF()[2].equals(piece2);
	   ts2 = cube.getU()[8].equals(piece1) && cube.getR()[0].equals(piece2) && cube.getF()[2].equals(Color.white);
	   ts3 = cube.getU()[8].equals(piece2) && cube.getR()[0].equals(Color.white) && cube.getF()[2].equals(piece1);
	   if (ts1 || ts2 || ts3)
		   return 3;
	   
	   for (int k = 0; k < 4; k++)
	   {
		   ts1 = cube.getF()[6].equals(Color.white) && cube.getD()[0].equals(piece1) && cube.getL()[8].equals(piece2);
		   ts2 = cube.getF()[6].equals(piece1) && cube.getD()[0].equals(piece2) && cube.getL()[8].equals(Color.white);
		   ts3 = cube.getF()[6].equals(piece2) && cube.getD()[0].equals(Color.white) && cube.getL()[8].equals(piece1);
		   if (ts1 || ts2 || ts3)
			   return 4;
		   cube.D(0);
	   }
	   System.out.println("Could not find corner piece");
	   return -1;
	   
   }
   
   public static void pieceToTop(Rubiks cube, int num)
   {
	   switch (num)
	   {
	       case 0 : break;
	       case 1 : cube.algorithm(topLeftBack); break;
	       case 2 : cube.algorithm(topRightBack); break;
	       case 3 : cube.algorithm(topRightFront); break;
	       case 4 : cube.algorithm(toTopLeft); break;
		   
	   }
	   while (!(cube.getU()[6].equals(Color.white)))
	   {
		   cube.algorithm(stateCycle);
	   }
   }
   
   public static void solvePiece(Rubiks cube, String piece1, String piece2)
   {
	   cube.setFace(piece1, "white");
	   pieceToTop(cube, findPiece(cube, piece1, piece2));
   }
   /*
    * set face blue
    * find blue red corner position
    * put between blue red and white
    * cycle through states until solved
    * set face red
    * repeat with red and green
    * etc
    */
   
   /*
    * 
    */
}