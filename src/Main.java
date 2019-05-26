public class Main
{
	public static void main(String[] args)
	{
		Main m = new Main();
		
		float [][] matrix =
		{
			{0, 5, 0},
			{0, 0, 2},
			{6, 0, 3},
		};
		
		System.out.println("Original Matrix:\n");

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		float determinant = m.determinant(matrix);
		
		if (determinant != 0)
		{
			float [][] newMatrix = new float [3][3];
			
			newMatrix[0][0] = ((matrix[1][1]*matrix[2][2]) - (matrix[1][2]*matrix[2][1]));
			newMatrix[0][1] = -((matrix[0][1]*matrix[2][2]) - (matrix[0][2]*matrix[2][1]));
			newMatrix[0][2] = ((matrix[0][1]*matrix[1][2]) - (matrix[0][2]*matrix[1][1]));
			
			newMatrix[1][0] = -((matrix[1][0]*matrix[2][2]) - (matrix[1][2]*matrix[2][0]));
			newMatrix[1][1] = ((matrix[0][0]*matrix[2][2]) - (matrix[0][2]*matrix[2][0]));
			newMatrix[1][2] = -((matrix[0][0]*matrix[1][2]) - (matrix[0][2]*matrix[1][0]));
			
			newMatrix[2][0] = ((matrix[1][0]*matrix[2][1]) - (matrix[1][1]*matrix[2][0]));
			newMatrix[2][1] = -((matrix[0][0]*matrix[2][1]) - (matrix[0][1]*matrix[2][0]));
			newMatrix[2][2] = ((matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]));
			
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					newMatrix[i][j] *= 1/determinant;
					
					if (newMatrix[i][j] == 0) newMatrix[i][j] = 0; //to fix -0.0 showing in output
				}
			}
			
			System.out.println("\nInverse:\n");
			
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					System.out.print(newMatrix[i][j] + " ");
				}
				System.out.print("\n");
			}
		}
		else
		{
			System.out.println("No inverse exists!");
		}
	}
	
	float determinant(float [][] matrix)
	{
		float determinant = 0;
		
		determinant += matrix[0][0]*((matrix[1][1]*matrix[2][2]) - (matrix[1][2]*matrix[2][1]));
	
		determinant -= matrix[0][1]*((matrix[1][0]*matrix[2][2]) - (matrix[1][2]*matrix[2][0]));
		
		determinant += matrix[0][2]*((matrix[1][0]*matrix[2][1]) - (matrix[1][1]*matrix[2][0]));
		
		System.out.println("\nDeterminant: " + determinant);
		
		return determinant;
	}
}