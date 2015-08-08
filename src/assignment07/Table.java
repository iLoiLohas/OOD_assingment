package assignment07;


import java.util.ArrayList;

/**　テーブルを表すクラス。
 * @author hara
 *
 */
public class Table
{
    /** 捨てられたカードを保持しておくためのリスト */
    private ArrayList disposedCards_ = new ArrayList();

    /**
     * カードを捨てる。
     * @param card 捨てるカード
     */
    public void disposeCard(Card card)
    {
        System.out.println(card+"を捨てました");

        // 捨てられたカードはリストに追加して保持しておく。
        disposedCards_.add(card);
    }
    
    /**
     * 最後のカードを見る
     * @return　最後のカード
     */
    public Card topCard()
    {
    	int lastIndex= disposedCards_.size()-1;
    	return (Card) disposedCards_.get(lastIndex);
    }
}