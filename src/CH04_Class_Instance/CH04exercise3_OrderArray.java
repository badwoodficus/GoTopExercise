package CH04_Class_Instance;

import java.util.Arrays;

//給予一個陣列使用程式由小排到大
public class CH04exercise3_OrderArray {
	public static void main(String[] args) {
		int[] number = { 70, 80, 31, 37, 10, 1, 48, 60, 33, 80 };

		Arrays.sort(number, 0, number.length);
		for (int i =0;i<number.length;i++) {
			System.out.print(number[i]+" ");
		}
//		不使用內建方法的排序
//		int[] order = new int[number.length];
//		System.arraycopy(number, 0, order, 0, number.length);
//		複製一個陣列，兩兩比較之後小的放前面，比較次數為剩餘長度-1 (不會跟自己比)
//		for (int i = 0; i < number.length; i++) {
//			for (int j = 0; j < number.length - 1; j++) {
//				
//				if (order[j] < number[i]) {
//					需要設定一個變數來暫存最小值
//				}
//			}
//			System.out.print(number[i]);
//		}
	}
}
