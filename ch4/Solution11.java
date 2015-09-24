package chapeter4;

import java.util.Random;

public class Solution11 {
	public static class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		//Since we are building the tree class from scratch, we can keep track of the size.
		public int size = 0;
		public TreeNode(int value){
			this.value = value;
			this.size = 1;
		}
		public void insert(int data){
			if (data <= this.value){
				if (left == null)
					left = new TreeNode(data);
				else
					left.insert(data);
			}
			else{
				if (right == null)
					right = new TreeNode(data);
				else
					right.insert(data);
			}
			size++;
		}
		public TreeNode find(int data){
			if (this.value == data)
				return this;
			else if (this.value < data){
				if (right == null)
					return null;
				return right.find(data);
			}
			else{
				if (left == null)
					return null;
				return left.find(data); 
			}
		}
		// Core method
		public TreeNode randomNode(){
			int leftSize = left == null? 0 : left.size;
			int index = new Random().nextInt(size);
			if (index < leftSize)
				return left.randomNode();
			else if (index == leftSize)
				return this;
			else
				return right.randomNode();
		}
		//TODO
		//delete method
	}
	
	
}
