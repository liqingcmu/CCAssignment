package chapeter4;

public class Solution08 {
	public static class TreeNode {
		public int val;
		public int getValue() {
			return val;
		}
		public void setValue(int value) {
			this.val = value;
		}
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value){
			this.val = value;
		}
	}
	public static TreeNode firstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
		if (root == null || root == n1 || root == n2)
			return root;
		TreeNode left = firstCommonAncestor(root.left, n1, n2);
		TreeNode right = firstCommonAncestor(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		else
			return left==null ? right : left;
	}
}
