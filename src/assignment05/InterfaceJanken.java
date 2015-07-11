package assignment05;
/**
 * Object.java
 * @author 15M39241　西坂 直登
 *
 */

public class InterfaceJanken {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Player yamada	= new Player("山田さん");
		Player murata	= new Player("村田さん");

		// セリフクラスを生成して渡す
		Serifu yamadaSerifu	= new YoungMan();
		yamada.setSerifu(yamadaSerifu);
		Serifu murataSerifu	= new Woman();
		murata.setSerifu(murataSerifu);
		
		Judge judgeman		= new Judge();
		judgeman.startJanken(yamada, murata);
	}
}
