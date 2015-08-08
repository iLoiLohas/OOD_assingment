package assignment07;


import java.util.ArrayList;

/**
 * PageOneの進行役を表すクラス。
 */
public class Master
{
    /** プレイヤーのリスト */
    private ArrayList players_ = new ArrayList();
    
    /** マスターの持つカード　*/
    private Hand hand_;
    
    /**テーブル*/
    private Table table_;
    
    public Master (Table table)
    {
    	table_=table;
    }

    /**
     * ゲームの準備をする。
     * 
     * @param cards トランプを進行役の手札として渡す
     */
    public void prepareGame(Hand cards)
    {
        System.out.println("【カードを配ります】");
        
        //受け取ったカードをマスターの手札とする
        hand_=cards;

        // トランプをシャッフルする
        hand_.shuffle();

        // プレイヤーの人数を取得する
        int numberOfPlayers = players_.size();

        //7枚づつ各プレイヤーに配る
        for (int i = 0; i < 7; i++)
        {
        	for (int p = 0; p < numberOfPlayers; p++)
        	{
                // カードから一枚引く
                Card card = hand_.pickCard();

                // 各プレイヤーに順番にカードを配る
                Player player = (Player) players_.get(p);
                player.receiveCard(card);
        	}
        }
        
        //一枚をテーブルに置く
        Card card = hand_.pickCard();
        table_.disposeCard(card);
        
    }

    /**
     * ゲームを開始する。
     */
    public void startGame()
    {
        System.out.println("【PageOneを開始します】");
        
        // 初期のプレイヤーの人数を得る
        int initialPlayers = players_.size();

        // プレイヤーの人数が変化しない（誰も上がらない）限り，繰り返す
        for (int count = 0; players_.size() == initialPlayers; count++)
        {
            // カードを出すプレイヤーを決める
        	int playerIndex = count % players_.size();
            Player player = (Player) players_.get(playerIndex);

            // そのプレイヤーにPlayさせる
            System.out.println(player + "さんの番です");
            player.play();
        }

        // プレイヤーが減っていれば終了する
        System.out.println("【PageOneを終了しました】");
    }

    /**
     * 上がりを宣言する。 Declare win
     * 
     * @param winner 上がったプレイヤー
     */
    public void declareWin(Player winner)
    {
        // 上がったプレイヤー
        System.out.println(winner + "さんが上がりました！");

        // 上がったプレイヤーをリストからはずす
        players_.remove(players_.indexOf(winner));
    }
    
	/**
	 * パスを宣言する。
	 * 
	 * @param player パスするプレイヤー
	 */
	public void pass(Player player)
	{
		// パスを表示
		System.out.println(player + "さんはパスしました！");

		//　パスしたプレイヤーにカードを渡す
		Card card = hand_.pickCard();

        player.receiveCard(card);
		
	}

    /**
     * ゲームに参加するプレイヤーを登録する。
     * 
     * @param player 参加するプレイヤー
     */
    public void registerPlayer(Player player)
    {
        // リストに参加者を追加する
        players_.add(player);
    }
}