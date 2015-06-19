package assignment02;

public class Player {

	// じゃんけんの手
	public static final int STONE		= 0;	// ぐー
	public static final int SCISSORS	= 1;	// ちょき
	public static final int PAPER		= 2;	// ぱー

	private String name_;
	private int winCount_;
	
	/**
	 * ランダムに手を出す
	 * @return playerHand
	 */
	public int showHand(){
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
	 * 審判に勝敗を聞いて勝ち数を更新する
	 */
	public void notifyResult(){
		
	}
	
	/**
	 * 勝った回数を数える
	 * @return winCount_
	 */
	public int getWinCount(){
		return winCount_;
	}
}
