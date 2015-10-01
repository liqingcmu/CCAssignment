package chapter10;

public class Solution03 {
	public int search(int[] nums, int target) {
        //int rotation = 0;
        if (nums.length == 1){
            if(nums[0] != target) 
                return -1;
            else{
                return 0;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target)
                return i;
        }
        /*for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[i+1])
                rotation = i;
                break;
        }
        if (target == nums[0]){
            for (int j = 0; j < nums.length; j++){
                if (nums[j] == target)
                    return j;
            }
        }
        else if (target > nums[0]){
            for (int j = 0; j <= rotation; j++){
                if (nums[j] == target)
                    return j;
            }
        }
        else{
            for (int j = rotation+1; j < nums.length; j++){
                if (nums[j] == target)
                    return j;
            }
        }*/
        return -1;
    }
}
