package assignment04;
/**
 * Yamada.java
 * @author 15M39241　西坂 直登
 *
 */
public class Yamada extends Player {
	/**
	 * コンストラクタ
	 * @param name
	 */
	public Yamada(String name){
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
		// 必ずパーを出す
		return Hand.PAPER;
	}
}
