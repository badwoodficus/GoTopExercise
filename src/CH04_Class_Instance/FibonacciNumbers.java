package CH04_Class_Instance;

import java.util.Scanner;

//f(n)=f(n-1)+f(n-2) if n>1
//f(n) = n if n=0 , 1

/*
 * f(n)= x, f(n-1)=b, f(n-2)=a
 * a + b = x
 * 0 + 1 = 1 ,n=2
 * 1 + 1 = 2 ,n=3
 * 1 + 2 = 3 ,n=4
 * 2 + 3 = 5
 */

public class FibonacciNumbers {
	public static void main(String[] args) {
		System.out.println("求幾個費式數?(請輸入正整數) :");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = 0;

		int a, b;
		a = 0;
		b = 1;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				x = 0;
				System.out.print(x + " ");
			} else if (i == 1) {
				x = 1;
				System.out.print(x + " ");
			} else {
				x = (a + b);
				System.out.print(x + " ");
				a = b;
				b = x;
			}
		}

		scanner.close();

	}
//	不知道怎麼讓輸入的n帶入上面的方法用Scanner宣告新的scanner物件
//	記得在結束時使用scanner.close();關閉scanner
//	程式跑到scanner會卡住>需要在console區塊輸入文字
}
