package assignment04;
/**
 * Murata.java
 * @author 15M39241　西坂 直登
 *
 */
public class Murata extends Player {
	
	/**
	 * コンストラクタ
	 * @param name
	 */
	public Murata(String name){
		// スーパークラスのコンストラクタ
		super(name);
	}
	/**
	 * じゃんけんの手を出す
	 * スーパークラスの同名メソッドをオーバーライドしている
	 * 
	 * @return Hand
	 */
	public Hand showHand(){
		// 必ずグーを出す
		return Hand.STONE;
	}

}
