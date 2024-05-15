package CH03_Basic_Syntax;
//找出三位數的阿姆斯壯數
//a^3+b^3+c^3= a*100+b*10+c;

public class ArmstrongNumbers {
	
	public static void main(String[] args) {
		int sum =0;
		int tmp =0;
		for(int a=1;a<10;a++) {
			for(int b=1;b<10;b++) {
				for(int c=1;c<10;c++) {
					sum = a*a*a+b*b*b+c*c*c;
					tmp = a*100+b*10+c;
					if(sum == tmp) {
						System.out.println(sum);
					}
				}
			}
		}
	}
	
}
