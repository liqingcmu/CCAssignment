public static boolean ifPermutation (String str1, String str2){
		if (str1.length() != str2.length())
			return false;
		if (str1.equals(str2))
			return true;
		char[] charOfStr1 = str1.toCharArray();
		char[] charOfStr2 = str2.toCharArray();
		Arrays.sort(charOfStr1);
		Arrays.sort(charOfStr2);
		for (int i = 0; i < charOfStr1.length; i++){
			if (charOfStr1[i] != charOfStr2[i])
				return false;
		}
		
		return true;
	}
