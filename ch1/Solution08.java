package com.cc.chapter1;

public class Solution08 {
	public void zeroMatrix (int[][] matrix){
		int rowLength = matrix.length;
		int columnLength = matrix[0].length;
		boolean[] row = new boolean[rowLength];
		boolean[] column = new boolean[columnLength];
		for (int i = 0; i < rowLength; i++){
			for (int j = 0; j < columnLength; j++){
				if (matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for (int i = 0; i < rowLength; i++){
			if (row[i]){
				for (int j = 0; j < columnLength; j++)
					matrix[i][j] = 0;
			}
		}
		for (int j = 0; j < columnLength; j++){
			if (column[j]){
				for (int i = 0; i < rowLength; i++)
					matrix[i][j] = 0;
			}
		}
	}
}
