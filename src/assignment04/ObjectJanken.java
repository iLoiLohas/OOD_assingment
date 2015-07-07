package assignment04;

public class ObjectJanken {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Yamada yamada	= new Yamada("山田さん");
		Murata murata	= new Murata("村田さん");

		Judge judgemen		= new Judge();
		judgemen.startJanken(yamada, murata);
	}
}
