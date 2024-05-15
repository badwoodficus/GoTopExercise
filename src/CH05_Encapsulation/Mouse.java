package CH05_Encapsulation;

//Point表示迷宮中的座標
class Point {
	final int x;
	final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//介面Boss操作當前的座標
interface Boss {
	void take(int[][] maze);
}

public class Mouse {
	/*
	 * 這個函數接收迷宮、當前點、終點和一個 Boss 介面的實例。首先檢查當前點是否可以訪問，如果可以，則將迷宮中的該點設為 1，表示已經訪問過。
	 * 如果當前點是終點，則調用 Boss 的 take() 方法來處理迷宮。
	 * 如果當前點不是終點，則遞迴地訪問四個方向（上、右、下、左）。最後，將迷宮中的該點設為 0，表示該點已經不再訪問。
	 */
	public static void visit(int[][] maze, Point pt, Point end, Boss boss) {
		if (isVisitable(maze, pt)) {
			maze[pt.x][pt.y] = 1;
			if (isEnd(maze, end)) {
				boss.take(maze);
			} else {
				visit(maze, new Point(pt.x, pt.y + 1), end, boss);
				visit(maze, new Point(pt.x + 1, pt.y), end, boss);
				visit(maze, new Point(pt.x, pt.y - 1), end, boss);
				visit(maze, new Point(pt.x - 1, pt.y), end, boss);
			}
			maze[pt.x][pt.y] = 0;
		}
	}

	// 檢查迷宮中的一個點是否可以通過。如果迷宮中的該點的值為 0，則返回 true，否則返回 false。
	private static boolean isVisitable(int[][] maze, Point pt) {
		return maze[pt.x][pt.y] == 0;
	}

	// 檢查檢查一個點是否是終點。如果迷宮中的該點的值為 1，則返回 true，否則返回 false。
	private static boolean isEnd(int[][] maze, Point end) {
		return maze[end.x][end.y] == 1;
	}

	/*
	 * 在 main 函數中，我們首先創建了一個迷宮，然後調用 visit() 函數來找出所有的路徑。我們傳遞一個 Lambda 表達式給 visit() 函數，
	 * 該 Lambda 表達式定義了一個 Boss 介面的實例，該實例的 take() 方法列印出找到的路徑。
	 */
	public static void main(String[] args) {
		Mouse.visit(new int[][] { { 2, 2, 2, 2, 2, 2, 2 }, // 0表示道路,2表示牆壁，請列印出老鼠走出迷宮的路線(不包含繞路)
				{ 0, 0, 0, 0, 0, 0, 2 }, // 入口在此列的最左邊0 [1][0]
				{ 2, 0, 2, 0, 2, 0, 2 }, { 2, 0, 0, 2, 0, 2, 2 }, { 2, 2, 0, 2, 0, 2, 2 }, { 2, 0, 0, 0, 0, 0, 2 },
				{ 2, 2, 2, 2, 2, 0, 2 } }, // [6][5]為迷宮出口
				new Point(1, 0), new Point(6, 5),
				// Lambda語法
				maze -> {
					for (int[] row : maze) {
						for (int block : row)
							switch (block) {
							case 0:
								System.out.print("○");
								break; // 可以走但是不選擇的道路
							case 1:
								System.out.print("□");
								break; // 老鼠走出迷宮的道路
							case 2:
								System.out.print("■");
								break; // 老鼠不可以走的牆壁
							}
						System.out.println();
					}
				}

		);
	}
}
