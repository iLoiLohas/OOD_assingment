package assignment02;

public class SampleJanken {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Player yamada	= new Player("山田さん");
		Player tanaka	= new Player("田中さん");

		Judge satou		= new Judge();
		satou.startJanken(yamada, tanaka);
	}

}
