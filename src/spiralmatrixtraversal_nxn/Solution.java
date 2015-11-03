package spiralmatrixtraversal_nxn;

public class Solution {
	public static void main(String[] args){
		int n = 3;
		int [][] matrix = generateMatrix(n);
		for(int[] x : matrix){
			for(int y:x){
				System.out.print(y + ",");
			}
			System.out.println();
		}
	}
	public static int[][] generateMatrix(int n) {
	    int[][] matrix = new int[n][n];
	    if (n == 0) return matrix;
	    int row = 0, col = -1, m = n, count = 0;
	    while (true) {
	        for (int i = 0; i < n; i++) matrix[row][++col] = ++count;
	        if (--m == 0) break;
	        for (int i = 0; i < m; i++) matrix[++row][col] = ++count;
	        if (--n == 0) break;
	        for (int i = 0; i < n; i++) matrix[row][--col] = ++count;
	        if (--m == 0) break;
	        for (int i = 0; i < m; i++) matrix[--row][col] = ++count;
	        if (--n == 0) break;
	    }
	    return matrix;
	}
}