public static boolean isUnique(String str){
		char[] arrayOfStr = str.toCharArray();
		Arrays.sort(arrayOfStr);
		for (int i = 0; i < arrayOfStr.length-1; i++){
			if (arrayOfStr[i] == arrayOfStr[i+1])
				return false;
		}
		return true;
	}
