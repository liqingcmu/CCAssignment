/**
	 * The point of solving the problem is to find that:
		yx is always a substring of xyxy. What we need to do is to construct xyxy.
		x and y are the seperate parts that constitutes of the original string. 
		*/
	public static boolean stringRotation (String str1, String str2){
		int length = str1.length();
		if (length == str2.length() && length > 0){
			String newStr = str1 + str1;
			return isSubstring (newStr, str2);
		}
		return false;
	}
