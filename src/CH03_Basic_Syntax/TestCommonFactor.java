package CH03_Basic_Syntax;

//算出1000,495的最大公因數
//輾轉相除法
public class TestCommonFactor {
	public static void main(String[] args) {
		var m = 1000;
		var n = 495;

		while(n != 0) {
			var r = m % n;
			m = n;
			n = r;
		}
		System.out.printf("�̤j���]�� %d%n", m);
	}
}