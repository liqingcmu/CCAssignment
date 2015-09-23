package chapeter4;

public class Solution10 {
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
	//Assume we compare the value of the treenodes, not the reference.
	public static boolean checkSubtree(TreeNode t1, TreeNode t2){
		if (t2 == null)
			return true;
		if (t1 == null)
			return false;
		if (t1.val == t2.val)
			if (checkSubtree(t1.left,t2.left) && checkSubtree(t1.right,t2.right))
				return true;
		return checkSubtree(t1.left,t2)||checkSubtree(t1.right,t2);
	}
	
	public static void main(String[] args)
    {
		TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(5);
 
        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        if (checkSubtree(t1, t2))
            System.out.println("T2 is sub-tree of T1");
        else
            System.out.println("T2 is NOT sub-tree of T1");
    }
}
