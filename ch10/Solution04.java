package chapter10;

public class Solution04 {
	//Take O(log n) time
	public static int search (Listy listy, int value){
		int index = 0;
		if (listy.elementAt(index) != -1 && listy.elementAt(index) < value)
			index = index * 2;
		int low = index / 2;
		int high = index;
		while (low <= high){
			int mid_index = (low + high) / 2;
			int middle = listy.elementAt(mid_index);
			if (middle > value || middle == -1){
				high = mid_index - 1;
			}
			else if (middle < value){
				low = mid_index + 1;
			}
			else{
				return mid_index;
			}
		}
		return -1;
	}
}
