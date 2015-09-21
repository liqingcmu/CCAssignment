package cc.chaper3;

import java.util.Stack;

public class Solution02 {
	/**
	 * There are two methods to solve the problem. One is space-less-efficient, especially when the stack is large.
	The other is space-efficient.*/
	//Method 1: space-less-efficient
	public class minInStack extends Stack<Node>{
		public void push (int value){
			int newMin = Math.min(value, min());
			super.push(new Node(value, newMin));
		}
		public int min(){
			if (this.isEmpty())
				return Integer.MAX_VALUE;
			else
				return this.peek().min;
		}
	}
	public class Node{
		public int min;
		public int value;
		public Node(int data, int min){
			this.value = data;
			this.min = data;
		}
	}
	//Method 2: space-efficient -- to use another stack to store the minimum
	public class minInStack2 extends Stack<Integer>{
		Stack<Integer> stackOfMin;
		public minInStack2(){
			stackOfMin = new Stack<Integer>();
		}
		public void push(int data){
			if (data <= min())
				stackOfMin.push(data);
			super.push(data);
		}
		public Integer pop(){
			int value = super.pop();
			if (value == this.min())
				stackOfMin.pop();
			return value;
		}
		public int min(){
			if (stackOfMin.isEmpty())
				return Integer.MAX_VALUE;
			else
				return stackOfMin.peek();
		}
	}
	
}
