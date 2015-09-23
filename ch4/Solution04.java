package chapeter4;

import chapeter4.Solution03.TreeNode;

public class Solution04 {
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
	public static int getHeight(TreeNode root){
		if (root == null)
			return 0;
		return Math.max(getHeight(root.leftChild), getHeight(root.rightChild))+1;
	}
	public static boolean checkBalanced(TreeNode root){
		if (root == null)
			return true;
		if (Math.abs(getHeight(root.leftChild)-getHeight(root.rightChild))> 1)
			return false;
		else
			return checkBalanced(root.leftChild) && checkBalanced(root.rightChild);
	}
	//TODO
	 //Method 2
	 
}
