package chapeter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution09 {
	public static class TreeNode {
		public int value;
		public TreeNode leftChild;
		public TreeNode rightChild;
		public TreeNode(int value){
			this.value = value;
		}
	}
	public static ArrayList<LinkedList<Integer>> sequence (TreeNode node){
		ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
		if (node == null){
			results.add( new LinkedList<Integer>());
			return results;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.value);
		
		ArrayList<LinkedList<Integer>> leftSequence = sequence(node.leftChild);
		ArrayList<LinkedList<Integer>> rightSequence = sequence(node.rightChild);
		for (LinkedList<Integer> left : leftSequence){
			for (LinkedList<Integer> right : rightSequence){
				ArrayList<LinkedList<Integer>> weaveList = new ArrayList<LinkedList<Integer>>();
				weave(left, right, weaveList, prefix);
				results.addAll(weaveList);
			}
		}
		return results;
	}
	public static void weave (LinkedList<Integer> first,  LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
		if (first.size() == 0 || second.size() == 0){
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		//Recursion. 
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weave(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weave(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
}
