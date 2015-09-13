public static String replaceSpaces(String str, int number){
		String[] seperateStrings = str.trim().split("\\s+");
		int length = seperateStrings.length;
		for (int i = 0; i < length-1; i++){
			seperateStrings[i] = seperateStrings[i].concat("%20");
		}
		 String newString = "";
		for (int i = 0; i < length; i++){
			newString = newString.concat(seperateStrings[i]);
		}
		return newString;
	}
