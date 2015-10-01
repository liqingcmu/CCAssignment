package chapter10;

public class Solution09 {
	public static boolean sortedMatrixSearch(int[][] matrix, int value){
		int row = 0;
		int column = matrix[0].length - 1;
		while (row < matrix.length && column >= 0){
			if (matrix[row][column] == value)
				return true;
			else if (matrix[row][column] < value)
				row++;
			else
				column--;
		}
		return false;
	}
//TODO Binary Search
}
