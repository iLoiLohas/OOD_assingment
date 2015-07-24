package assignment06;

import java.util.ArrayList;

/**
 * ばば抜きの手札を表すクラス。
 */
public class Hand
{
    /** 手札にあるカードを保持するためのリスト */
    private ArrayList hand_ = new ArrayList();

    /**
     * カードを加える。
     * 
     * @param card 加えるカード
     */
    public void addCard(Card card)
    {
        // カードをリストの最後に追加する
        hand_.add(card);
    }
    /**
     * カードを引く。
     * 
     * @return 引いたカード
     */
    public Card pickCard()
    {
        Card pickedCard = (Card) hand_.remove(0);
        return pickedCard;
    }
    /**
     * シャッフルする。
     */
    public void shuffle()
    {
        // 手札の枚数を取得
        int number = hand_.size();
        // カードを抜き出す位置
        int pos;

        // カードをランダムに抜き取って最後に加える動作を繰り返す
        for (int count = 0; count < number * 2; count++)
        {
            // ランダムな位置からカードを一枚抜き取る
            pos = (int) (Math.random() * number);
            Card pickedCard = (Card) hand_.remove(pos);

            // 抜き取ったカードを最後に加える
            hand_.add(pickedCard);
        }
    }
    /**
     * 枚数を数える。
     * 
     * @return 手札にあるカードの枚数
     */
    public int getNumberOfCards()
    {
        return hand_.size();
    }
    /**
     * 同じ数のカードを探す。
     * 同じ数のカードがない場合は null を返します。
     * 
     * @return 同じ数のカード
     */
    public Card findSameCard(Card tableCard)
    {
        Card sameCards = null;

            for (int index = 0; index < hand_.size(); index++)
            {
                Card card = (Card) hand_.get(index);
                if (card.isSame(tableCard))
                {
                	// 同じカードが見つかった場合
                    sameCards = (Card) hand_.remove(index);
                    break;
                }
                // 同じ数の組み合わせが見つからなかった場合
        }
        return sameCards;
    }
    /**
     * 手札にあるカードを文字列で表現する。
     * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド。
     * 
     * @return 手札にあるカードの文字列表現
     */
    public String toString()
    {
        StringBuffer string = new StringBuffer();

        int size = hand_.size();
        if (size > 0)
        {
            for (int index = 0; index < size; index++)
            {
                Card card = (Card) hand_.get(index);
                string.append(card);
                string.append(" ");
            }
        }
        return string.toString();
    }
    
	/**
	* PageOneのHandとCardのテストのためのメインルーチン(テストドライバ)
	* main routine (test driver) for Hand and Card of PageOne
	*/    
	public static void main(String args[]) {
		// 手札の作成
		Hand hand = new Hand();

		// カードを生成する（枚数や種類は変更してみること）
		hand.addCard(new Card(Card.SUIT_DIAMOND, 1));
		hand.addCard(new Card(Card.SUIT_DIAMOND, 2));
		hand.addCard(new Card(Card.SUIT_SPADE  , 3));
		hand.addCard(new Card(Card.SUIT_SPADE  , 1));
		hand.addCard(new Card(Card.SUIT_HEART  , 2));
		hand.addCard(new Card(Card.SUIT_HEART  , 3));
		hand.addCard(new Card(Card.SUIT_CLUB   , 4));

		// 手を表示する．
		System.out.println("Hand : " + hand);

		// シャッフルする．
		hand.shuffle();

		// テーブルに出ているカードを生成（変更可）
		Card tableCard = new Card(Card.SUIT_CLUB, 1);

		//カードが無くなるまで繰り返す
		while (hand.getNumberOfCards()>0) {
			
			// 手を表示するする．
			System.out.println("Hand : " + hand);

			// テーブルにあるカードを表示する．
			System.out.println("Table: " + tableCard);

			// テーブルにあるカードに基づき手を決める．
			Card aCard = hand.findSameCard(tableCard);

			// カードが出せなければパスを表示して抜ける
			if (aCard == null) {
				System.out.println("Pass!");
				break;
			}
			// 出したカードを表示する
			System.out.println("Discard : " + aCard);

			// discarded card became the card on the table
			tableCard = aCard;
		}
		//終了の表示
		System.out.println("Next person's turn!");
	}
}