package chapeter4;


public class Solution02 {
	public static class TreeNode {
		public int value;
		public TreeNode leftChild;
		public TreeNode rightChild;
		public TreeNode(int value){
			this.value = value;
		}
	}
	public static TreeNode createMinimalTree(int[] arr){
		return createRecursive(arr, 0, arr.length-1);
	}
	public static TreeNode createRecursive(int[] arr, int start, int end){
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.leftChild = createRecursive(arr, start, mid-1);
		node.rightChild = createRecursive(arr, mid+1, end);
		return node;
	}
	public static void preOrderTraversal (TreeNode root){
		if (root == null)
			return;
		System.out.println(root.value);
		preOrderTraversal(root.leftChild);
		preOrderTraversal(root.rightChild);
	}
	public static void main (String args[]){
		int[] array = {0,1,2,3,4,5,6,7,8,9,10};
		TreeNode root = createMinimalTree(array);
		preOrderTraversal(root);
	}
}
