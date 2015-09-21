package cc.chaper3;

import java.util.ArrayList;
import java.util.Stack;


public class Solution03 {
	//TODO
	//Check if there's any error
	public class stackOfPlates{
		ArrayList<Stack> setOfStacks = new ArrayList<Stack>();
		private int Capacity;
		public void push(int data){
			Stack last = getLastStack();
			if (last != null && !last.isFull())
				last.push(data);
			else{
				Stack newStack = new Stack(Capacity);
				newStack.push(data);
				setOfStacks.add(newStack);
			}
		}
		public int pop(){
			Stack last = getLastStack();
			if (last == null){
				throw new EmptyStackException();
			}
			int value = last.pop();
			if (last.isEmpty()){
				setOfStacks.remove(setOfStacks.size() - 1);
			}
			return value;
		}
		public Stack getLastStack(){
			if (setOfStacks.size() == 0)
				return null;
			return setOfStacks.get(setOfStacks.size() - 1);
		}
	}
	public class Stack{
		private int Capacity;
		public int size = 0;
		public Node top, bottom;
		public Stack(int Capacity){
			this.Capacity = Capacity;
		}
		public void join (Node above, Node below){
			if (above != null)
				above.below = below;
			if (below != null)
				below.above = above;
		}
		public boolean push (int data){
			if (size >= Capacity)
				return false;
			size++;
			Node n = new Node(data);
			if(size == 1)
				bottom = n;
			join (n, top);
			top = n;
			return true;
		}
		public int pop (){
			Node t = top;
			top = top.below;
			size --;
			return t.value;
		}
		public boolean isFull(){
			return this.size == Capacity;
		}
		public boolean isEmpty(){
			return this.size == 0;
		}
	}
	public class Node{
		public int value;
		public Node below;
		public Node above;
		public Node(int data){
			this.value = data;
		}
	}
	public class EmptyStackException extends RuntimeException {
		  public EmptyStackException() {
		    this("Stack is empty");
		  }

		  public EmptyStackException(String exception) {
		    super(exception);
		  }
	}
	//TODO 
	//Follow up question
}
