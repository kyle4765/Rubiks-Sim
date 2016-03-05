public class SecondLayer extends Solver
{
   final Algorithm left    = new Algorithm("ULULUFUF", "11000011");
   final Algorithm right   = new Algorithm("URURUFUF", "00111100");
   
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