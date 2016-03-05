public class WhiteCorners extends Solver
{
   final Algorithm fromBottomRight  = new Algorithm("RDDRDRDR", "11100110");
   final Algorithm fromBottomLeft   = new Algorithm("LDDLDLDL", "00011001");
   final Algorithm fromRight        = new Algorithm("RDR", "110");
   final Algorithm fromLeft         = new Algorithm("LDL", "001");
   final Algorithm fromLeftTop      = new Algorithm("LDLDLDL", "0011001");
   final Algorithm fromRightTop     = new Algorithm("RDRDRDR", "1100110");
   
   public void Solve(Rubiks cube)
   {
      setFace(cube, "blue", "white");
      boolean isDone;
      do
      {
      isDone = checkComplete(cube);
      }
      while(!isDone);
   }
   
   public boolean checkComplete(Rubiks cube)
   {
   
      return true;
            
   }
}