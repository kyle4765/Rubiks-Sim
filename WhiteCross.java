public class WhiteCross extends Solver
{
   final Algorithm fromBottom    = new Algorithm("FF","00");
   final Algorithm fromLeft      = new Algorithm("F", "0");
   final Algorithm fromRight     = new Algorithm("F", "1");
   final Algorithm fromLeftFix   = new Algorithm("URU", "100");
   final Algorithm fromRightFix  = new Algorithm("ULU", "011");
   final Algorithm fromBottomFix = new Algorithm("UFRFU", "11000");
   final Algorithm fromTopFix    = new Algorithm("ULUF","0010");
   
   
   protected int[] edgeLoc = {1,3,5,7};
   protected boolean[] edgeState = {false, false, false, false};
   
   
   public void Solve(Rubiks cube)
   {
      setFace(cube, "blue", "white");
      boolean isDone;
      do
      {
      
      isDone = checkComplete(cube);
      }
      while(!isDone);
      // mas
   }
   
   public void firstStep(Rubiks cube)
   {
      
   }
   
   public boolean checkComplete(Rubiks cube)
   {
      boolean temp = false;
      for (int k = 0; k < 4; k++)
      {
         switch (k)
         {
            case 0 : temp = cube.getB()[1].equals(cube.getB()[4]); break;
            case 1 : temp = cube.getL()[1].equals(cube.getL()[4]); break;
            case 2 : temp = cube.getR()[1].equals(cube.getR()[4]); break;
            case 3 : temp = cube.getF()[1].equals(cube.getF()[4]); break;
         }
      temp = temp && cube.getU()[edgeLoc[k]].equals(cube.getU()[4]);
      edgeState[k] = temp;
      }
      for (boolean edge : edgeState)
      {
         if (!edge)
            return false;
      }
      return true;
            
   }
}
