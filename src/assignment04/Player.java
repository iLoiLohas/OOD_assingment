package assignment04;
/**
 * Player.java
 * @author 15M39241　西坂 直登
 *
 */
public class Player {
	/**
	 * じゃんけんの手は列挙型として定義する！！！
	 */
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
	public Player(String name){
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
		this.winCount_+=1;
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
	/**
	 * じゃんけん開始のセリフ
	 * @return startWord
	 */
	public String startWord(){
		String startWord	="じゃんけんスタートだ！";
		return startWord;
	}
	/**
	 * じゃんけん勝利のセリフ
	 * @return winWord
	 */
	public String winWord(){
		String winWord	= "やった！勝ったぞ！";
		return winWord;
	}
	/**
	 * じゃんけんドローのセリフ
	 * @return drawWord
	 */
	public String drawWord(){
		String drawWord	= "引き分けだったね！";
		return drawWord;
	}
}

