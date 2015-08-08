package assignment07;

/**
 * PageOneプログラム。
 */
public class PageOne
{
    public static void main(String args[])
    {
        // 場の生成
        Table table = new Table();

        // 進行役の生成
        Master master = new Master(table);

        // プレイヤーの生成
        Player murata = new Player("Murata", master, table, new Hand());
        Player yamada = new Player("Yamada", master, table, new Hand());
        Player nishizaka = new Player("nishizaka", master, table, new AskHand());

        // 進行役へプレイヤーを登録
        master.registerPlayer(murata);
        master.registerPlayer(yamada);
        master.registerPlayer(nishizaka);

        // トランプを生成する
        Hand trump = createTrump();

        // ゲームの準備をする
        master.prepareGame(trump);

        // ゲームを開始する
        master.startGame();

    }

    /**
     * 53枚のトランプを生成する。
     * 
     * @return トランプを格納したHand
     */
    private static Hand createTrump()
    {
        Hand trump = new Hand();

        // 各スート18枚のカードを生成する
		for (int i = 0; i < 2; i++)
			for (int number = 1; number <= 9; number++) {
				trump.addCard(new Card(Card.SUIT_CLUB, number));
				trump.addCard(new Card(Card.SUIT_DIAMOND, number));
				trump.addCard(new Card(Card.SUIT_HEART, number));
				trump.addCard(new Card(Card.SUIT_SPADE, number));
			}

        return trump;
    }
}
