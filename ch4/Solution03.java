package chapeter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution03 {
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
	public static class BST{
		public TreeNode root;
		public BST(){
			root = null;
		}
		public void addTree(int value){
			root = add (root, value);
		}
		private TreeNode add(TreeNode root, int value){
			if (root == null)
				root = new TreeNode(value);
			else if (root.getValue() > value)
				root.leftChild = add(root.leftChild, value);
			else 
				root.rightChild = add(root.rightChild, value);
			return root;
		}
	}
	// Implement DFS and pre-order traversal
	public static ArrayList<LinkedList<TreeNode>> listOfDepth(TreeNode root){
		if (root == null)
			return null;
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLists(0,lists,root);
		return lists;
	}
	public static void createLists(int level, ArrayList<LinkedList<TreeNode>> lists, TreeNode root){
		if (root == null)
			return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}
		else{
			list = lists.get(level);
		}
		list.add(root);
		createLists(level+1, lists, root.leftChild);
		createLists(level+1, lists, root.rightChild);
	}
	//TODO 
	//Method 2
	public static void main (String args[]){
		BST bst = new BST();
		bst.addTree(5);
		bst.addTree(2);
		bst.addTree(8);
		bst.addTree(0);
		bst.addTree(1);
		
		bst.addTree(3);
		bst.addTree(4);
		
		bst.addTree(6);
		bst.addTree(7);
		
		bst.addTree(9);
		bst.addTree(10);
		bst.addTree(11);
		ArrayList<LinkedList<TreeNode>> lists = listOfDepth(bst.root);
		for (LinkedList<TreeNode> a : lists){
			for (TreeNode b : a){
				System.out.print(b.value+" ");
			}
			System.out.println("=========");
		}
	}
}
