package com.cc.chapter1;

public class Solution07 {
	/**
	 * To save the unnecessary O(N) memory, we can implement swap index by index.[1]
	temp = top;
	top = left;
	left = bottom;
	bottom = right;
	right = temp;
	Perform such a swap on each layer(edge), starting from the outermost edge and working the way inwards.
	[1] McDowell G L. Cracking the coding interview, 2015,p203*/
	public static void rotateMatrix (int[][] matrix, int n){
		for (int edge = 0; edge < n/2; edge++){
			int first = edge;
			int last = n - 1 - edge;
			for (int i = first; i < last; i++){
				int margin = i - first;
				int temp = matrix[first][i];//Store top
				matrix[first][i] = matrix[last-margin][first]; //Left->top
				matrix[last-margin][first] = matrix[last][last-margin];//Bottom->left
				matrix[last][last-margin] = matrix[i][last];//Right->bottom
				matrix[i][last] = temp;//Top->right
			}
		}
	}
}
