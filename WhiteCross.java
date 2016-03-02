public class WhiteCross
{
   final Algorithm test = new Algorithm("LR","01");
   
   protected int[] edgeLoc = {1,3,5,7};
   protected boolean[] edgeState = {false, false, false, false};
   
   public void checkState(Rubiks cube)
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
   }
}