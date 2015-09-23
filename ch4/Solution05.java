package chapeter4;

import java.util.ArrayList;

// Assume that the tree doesn't have duplicate elements.
public class Solution05 {
	public static class TreeNode {
		public int value;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public TreeNode leftChild;
		public TreeNode rightChild;
		public TreeNode(int value){
			this.value = value;
		}
		
	}
	//In-order traversal 
	//Copy the tree nodes to an array in the way of in-order traversal. Then check if the array is sorted.
	/*public static boolean validateBST (TreeNode root){
		int[] arr = new int[Integer.MAX_VALUE]; 
		copy(root, arr);
		for (int j = 0; j < arr.length-1; j++){
			if (arr[j] >= arr[j+1])
				return false;
		}
		return true;
		
	}
	public static int i = 0;
	public static void copy (TreeNode root, int[] arr){
		if (root == null)
			return;
		copy (root.leftChild, arr);
		arr[i] = root.value;
		i++;
		copy (root.rightChild, arr);
	}*/
	public static boolean isValidBST (TreeNode root){
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = copy(root, arr);
		for (int j = 0; j < arr.size() - 1; j++){
			if (arr.get(j) >= arr.get(j+1))
				return false;
		}
		return true;
		
	}
	public static ArrayList<Integer> copy (TreeNode root, ArrayList<Integer> arr){
		if (root == null)
			return arr;
		arr = copy (root.leftChild, arr);
		arr.add(root.value);
		return  copy (root.rightChild, arr);
	
	}
	//TODO
	//Min-Max Solution
}
