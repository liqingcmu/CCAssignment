package chapeter4;

import java.util.ArrayList;

public class Solution12 {
	public static class TreeNode {
		public int value;
		public int getValue() {
			return value;
		}
		//public ArrayList<Integer> sum = new ArrayList<Integer>();
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value){
			this.value = value;
		}
	}
	public static int pathsWithSum (TreeNode root, int givenSum){
		if (root == null)
			return 0;
		int pathRoot = pathNode(root, givenSum, 0);
		int pathLeft = pathsWithSum(root.left, givenSum);
		int pathRight = pathsWithSum(root.right, givenSum);
		return pathRoot + pathLeft + pathRight;
	}
	public static int pathNode (TreeNode node, int givenSum, int currentSum){
		if (node == null)
			return 0;
		int count = 0;
		currentSum = currentSum + node.value;
		if (currentSum == givenSum){
			count ++;
		}
		count = count + pathNode(node.left, givenSum, currentSum);
		count = count + pathNode(node.right, givenSum, currentSum);
		return count;
	}
}
