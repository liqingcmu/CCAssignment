package cc.chaper3;

import java.util.Stack;
//Assume we can only use one additional stack.
//The method takes O(n) space and O(n^2) time.
public class Solution05 {
	public Stack<Integer> sortStack(Stack<Integer> oldStack){
		Stack<Integer> newStack = new Stack<Integer>();
		while (!oldStack.isEmpty()){
			int temp = oldStack.pop();
			while (temp < newStack.peek() && !newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
			newStack.push(temp);
		}
		return newStack;
	}
	//TODO
	//What if we are allowed to use two additional stacks?
	//What if use quickSort/mergeSort?
}
