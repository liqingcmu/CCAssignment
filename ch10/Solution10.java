package chapter10;

public class Solution10 {
//Implement by binary search tree
	public static TreeNode root = null;
	public static void track(int x) {  
        if (root == null) {  
            root = new TreeNode(x);  
        } else {  
            root.insert(x);  
        }  
    }  
	public static int getRankOfNumber (int x){
		return root.getRank(x);
	}  
	public static class TreeNode{
		public TreeNode left;
		public TreeNode right;
		public int left_size;
		public int value;
		public TreeNode(int value){
			this.value = value;
		}
		public void insert (int x){
			if (x <= this.value){
				if (left == null)
					left = new TreeNode(x);
				else 
					left.insert(x);
				left_size ++;
			}
			else{
				if (right == null)
					right = new TreeNode(x);
				else
					right.insert(x);
			}
		}
		public int getRank (int x){
			if (x == this.value)
				return left_size;
			else if (x < this.value){
				if (left == null)
					return -1;
				else
					return left.getRank(x);
			}
			else{
				if (right == null)
					return -1;
				else
					return left_size + right.getRank(x);
			}
		}
	}
}
