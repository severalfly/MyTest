
public class MathCircle
{
	public static void main(String[] args)
	{
		double radis = 100.0f;
		int maxcol = 10;
		int[][] places = new int[maxcol][maxcol];
		for(int i = 0; i< maxcol; ++i)
		{
			int j = (int)Math.floor(Math.sqrt(radis * radis - i*i)-1);
			places[i][j] = 1;
		}
		for(int i = 0; i< maxcol; ++i )
		{
			for(int j = 0; j < maxcol ; ++j)
			{
				if (places[i][j] == 1)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}	
}