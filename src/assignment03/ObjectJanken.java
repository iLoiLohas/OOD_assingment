package assignment03;

public class ObjectJanken {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Player yamada	= new Player("山田さん");
		Player tanaka	= new Player("田中さん");

		Judge judgemen		= new Judge();
		judgemen.startJanken(yamada, tanaka);
	}
}
