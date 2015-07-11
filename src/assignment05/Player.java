package assignment05;
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
	private Serifu serifu_;
	private Tactics tactics_;
	private int winCount_	= 0;
	
	/**
	 * コンストラクタで名前を設定する
	 * @param name
	 */
	public Player(String name){
		this.name_	= name;
	}
	/**
	 * プレイヤーに戦略を渡す
	 * @param tactics
	 */
	public void setTactics(Tactics tactics){
		tactics_	= tactics;
	}
	/**
	 * ランダムに手を出す
	 * @return playerHand
	 */
	public Hand showHand(){
		return tactics_.readTactics();
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
		return serifu_.start();
	}
	/**
	 * じゃんけん勝利のセリフ
	 * @return winWord
	 */
	public String winWord(){
		return serifu_.win();
	}
	/**
	 * じゃんけんドローのセリフ
	 * @return drawWord
	 */
	public String drawWord(){
		return serifu_.draw();
	}
	/**
	 * プレイヤーにセリフを渡す
	 * @param serifu
	 */
	void setSerifu(Serifu serifu){
		serifu_	= serifu;
	}
}

