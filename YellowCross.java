public class YellowCross extends Solver
{
   final Algorithm curve   = new Algorithm("FURURF", "000111");
   final Algorithm line    = new Algorithm("FRURUF", "000111");
   
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