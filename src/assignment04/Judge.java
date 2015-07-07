package assignment04;

import assignment04.Player.Hand;

public class Judge {

	/**
	 * じゃんけんを開始する
	 */
	void startJanken(Player player1, Player player2){
		
		// じゃんけんスタートの掛け声
		System.out.println("【じゃんけん開始】");
		System.out.println("〜〜会話始まり〜〜");
		System.out.println(player1.getName()+"："+"「"+player1.startWord()+"」");
		System.out.println(player2.getName()+"："+"「"+player2.startWord()+"」");
		System.out.println("〜〜会話終わり〜〜");
		System.out.print("\n");
		
		// ３回勝負
		for (int i = 1; i <= 3; i++) {
			System.out.println("【"+i+"回戦目】");
			judgeJanken(player1, player2);
		}
		judgeFinalWinner(player1, player2);
	}
	/**
	 * 勝敗を判定する
	 * @param player1
	 * @param player2
	 */
	public void judgeJanken(Player player1, Player player2){

		// プレイヤーのが出す手を決定する
		Hand player1Hand	= player1.showHand();
		Hand player2Hand	= player2.showHand();
		
		// それぞれの手を表示する
		printHand(player1Hand);
		System.out.print(" vs ");
		printHand(player2Hand);
		System.out.print("\n");

		// プレイヤー１が勝つ場合
		if ((player1Hand == Hand.STONE && player2Hand == Hand.SCISSORS)
				|| (player1Hand == Hand.SCISSORS && player2Hand == Hand.PAPER)
				|| (player1Hand == Hand.PAPER && player2Hand == Hand.STONE)) {
			System.out.println(player1.getName()+"が勝ちました！");
			System.out.println("〜〜会話始まり〜〜");
			System.out.println(player1.getName()+"："+"「"+player1.winWord()+"」");
			System.out.println("〜〜会話終わり〜〜");
			System.out.print("\n");
			// プレイヤー１の勝ち数に１加える
			player1.notifyResult();
		}
		// プレイヤー２が勝つ場合
		else if ((player1Hand == Hand.STONE && player2Hand == Hand.PAPER)
				|| (player1Hand == Hand.SCISSORS && player2Hand == Hand.STONE)
				|| (player1Hand == Hand.PAPER && player2Hand == Hand.SCISSORS)) {
			System.out.println(player2.getName()+"が勝ちました！");
			System.out.println("〜〜会話始まり〜〜");
			System.out.println(player2.getName()+"："+"「"+player2.winWord()+"」");
			System.out.println("〜〜会話終わり〜〜");
			System.out.print("\n");
			player2.notifyResult();
		}
		// 引き分けの場合
		else {
			System.out.println("引き分けです！");
			System.out.println("〜〜会話始まり〜〜");
			System.out.println(player1.getName()+"："+"「"+player1.drawWord()+"」");
			System.out.println(player2.getName()+"："+"「"+player2.drawWord()+"」");
			System.out.println("〜〜会話終わり〜〜");
			System.out.print("\n");
		}
	}
	/**
	 * 最終的な勝者を決定する
	 * @param player1
	 * @param player2
	 * @return player（勝ち数が同じ場合はnull）
	 */
	public void judgeFinalWinner(Player player1, Player player2){
		// じゃんけん終わりの掛け声
		System.out.println("【じゃんけん終了】");
		
		// プレイヤー１の勝ち数が多い時
		if (player1.getWinCount() > player2.getWinCount())
		{
			System.out.println(player1.getWinCount()+" 対 "+player2.getWinCount()+"で"+player1.getName()+"の勝ちです！");
			System.out.println("〜〜会話始まり〜〜");
			System.out.println(player1.getName()+"："+"「"+player1.winWord()+"」");
			System.out.println("〜〜会話終わり〜〜");
		}
		// プレイヤー２の勝ち数が多い時
		else if (player1.getWinCount() < player2.getWinCount())
		{
			System.out.println(player1.getWinCount()+" 対 "+player2.getWinCount()+"で"+player2.getName()+"の勝ちです！");
			System.out.println("〜〜会話始まり〜〜");
			System.out.println(player2.getName()+"："+"「"+player2.winWord()+"」");
			System.out.println("〜〜会話終わり〜〜");
		}
		// プレイヤー１と２の勝ち数が同じ時
		else
		{
			System.out.println(player1.getWinCount()+" 対 "+player2.getWinCount()+"で引き分けです！");
			System.out.println("〜〜会話始まり〜〜");
			System.out.println(player1.getName()+"："+"「"+player1.drawWord()+"」");
			System.out.println(player2.getName()+"："+"「"+player2.drawWord()+"」");
			System.out.println("〜〜会話終わり〜〜");
		}
	}	
	/**
	 * 出す手を表示する
	 * @param hand
	 */
	void printHand(Hand hand){
		switch (hand) {
		case STONE:
			System.out.print("グー");
			break;
		case SCISSORS:
			System.out.print("チョキ");
			break;
		case PAPER:
			System.out.print("パー");
			break;
		default:
			break;
		}
	}
}
