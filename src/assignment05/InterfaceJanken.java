package assignment05;
/**
 * InterfaceJanken.java
 * @author 15M39241　西坂 直登
 *
 */
public class InterfaceJanken {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Player yamada	= new Player("山田さん");
		Player murata	= new Player("村田さん");

		// 戦略クラスを生成して渡す
		Tactics yamadaTactics	= new RandomTactics();
		yamada.setTactics(yamadaTactics);
		Tactics murataTactics	= new CycleTactics();
		murata.setTactics(murataTactics);
		
		// セリフクラスを生成して渡す
		Serifu yamadaSerifu	= new YoungMan();
		yamada.setSerifu(yamadaSerifu);
		Serifu murataSerifu	= new Woman();
		murata.setSerifu(murataSerifu);
		
		Judge judgeman		= new Judge();
		judgeman.startJanken(yamada, murata);
	}
}
