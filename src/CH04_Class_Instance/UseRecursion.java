package CH04_Class_Instance;

import java.util.Scanner;

public class UseRecursion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入兩數:");
		System.out.print("m = ");
		int m = scanner.nextInt();
		System.out.print("n = ");
		int n = scanner.nextInt();
		System.out.println("GCD: " + gcd(m, n));
	}

	private static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return gcd(n, m % n);
		}
	}

//	private static int gcd(int m, int n) {   
//		int r = 0;
//
//		while (n != 0) {
//			r = m % n;
//			m = n;
//			n = r;
//		}
//
//		return m;  這邊使用迴圈來解題
//	}
}
