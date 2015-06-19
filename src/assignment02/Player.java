package assignment02;

public class Player {

	// じゃんけんの手
	public enum Hand{
		STONE,
		SCISSORS,
		PAPER
	}

	private String name_;
	private int winCount_	= 0;
	
	/**
	 * コンストラクタで名前を設定する
	 * @param name
	 */
	Player(String name){
		this.name_	= name;
	}
	/**
	 * ランダムに手を出す
	 * @return playerHand
	 */
	public Hand showHand(){
		// ジャンケンの手を決めるのに使用する乱数
		double randomNum = 0;		
		// プレイヤーが出す手
		Hand playerHand	= null;
		
		randomNum	= Math.random() * 3;
		if (randomNum < 1)
		{
			playerHand = Hand.STONE;
		}
		else if (randomNum < 2)
		{
			playerHand = Hand.SCISSORS;
		}
		else if (randomNum < 3)
		{
			playerHand = Hand.PAPER;
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
	/**
	 * 勝った回数を設定する
	 * @param winCount
	 */
	public void setWinCount(int winCount){
		this.winCount_	= winCount;
	}
	/**
	 * プレイヤーの名前を取得する
	 * @return
	 */
	public String getName(){
		return this.name_;
	}
}
