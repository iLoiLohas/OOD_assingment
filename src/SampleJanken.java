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
	
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■
	// じゃんけんを開始する
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void startJanken() {
		int player1Hand = 0, player2Hand = 0;
		int[] playerWinCount = new int[2];
		// ジャンケンを３回実施する
		for (int cnt = 0; cnt < 3; cnt++)
		{
			System.out.println("【" + (cnt + 1) + "回戦目】");
			player1Hand	= decideHand();
			player2Hand	= decideHand();
			playerWinCount[0]	+= judgeJanken(player1Hand, player2Hand)[0];
			playerWinCount[1]	+= judgeJanken(player1Hand, player2Hand)[1];
		}
		endJanken(playerWinCount);
	}
	
	public void endJanken(int[] playerWinCount) {
		System.out.println("【ジャンケン終了】¥n");
		
		// プレイヤー１の勝ち数が多い時
		if (playerWinCount[0] > playerWinCount[1])
		{
			// プレイヤー１の勝ちを表示する。
			System.out.println(playerWinCount[0] + "対" + playerWinCount[1]
					+ "でプレイヤー１の勝ちです！¥n");
		}
		// プレイヤー２の勝ち数が多い時
		else if (playerWinCount[0] < playerWinCount[1])
		{
			// プレイヤー２の勝ちを表示する。
			System.out.println(playerWinCount[0] + "対" + playerWinCount[1]
					+ "でプレイヤー２の勝ちです！¥n");
		}
		// プレイヤー１と２の勝ち数が同じ時
		else if (playerWinCount[0] == playerWinCount[1])
		{
			// 引き分けを表示する。
			System.out.println(playerWinCount[0] + "対" + playerWinCount[1]
					+ "で引き分けです！¥n");
		}
	}

	// ■■■■■■■■■■■■■■■■■■■■■■■■■■
	// プレイヤーが何を出すか決める
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■
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
	
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■
	// どちらが勝ちかを判定し、結果を表示する
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■
	public int[] judgeJanken(int player1Hand, int player2Hand) {
		// プレイヤーの勝ち数
		int playerWinCount[] = new int[2];

		// プレイヤー１が勝つ場合
		if ((player1Hand == STONE && player2Hand == SCISSORS)
				|| (player1Hand == SCISSORS && player2Hand == PAPER)
				|| (player1Hand == PAPER && player2Hand == STONE)) {
			System.out.println("¥nプレイヤー１が勝ちました！¥n");
			playerWinCount[0]++;
		}
		// プレイヤー２が勝つ場合
		else if ((player1Hand == STONE && player2Hand == PAPER)
				|| (player1Hand == SCISSORS && player2Hand == STONE)
				|| (player1Hand == PAPER && player2Hand == SCISSORS)) {
			System.out.println("¥nプレイヤー２が勝ちました！¥n");
			playerWinCount[1]++;
		}
		// 引き分けの場合
		else {
			System.out.println("¥n引き分けです！¥n");
		}
		return playerWinCount;
	}
}
