package chapeter4;

import java.util.ArrayList;
import java.util.LinkedList;

import chapeter4.Solution03.BST;
import chapeter4.Solution03.TreeNode;

public class Solution06 {
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
		public TreeNode parent; // Assume that each node has a link to its parent.
		public TreeNode(int value){
			this.val = value;
		}
	}
	public static class BST{
		public TreeNode root;
		public BST(){
			root = null;
		}
		public void addTree(TreeNode node){
			root = add (root, node);
		}
		private TreeNode add(TreeNode root, TreeNode node){
			if (root == null)
				root = node;
			else if (root.getValue() > node.val)
				root.left = add(root.left, node);
			else 
				root.right = add(root.right, node);
			return root;
		}
		/*public void addTree(int value){
			root = add (root, value);
		}*/
		/*private TreeNode add(TreeNode root, int value){
			if (root == null)
				root = new TreeNode(value);
			else if (root.getValue() > value)
				root.left = add(root.left, value);
			else 
				root.right = add(root.right, value);
			return root;
		}*/
	}
	public static TreeNode Sucessor (TreeNode node){
		if (node == null)
			return null;
		if (node.right != null){ //If node has the right subtree
			return leftMost(node.right);//return leftMost(node.right);
		}
		else{
			TreeNode current = node;
			TreeNode father = current.parent;
			if (father != null && father.left != current){
				current = father;
				father = father.parent;
			}
			return father;
		}
	}
	public static TreeNode leftMost(TreeNode node){
		if (node == null)
			return null;
		while (node.left != null){
			node = node.left;
		}
		return node;
	}
	public static void inOrder (TreeNode root){
		if (root == null)
			return;
		if (root.left != null)
			inOrder(root.left);
		System.out.print(root.val+"  ");
		if (root.right != null)
			inOrder(root.right);
	}
	public static void main (String args[]){
		BST bst = new BST();
		TreeNode node1 = new TreeNode(5);
		bst.addTree(node1);
		TreeNode node2 = new TreeNode(7);
		bst.addTree(node2);
		TreeNode node3 = new TreeNode(6);
		bst.addTree(node3);
		TreeNode node4 = new TreeNode(10);
		bst.addTree(node4);
		TreeNode node5 = new TreeNode(0);
		bst.addTree(node5);
		TreeNode node6 = new TreeNode(1);
		bst.addTree(node6);
		TreeNode node7 = new TreeNode(2);
		bst.addTree(node7);
		TreeNode node8 = new TreeNode(3);
		bst.addTree(node8);
		TreeNode node9 = new TreeNode(4);
		bst.addTree(node9);
		TreeNode node10 = new TreeNode(8);
		bst.addTree(node10);
		
		inOrder(bst.root);
		System.out.println(Sucessor(node1).val);
		
	}
}
