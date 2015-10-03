package cc.chapter5;

public class Solution02 {
	public static String binaryToString(double d){
		if (d >= 1 || d <= 0)
			return "Error";
		double frac = 0.5;
		StringBuilder str = new StringBuilder();
		str.append("0.");
		while (d > 0){
			if (str.length() > 32)
				return "Error";
			if (d >= frac){
				str.append("1");
				d = d - frac;
			}
			else
				str.append("0");
			frac = frac / 2;
		}
		return str.toString();
	}
	public static void main (String args[]){
		double d = 0.625;
		System.out.println(binaryToString(d));
	}
}
