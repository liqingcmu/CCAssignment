package cc.chaper3;

public class Solution01 {
	//Assume that the array is divided into three fixed length.
	public static class fixedLength{
		// Variables declaration.
		private int numOfStack = 3;
		private int stackCapacity; //the capacity/upper bound of each stack
		private int[] size; //size of each stack
		private int[] values; //values of all stack (the array)
		public fixedLength (int stackSize){
			stackCapacity = stackSize;
			size = new int[numOfStack];
			values = new int[stackCapacity * numOfStack];
		}
		//Push method: push value onto the stack
		public void push (int stackNo, int data) throws FullStackException{
			if (isFull(stackNo))
				throw new FullStackException();
			size[stackNo]++;
			values[indexOfTop(stackNo)] = data;
		}
		//Pop method:pop the top item from stack
		public int pop (int stackNo){
			if (isEmpty(stackNo))
				throw new EmptyStackException();
			int data = values[indexOfTop(stackNo)];
			size[stackNo]--;
			return data;
		}
		//Peek method: return the top element of the stack
		public int peek (int stackNo){
			if (isEmpty(stackNo))
				throw new EmptyStackException();
			int data = values[indexOfTop(stackNo)];
			return data;
		}
		//Return the index of the stack's top
		public int indexOfTop(int stackNo){
			int startOfStack = stackNo * stackCapacity;
			int currentSizeOfStack = size[stackNo];
			return startOfStack + currentSizeOfStack - 1;
		}
		//Check if the stack is full
		public boolean isFull (int stackNo){
			return size[stackNo] == stackCapacity;
		}
		//Check if the stack is empty
		public boolean isEmpty (int stackNo){
			return size[stackNo] == 0;
		}
		class FullStackException extends RuntimeException {
			  public FullStackException() {
			    this("Stack is full");
			  }

			  public FullStackException(String exception) {
			    super(exception);
			  }
		}
		class EmptyStackException extends RuntimeException {
			  public EmptyStackException() {
			    this("Stack is empty");
			  }

			  public EmptyStackException(String exception) {
			    super(exception);
			  }
		}
	}
	//TODO
	//Write ppseudocode of flexible length of the stack.
}
