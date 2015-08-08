package assignment07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * PageOneの手札で出すカードを手で入力するクラス
 * Handクラスの拡張
 */
public class AskHand extends Hand
{
    /**
     * 出すカードを手で入力する
     * 同じ数またはスートならば出すことができる
     * 同じカードがなくてパスの場合は null を返します。
     * 
     * @return 同じ数のカード
     */
    public Card findSameCard(Card tableCard)
    {

		//キーボードから入力するときの決まりごと
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));

		//選択された番号を記憶する変数
		int p;
		
		while(true){
			System.out.print("場に出すカードの位置を指定してください．(0=pass)? ");
			
			//文字の読み取りはエラーが起こる可能性があるのでtryで囲む必要がある
			try {
				// 入力文字列を受け取る　上で宣言したbrを使う
				String inputStr = br.readLine();
				// 入力文字列を整数値に変換する。
				p = Integer.parseInt(inputStr);
			}
			//エラーが発生した時は，ここにジャンプして来るtry...catchの仕組み
			catch(Exception e)
			{
				System.out.print("数字を入力してください");
				continue;
			}

			//パス以外の場合
			if (p!=0)
			{
				//有効な数字の範囲か？
				if (p<0 || p>this.getNumberOfCards())
				{
					System.out.println("範囲外です！");
					continue;
				}
				//指定された位置のカードを見る
				Card c = (Card) hand_.get(p-1);
				//出せるカード（スートor数字が同じ）か？
				if ( c.isSame(tableCard) )
					return (Card) hand_.remove(p-1);
				else
					System.out.println("そのカードは出せません");
			}
			//パスの処理
			else
				return null;
		} 
    	   	
    }

    /**
	 * PageOneのAskHandとCardのテストのためのメインルーチン
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
		hand.addCard(new Card(Card.SUIT_DIAMOND   , 3));

		// 手を表示する．
		System.out.println("Hand : " + hand);

		// シャッフルする．
		hand.shuffle();

		// テーブルに出ているカードを生成
		Card tableCard = new Card(Card.SUIT_CLUB, 3);

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
			System.out.println("Dasu : " + aCard);

			// 出したカードがテーブルにある
			tableCard = aCard;

		}
		//終了の表示
		System.out.println("Shuryou!");

	}
    
    
}