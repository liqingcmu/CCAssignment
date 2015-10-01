package chapter10;

public class Solution08 {
/**
 * Assume the integer is 4*8=32 bit. 4 kB = 4 * 2^8 * 8  bits = 32768 bits > 32000 bits.
	we can map each integer value to the corresponding memory location.
	We create a bit vector(bv) of size 15, which maps addresses 0:32768.
	Initialize all memory locations to 0.
	Function: 
	if we write bv[int] = 1, which means bit vector will convert the int to corresponding memory location 
	and set the bit to value 1 from 0. 
	So if the bit is 1 already then print the number as duplicate.
	Refer to: https://mydevelopedworld.wordpress.com/2012/10/06/duplicate-entries-with-4kb-constraint-bit-array-is-the-solution/
	*/
	public static void findDuplicates(int[] array){
		BitVector bv = new BitVector(32000);
		for (int i = 0; i < array.length; i++){
			int num = array[i];
			int pos = num - 1;//bv starts at 0, numbers start at 1
			if (bv.get(pos))
				System.out.println(array[i]);
			else
				bv.set(pos);
		}
	}
	public static class BitVector{
		public int[] bv;
		public BitVector(int size){
			bv = new int[(size>>5) + 1];
		}
		boolean get(int pos){
			int wordNum = pos >> 5;//locate the index of the int array element which contains the bit
			int bitNum = (pos & 0x1F); //Mod 32;locate the exact bit between the other 31 bits
			boolean value = ((bv[wordNum] & (1<<bitNum)) != 0);
			return value;
		}
		void set(int pos){
			int wordNum = pos >> 5;//locate the index of the int array element which contains the bit
			int bitNum = (pos & 0x1F); //Mod 32;locate the exact bit between the other 31 bits
			bv[wordNum] =(bv[wordNum] | (1<<bitNum));
		}
	}
	
}
