import java.awt.*;
import java.applet.*;																
import java.util.*;

public class Rubiks
{
   protected Color[] back;
   protected Color[] front;
   protected Color[] right;
   protected Color[] left;
   protected Color[] top;
   protected Color[] bottom;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   protected int x;
   protected int y;
   protected int s;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
   public Rubiks()
   {
      back  = new Color[9];
      for (int k = 0; k < 9; k++)
         back[k] = Color.green;
         
      front   = new Color[9];
      for (int k = 0; k < 9; k++)
         front[k] = Color.blue;
         
      right    = new Color[9];
      for (int k = 0; k < 9; k++)
         right[k] = Color.red;
         
      left = new Color[9];
      for (int k = 0; k < 9; k++)
         left[k] = Color.orange;
         
      top = new Color[9];
      for (int k = 0; k < 9; k++)
         top[k] = Color.yellow;
         
      bottom  = new Color[9];   
      for (int k = 0; k < 9; k++)
         bottom[k] = Color.white;
         
      x = 10;
      y = 10;
      s = 10;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void setX(int x){this.x = x;}
   public void setY(int y){this.y = y;}
   public void setS(int s){this.s = s;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void addX(int x){this.x += x;}
   public void addY(int y){this.y += y;}
   public void addS(int s){this.s += s;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public int getX(){return x;}
   public int getY(){return y;}
   public int getS(){return s;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public Color[] getF(){return front;}
   public Color[] getB(){return back;}   
   public Color[] getR(){return right;}   
   public Color[] getL(){return left;}   
   public Color[] getU(){return top;}   
   public Color[] getD(){return bottom;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
   public void drawCubeNet(Graphics g)
   {
      int tempX = x;
      int tempY = y;
      
      x += 7*s/2;
      drawSide(top,g);
      
      x = tempX;
      y += 7*s/2;
      drawSide(left,g);
      x += 7*s/2;
      drawSide(front,g);
      x += 7*s/2;
      drawSide(right,g);
      x += 7*s/2;
      drawSide(back,g);
      
      x = tempX;
      y += 7*s/2;
      x += 7*s/2;
      drawSide(bottom,g);
      
      x = tempX;
      y = tempY;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   private void drawSide(Color[] side, Graphics g)
   {
      g.setColor(side[0]);
      g.fillRect(x,y,s,s);
      g.setColor(side[1]);
      g.fillRect(x + s,y,s,s);
      g.setColor(side[2]);
      g.fillRect(x + 2*s,y,s,s);
      
      g.setColor(side[3]);
      g.fillRect(x,y + s,s,s);
      g.setColor(side[4]);
      g.fillRect(x + s,y + s,s,s);
      g.setColor(side[5]);
      g.fillRect(x + 2*s,y + s,s,s);
      
      g.setColor(side[6]);
      g.fillRect(x,y + 2*s,s,s);
      g.setColor(side[7]);
      g.fillRect(x + s,y + 2*s,s,s);
      g.setColor(side[8]);
      g.fillRect(x + 2*s,y + 2*s,s,s);
      
      g.setColor(Color.black);
      g.drawRect(x,y,3*s,3*s);
      g.drawRect(x+s,y,s,3*s);
      g.drawRect(x,y+s,3*s,s);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   private void swapEdge(Color[] c1, Color[] c2, int c11, int c12, int c13, int c21, int c22, int c23)
   {
      c1[c11] = c2[c21];
      c1[c12] = c2[c22];
      c1[c13] = c2[c23];
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   private void rotateSide(Color[] side, boolean inverse)/////////////
   {
   
      Color temp = side[0];
      Color pmet = side[1];
      if (!inverse)
      {
         side[0] = side[6];
         side[6] = side[8];
         side[8] = side[2];
         side[2] = temp;
         
         side[1] = side[3];
         side[3] = side[7];
         side[7] = side[5];
         side[5] = pmet;
      }
      else
      {
         side[0] = side[2];
         side[2] = side[8];
         side[8] = side[6];
         side[6] = temp;
         
         side[1] = side[5];
         side[5] = side[7];
         side[7] = side[3];
         side[3] = pmet;
      }

   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void F(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);     
      int k;
      int j;      
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)   
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];           
         swapEdge(top,  left,  6,7,8,   8,5,2);
         swapEdge(left,  bottom,   8,5,2,   2,1,0);
         swapEdge(bottom,   right,     2,1,0,   0,3,6);
         swapEdge(right,     temp,    0,3,6,   6,7,8);
      } 
      rotateSide(front,inverse);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void B(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);      
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];            
         swapEdge(top,  right,     2,1,0,   8,5,2);
         swapEdge(right,     bottom,   8,5,2,   6,7,8);
         swapEdge(bottom,   left,  6,7,8,   0,3,6);
         swapEdge(left,  temp,    0,3,6,   2,1,0);
      }   
      rotateSide(back,inverse);
      
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void R(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);      
      int k;
      int j;      
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];         
         swapEdge(top,  front,    8,5,2,   8,5,2);
         swapEdge(front,    bottom,   8,5,2,   8,5,2);
         swapEdge(bottom,   back,   8,5,2,   0,3,6);
         swapEdge(back,   temp,    0,3,6,   8,5,2);
      }
      rotateSide(right,inverse);      
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void L(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);      
      int k;
      int j;      
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];
         swapEdge(top,  back,   0,3,6,   8,5,2);
         swapEdge(back,   bottom,   8,5,2,   0,3,6);
         swapEdge(bottom,   front,    0,3,6,   0,3,6);
         swapEdge(front,    temp,    0,3,6,   0,3,6);
      }
      rotateSide(left,inverse);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void U(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];         
         swapEdge(front,    right,     2,1,0,   2,1,0);
         swapEdge(right,     back,   2,1,0,   2,1,0);
         swapEdge(back,   left,  2,1,0,   2,1,0);
         swapEdge(left,  temp,    2,1,0,   2,1,0);
      }
      rotateSide(top,inverse);    
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
   public void D(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];
         swapEdge(front,    left,  6,7,8,   6,7,8);
         swapEdge(left,  back,   6,7,8,   6,7,8);
         swapEdge(back,   right,     6,7,8,   6,7,8);
         swapEdge(right,     temp,    6,7,8,   6,7,8);
      }
      rotateSide(bottom,inverse);
      
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void X(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];
         swapEdge(front,    right,     3,4,5, 3,4,5);
         swapEdge(right,     back,   3,4,5, 3,4,5);
         swapEdge(back,   left,  3,4,5, 3,4,5);
         swapEdge(left,  temp,    3,4,5, 3,4,5);
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void Y(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];
         swapEdge(front,    bottom,   1,4,7, 1,4,7);
         swapEdge(bottom,   back,   1,4,7, 7,4,1);
         swapEdge(back,   top,  7,4,1, 1,4,7);
         swapEdge(top,  temp,    1,4,7, 1,4,7);
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void Z(int inv)
   {
      Color[] temp = new Color[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];
         swapEdge(top,  left,  3,4,5, 7,4,1);
         swapEdge(left,  bottom,   1,4,7, 3,4,5);
         swapEdge(bottom,   right,     3,4,5, 7,4,1);
         swapEdge(right,     temp,    1,4,7, 3,4,5);
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void rotateCubeX(int inv)
   {
      this.X(inv);
      this.U(inv);
      this.D(-inv + 1);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void rotateCubeY(int inv)
   {
      this.Y(inv);
      this.R(inv);
      this.L(-inv + 1);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void rotateCubeZ(int inv)
   {
      this.Z(inv);
      this.F(inv);
      this.B(-inv + 1);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public boolean isSolved()
   {
      boolean output  = true;
      boolean tempTB  = true;
      boolean tempLR  = true;
      boolean tempFB  = true;
      for(int k = 0; k < 8; k++)
      {
    	 tempTB = (bottom[k].equals(bottom[k+1])) && (top[k].equals(top[k+1]));
    	 tempLR = (left[k].equals(left[k+1])) && (right[k].equals(right[k+1]));
    	 tempTB = (front[k].equals(front[k+1])) && (back[k].equals(back[k+1]));
         if (!(tempTB && tempLR && tempFB))
         {
        	 output = false;
        	 break;
         }
      }
      return output;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void algorithm(Algorithm alg)
   {
      multiAction(alg.getActions(), alg.getInverses());
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   public void multiAction(String actions, String inverses)
   {
      if (!(actions.length() == inverses.length()))
      {
         System.out.println("Error in inputs to multiAction method. Lengths of parameters must be equal.");
      }
      else
      {
    	 int temp = 0;
         for (int k = 0; k < actions.length(); k++)
         {
        	if (inverses.substring(k,k+1).equals("-"))
        		temp = 0;
        	else
        		temp = Integer.parseInt(inverses.substring(k,k+1));
            singleAction(actions.substring(k,k+1), temp);
         }
      }
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   public void singleAction(String action, int inv)
   {
      switch (action.toUpperCase().substring(0,1))
      {
         case "F" : this.F(inv); break;
         case "B" : this.B(inv); break;
         case "U" : this.U(inv); break;
         case "D" : this.D(inv); break;
         case "R" : this.R(inv); break;
         case "L" : this.L(inv); break;
         case "X" : this.X(inv); break;
         case "Y" : this.Y(inv); break;
         case "Z" : this.Z(inv); break;
         case "-" : break;
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void setFace(String f, String t)
   {
      Color front = stringToColor(f);
      Color top   = stringToColor(t);
      
      boolean bg = ((f.equals("blue") && t.equals("green"))   || (t.equals("blue") && f.equals("green")));
      boolean wy = ((f.equals("white") && t.equals("yellow")) || (t.equals("white") && f.equals("yellow")));
      boolean ro = ((f.equals("red") && t.equals("orange"))   || (t.equals("red") && f.equals("orange")));
      if (bg || wy || ro)
      {
         System.out.println("Opposite sides can not be front and top at the same time");
      }
      else
      {
         while (!(front.equals(getF()[4])))
         {
            rotateCubeY(0);
            if (front.equals(getF()[4]))
               break;
            rotateCubeX(0);
         }
         while(!(top.equals(getU()[4])))
            rotateCubeZ(0);
      } 
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public Color stringToColor(String s)
   {
      Color c = new Color(0,0,0);
      switch (s.toLowerCase())
      {
         case "blue"    : c = Color.blue;     break;
         case "green"   : c = Color.green;    break;
         case "red"     : c = Color.red;      break;
         case "orange"  : c = Color.orange;   break;
         case "white"   : c = Color.white;    break;
         case "yellow"  : c = Color.yellow;   break;
      }
      return c;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
