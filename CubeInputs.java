import java.io.IOException;
public class CubeInputs 
{
	public static Rubiks getCube(char[] f, char[] b, char [] r, char [] l, char[] u, char[] d) throws IOException
	{
		Rubiks cube = new Rubiks();
		cube.setF(f);
		cube.setB(b);
		cube.setR(r);
		cube.setL(l);
		cube.setU(u);
		cube.setD(d);
		return cube;
	}
}
