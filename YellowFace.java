public class YellowFace extends Solver
{
   final Algorithm corners = new Algorithm("RURURUUR", "00100001");
   
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