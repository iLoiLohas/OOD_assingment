package assignment01;
/**
 * SampleJanken.java
 * @author 15M39241　西坂直登
 *
 */
public class SampleJanken {
	
	// じゃんけんの手
	public static final int STONE		= 0;	// ぐー
	public static final int SCISSORS	= 1;	// ちょき
	public static final int PAPER		= 2;	// ぱー

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleJanken janken	= new SampleJanken();
		janken.startJanken();
	}
	
	/**
	 * じゃんけんを開始する
	 */
	public void startJanken() {
		int player1Hand = 0, player2Hand = 0;
		int player1WinCount = 0, player2WinCount = 0;
		int[] playerWinCount = new int[2];
		
		// ジャンケンを３回実施する
		for (int cnt = 0; cnt < 3; cnt++)
		{
			System.out.println("【" + (cnt + 1) + "回戦目】");
			player1Hand	= decideHand();
			System.out.print("vs");
			player2Hand	= decideHand();
			System.out.println();
			// 勝敗を判定
			playerWinCount	= judgeJanken(player1Hand, player2Hand);
			player1WinCount	+= playerWinCount[0];
			player2WinCount	+= playerWinCount[1];
		}
		endJanken(player1WinCount, player2WinCount);
	}

	/**
	 * じゃんけんを終了する
	 * @param playerWinCount
	 */
	public void endJanken(int player1WinCount, int player2WinCount) {
		System.out.println("【ジャンケン終了】");
		
		// プレイヤー１の勝ち数が多い時
		if (player1WinCount > player2WinCount)
		{
			// プレイヤー１の勝ちを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー１の勝ちです！");
		}
		// プレイヤー２の勝ち数が多い時
		else if (player1WinCount < player2WinCount)
		{
			// プレイヤー２の勝ちを表示する。
			System.out.println(player2WinCount + "対" + player2WinCount + "でプレイヤー２の勝ちです！");
		}
		// プレイヤー１と２の勝ち数が同じ時
		else if (player1WinCount == player2WinCount)
		{
			// 引き分けを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount + "で引き分けです！");
		}
	}

	/**
	 * プレイヤーが何を出すか決める
	 * @return
	 */
	public int decideHand() {
		// ジャンケンの手を決めるのに使用する乱数
		double randomNum = 0;		
		// プレイヤー１が出す手
		int playerHand	= 0;
		
		randomNum	= Math.random() * 3;
		if (randomNum < 1)
		{
			playerHand = STONE;
			System.out.print("グー");
		}
		else if (randomNum < 2)
		{
			playerHand = SCISSORS;
			System.out.print("チョキ");
		}
		else if (randomNum < 3)
		{
			playerHand = PAPER;
			System.out.print("パー");
		}
		return playerHand;
	}
	
	/**
	 * 勝者を判定し，結果を表示する
	 * @param player1Hand
	 * @param player2Hand
	 * @return
	 */
	public int[] judgeJanken(int player1Hand, int player2Hand) {
		// プレイヤーの勝ち数
		int player1WinCount = 0, player2WinCount = 0;
		int[] playerWinCount = new int[2];

		// プレイヤー１が勝つ場合
		if ((player1Hand == STONE && player2Hand == SCISSORS)
				|| (player1Hand == SCISSORS && player2Hand == PAPER)
				|| (player1Hand == PAPER && player2Hand == STONE)) {
			System.out.println("プレイヤー１が勝ちました！");
			player1WinCount++;
		}
		// プレイヤー２が勝つ場合
		else if ((player1Hand == STONE && player2Hand == PAPER)
				|| (player1Hand == SCISSORS && player2Hand == STONE)
				|| (player1Hand == PAPER && player2Hand == SCISSORS)) {
			System.out.println("プレイヤー２が勝ちました！");
			player2WinCount++;
		}
		// 引き分けの場合
		else {
			System.out.println("引き分けです！");
		}
		playerWinCount[0] = player1WinCount;
		playerWinCount[1] = player2WinCount;
		
		return playerWinCount;
	}
}
