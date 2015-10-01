package chapter10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution07 {
// 1GB = 8 billion bits > 4 billion bits
	long numOfInts = ((long)Integer.MAX_VALUE) + 1;
	byte[] bitArray = new byte[(int) numOfInts/8];
	String file = "test.txt";
	
	public void findMissingInt() throws FileNotFoundException{
		Scanner content = new Scanner(new FileReader(file));
		while (content.hasNextInt()){
			int n = content.nextInt();
			bitArray[n/8] |=  (1 << (n%8));
		}
		for (int i = 0; i <bitArray.length; i++){
			for (int j = 0; j < 8; j++){
				if ((bitArray[i] & (1<<j)) == 0){
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}
	
	//TODO Followup Question
}
