package cc.chaper3;

import java.util.LinkedList;
//There's defect in the definition of order. Assume that if the orders of dog and cat are same, we choose dequeue cat first.
public class Solution06 {
	public abstract class Animal{
		private int order;
		public String name;
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public Animal (String str){
			this.name = str;
		}
	}
	public class Dog extends Animal{
		public Dog (String str){
			super(str);
		}
	}
	public class Cat extends Animal{
		public Cat (String str){
			super(str);
		}
	}
	public class AnimalShelter{
		LinkedList<Dog> dog = new LinkedList<Dog>();
		LinkedList<Cat> cat = new LinkedList<Cat>();
		private int order = 0;
		public void enqueue(Animal animal){
			animal.setOrder(order);
			order++;
			if (animal instanceof Dog)
				dog.add((Dog) animal);
			else if (animal instanceof Cat)
				cat.add((Cat) animal);
		}
		public Animal dequeueAny(){
			if (dog.isEmpty())
				return dequeueCat();
			else if (cat.isEmpty())
				return dequeueDog();
			else{
				if (dog.peek().getOrder() > cat.peek().getOrder())
					return dequeueDog();
				else
					return dequeueCat();
			}
		}
		public Dog dequeueDog(){
			return dog.poll();
		}
		public Cat dequeueCat(){
			return cat.poll();
		}
	}
}
