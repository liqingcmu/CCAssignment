package cc.chaper3;

import java.util.Stack;

public class Solution04 {
	//Assume type of element in stack is integer.
	public class MyQueue<Integer>{
		Stack<Integer> newStack,oldStack;
		public MyQueue(){
			Stack<Integer> newStack = new Stack<Integer>();
			Stack<Integer> oldStack = new Stack<Integer>();
		}
		public int size(){
			return newStack.size()+oldStack.size();
		}
		public void add (Integer value){
			newStack.push(value);
		}
		public void stackShift(){
			if (oldStack.isEmpty()){
				while(!newStack.isEmpty())
					oldStack.push(newStack.pop());
			}
		}
		public Integer peek(){
			stackShift();
			return oldStack.peek();
		}
		public Integer remove(){
			stackShift();
			return oldStack.pop();
		}
	}
}
