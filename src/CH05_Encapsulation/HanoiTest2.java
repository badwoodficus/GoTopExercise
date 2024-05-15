package CH05_Encapsulation;

import java.util.Arrays;
import java.util.Scanner;

public class HanoiTest2 {
	public static void main(String[] args) {
		System.out.println("想要移動幾個盤子?:");
		Scanner sc = new Scanner(System.in);
		int step = sc.nextInt();
		hanoi(step);
	}

	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

	public static int whichDisk(int n) {
		int c = n ^ (n + 1);
		int i = 0;
		while (c != 0) {
			c = c >> 1;
			i = i + 1;
		}
		return i;
	}

	public static void hanoi(int n) {
		int numberOfMoves = (int) Math.pow(2, n) - 1;
		int[] dir = isEven(n) ? new int[] { 1, 0 } : new int[] { 0, 1 };
		int[] pin = new int[numberOfMoves];
		Arrays.fill(pin, 1);

		for (int i = 0; i < numberOfMoves; i++) {
			int disk = whichDisk(i);
			int pIdx = disk - 1;
			int dIdx = disk & 1;
			int next = (pin[pIdx] + dir[dIdx]) % 3 + 1;
			System.out.println(pin[pIdx] + " " + next);
			pin[pIdx] = next;
		}
	}
}
