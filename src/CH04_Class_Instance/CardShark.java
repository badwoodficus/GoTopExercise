package CH04_Class_Instance;

import java.util.Random;
import java.util.Scanner;

//請寫出在文字模式下顯示洗牌結果(撲克牌52張)的程式
//桃,磚,心,梅 各有1~10與J,Q,K

public class CardShark {

	public class Poke {
		private static char[] suit = { '♣', '♦', '♥', '♠' };
		private static String size[] = 
			{ "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		public static String[] createCard(int num) {
			String[] card = new String[52 * num];// 宣告52張牌
			int k = 0;
			for (int m = 0; m < num; m++) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 13; j++) {
						card[k] = suit[i] + size[j]; // 兩個陣列分成兩個迴圈跑就行，外圈花色跑四次，內圈牌號跑13次
						k++; // 讓K跑52次等同總牌數
					}

				}
			}
			return card;
		}

		public static void display(String[] card) {
			for (String c : card) { // String c: card 不確定意思要查一下
				System.out.print(c + " ");
			}

		}

		public static void shuffle(String[] card) { // 照命名來看應該是洗牌
			for (int i = 1; i < card.length; i++) {
				Random random = new Random();
				String c = card[i]; // 不確定宣告c要做甚麼
				int n = random.nextInt(i);
				card[i] = card[n];
				card[n] = c;
			}
		}

		public static void distribute(String[] card, int per) {
			for (int i = 0; i < per; i++) {
				System.out.println("第" + (i + 1) + "位玩家的牌如下:");
				for (int j = i * card.length / per; j < (i + 1) * card.length / per; j++) {
					System.out.print(card[j] + " ");
				}
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("該遊戲需要幾附撲克牌?");
		Scanner sc = new Scanner(System.in);
		int pack = sc.nextInt();
		String[] cards = Poke.createCard(pack);
		System.out.println("該遊戲有幾位玩家?");
		Scanner sp = new Scanner(System.in);
		int per = sp.nextInt();
		System.out.println("\n顯示所有的牌");
		Poke.display(cards);
		Poke.shuffle(cards);
		System.out.println("顯示分配給每位玩家的牌");
		Poke.distribute(cards, per);
	}
}

//書上提供的解答
//public class CardShuffle {
//    public static void main(String args[]) { 
//        final var N = 52; 
//        var poker = new int[N + 1]; 
//
//        for(var i = 1; i <= N; i++) {
//            poker[i] = i; 
//        }
//
//        for(var i = 1; i <= N; i++) { 
//            var j = (int) (Math.random() * N);
//            j = j == 0 ? 1 : j;
//            var tmp = poker[i]; 
//            poker[i] = poker[j]; 
//            poker[j] = tmp; 
//        } 
//
//        char[] symbols = {'桃', '心', '磚', '梅'};
//        
//        for(var i = 1; i <= N; i++) { 
//            System.out.print(symbols[(poker[i] - 1) / 13]);
//
//            var remain = poker[i] % 13; 
//            var symbol = switch(remain) { 
//                case  0 -> " K"; 
//                case 12 -> " Q";  
//                case 11 -> " J"; 
//                default -> String.format("%2d", remain); 
//            };
//            System.out.printf("%s%c", symbol, i % 13 == 0 ? '\n' : ' '); 
//        } 
//    }     
//}
