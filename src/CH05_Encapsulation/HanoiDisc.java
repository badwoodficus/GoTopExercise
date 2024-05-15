package CH05_Encapsulation;

import java.util.*;
import static java.lang.System.out;

public class HanoiDisc {
	static class Move {
		char from, to;

		Move(char from, char to) {
			this.from = from;
			this.to = to;
		}
	}

	List<Move> solve(int n) {
		moves = new ArrayList<Move>();
		move(n, 'A', 'B', 'C');
		return moves;
	}

	private List<Move> moves;

	private void move(int n, char a, char b, char c) {
		if (n == 1) {
			moves.add(new Move(a, c));
		} else {
			move(n - 1, a, c, b);
			move(1, a, b, c);
			move(n - 1, b, a, c);
		}
	}

	public static void main(String args[]) {
		out.print("請輸入盤數：");
		HanoiDisc DISC = new HanoiDisc();
		int n = new Scanner(System.in).nextInt();
		for (Move move : DISC.solve(n)) {
			out.printf("盤由 %c 移至 %c%n", move.from, move.to);
		}
	}
}
