package seven_two;

public class LowerTriangular {
	    public static void main(String[] args) {
	        int[][] matrix = {
	            {1, 2, 3, 4},
	            {5, 6, 7, 8},
	            {9, 10, 11, 12},
	            {13, 14, 15, 16}
	        };

	        int n = matrix.length;

	        System.out.println("Lower triangular part:");
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (j <= i) {
	                    System.out.print(matrix[i][j] + "\t");
	                } else {
	                    System.out.print("\t");
	                }
	            }
	            System.out.println();
	        }
	    }
	}



