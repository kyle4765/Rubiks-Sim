public class FinalLayer extends Solver
{
   final Algorithm flipCorners   = new Algorithm("RFRBBRFRBBRR", "101000110000");
   final Algorithm moveEdgeLeft  = new Algorithm("FFULRFFLRUFF", "000010010000");
   final Algorithm moveEdgeRight = new Algorithm("FFULRFFLRUFF", "001010010100");
   
   public void Solve(Rubiks cube)
   {
      setFace(cube, "blue", "yellow");
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