package cc.chapter5;

public class Solution08 {
	public static void drawLine (byte[] screen, int width, int y, int x1, int x2){
		if (x1 > x2)
			return;
		int startBit = (y-1) * width + x1;
		int endBit = (y-1) * width + x2;
		int byteStart = startBit / 8;
		int byteEnd = endBit / 8;
		int bitStart = startBit % 8;
		int bitEnd = endBit % 8;
		if (byteStart == byteEnd){
			for (int i = bitStart; i <= bitEnd; i++)
				screen[i] = 1;
		}
		for (int i = byteStart + 1; i < byteEnd; i++){
			screen [i] = (byte) (screen[i] | 0xFF);
		}
		for (int i = 0; i < bitStart; i++){
			screen[i] = (byte) (screen[i] | 1 << (8-i));
		}
		for (int i = 0; i < bitEnd; i++){
			screen[i] = (byte) (screen[i] | 1 << i);
		}
			
	}
}
