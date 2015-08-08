package assignment07;

/**
 * PageOneのプレイヤークラス。
 */
public class Player
{
    /** 進行役 */
    private Master master_;

    /** テーブル */
    private Table table_;

    /** 自分の手札 */
    private Hand myHand_;

    /** 名前 */
    private String name_;
    
    /**
     * コンストラクタ。Constructor
     * 
     * @param name 名前
     * @param master 進行役
     */
    public Player(String name, Master master, Table table, Hand hand)
    {
        this.name_ = name;
        this.master_ = master;
        this.table_ = table;
        this.myHand_ = hand;
    }

    /**
     * 順番を指名する。One Play
     * 
     */
    public void play()
    {
    	// 自分の名前と現在の手札を表示する
        System.out.println(this + "：手札は 「" + myHand_ + "」です");

    	// テーブルの一番上のカードを知る．
    	Card tableCard = table_.topCard();

        // テーブルの一番上のカードを表示する
        System.out.println("テーブルのカードは" + tableCard + "です");

        // そのカードをもとに，出すカードを選ぶ
        Card card = myHand_.findSameCard(tableCard);

        // 出せるカードがあったか？
        if (card != null) {
        	// そのカードをテーブルに捨てる
            table_.disposeCard(card);
		}
        else
        {
        	//無かった No card
            master_.pass(this);
    	}
        
        // 残りの手札の枚数は0枚か？
        if (myHand_.getNumberOfCards() == 0) {
            // 0枚であれば上がりを宣言する
            master_.declareWin(this);
        }
        else
        {
            // 0枚でなければ，手札を表示する
            System.out.println(this + "：手札は " + myHand_ + "です");
        }   
    }
    /**
     * カードを受け取る。
     * 
     * @param card 受け取ったカード
     */
    public void receiveCard(Card card)
    {
        // 引いたカードを自分の手札に加える
    	myHand_.addCard(card);
    }
    /**
     * プレイヤーの名前を返す。 <br>
     * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド。
     * 
     * @return プレイヤーの名前
    */
    public String toString()
    {
        return name_;
    }
}