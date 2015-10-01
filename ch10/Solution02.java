package chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution02 {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0)
            return result;
        String[] str2 = new String[strs.length];
        for (int i = 0; i < strs.length; i++){
            char[] charOfString = strs[i].toCharArray();
            Arrays.sort(charOfString);
            str2[i] = String.valueOf(charOfString);
        }
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for (int i = 0; i < str2.length; i++){
            if (!map.containsKey(str2[i])){
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str2[i], list);
            }
            else{
                map.get(str2[i]).add(strs[i]);
            }
        }
        
        for (List<String> l:map.values()){
            if (l.size()>0){
                result.add(l);
            }
        }
        return result;
    }
}
