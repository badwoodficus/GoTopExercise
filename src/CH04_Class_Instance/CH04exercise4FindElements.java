package CH04_Class_Instance;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 寫出程式讓使用者可以找排序後的陣列中特定資料
 * 找到的話顯示索引值，找不到就顯示-1
 */
public class CH04exercise4FindElements {
	public static void main(String[] args) {
		int[] number = { 1, 10, 31, 33, 37, 48, 60, 70, 80 };
		int[] tmp = Arrays.copyOf(number, number.length + 1);

		for (int i = 1; i < tmp.length; i++) {
			tmp[i] = number[i - 1];
		}

		System.out.println("請輸入想查詢的數字:");
		tmp[0] = new Scanner(System.in).nextInt();

		var i = number.length;
		while (tmp[i] != tmp[0]) {
			i--;
		}
		System.out.print(i - 1);
	}
}
