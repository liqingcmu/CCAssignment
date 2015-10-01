package chapter10;

public class Solution05 {
	//Take O(log n) time
	public static int sparseSearch(String[] strs, String tar){
		if (strs == null || tar == null || tar ==""){
			return -1;
		}
		return search (strs, tar, 0, strs.length - 1);
	}
	public static int search (String[] strs, String tar, int first, int last){
		if (first > last)
			return -1;
		int mid = (first + last) / 2;
		int left, right;
		if (strs[mid].isEmpty()){
			left = mid - 1;
			right = mid + 1;
			while (true){
				if (left < first && right > last)
					return -1;
				else if (left >= first && !strs[left].isEmpty()){
					mid = left;
					break;
				}
				else if (right <= last && !strs[right].isEmpty()){
					mid = right;
					break;
				}
				left--;
				right++;
			}
		}
		if (strs[mid].equals(tar))
			return mid;
		else if (strs[mid].compareTo(tar) < 0){//right
			return search(strs, tar, mid+1, last);
		}
		else{//left
			return search (strs, tar, first, mid-1);
		}
	}
}
