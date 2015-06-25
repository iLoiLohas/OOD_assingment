package assignment02;

import assignment02.Player.Hand;

public class Test_Player {
	public static void main(String[] args) {
		
		Player player	= new Player("プレイヤー");
		Test_Player test_Player	= new Test_Player();
		int testNum	= 100;
		
		// テストの実行
		test_Player.test_showHand(player, testNum);
		
		test_Player.test_notifyResult(player, testNum);
		test_Player.test_getWinCount(player, testNum);
	}
	/**
	 * showHandのテスト
	 * @param player
	 * @param testNum
	 */
	public void test_showHand(Player player, int testNum) {
		
		Hand testHand	= null;
		// テスト結果を表すフラグ（true : 成功，false : 失敗） 
		boolean testPassFlg	= false;
		
		for (int i = 0; i < testNum; i++) {
			testHand	= player.showHand();
			
			if (testHand != Hand.STONE && testHand != Hand.PAPER && testHand != Hand.SCISSORS) {
				System.out.println("テストが失敗しました．");
				System.out.println("Player.showHand()の返り値："+testHand);
			} else {
				testPassFlg	= true;
			}
		}
		if (testPassFlg == true) {
			System.out.println("Player.showHand()のテストは成功しました．");
		}
	}
	/**
	 * notifyResultのテスト
	 * @param player
	 * @param testNum
	 */
	public void test_notifyResult(Player player, int testNum) {
		
		for (int i = 0; i < testNum; i++) {
			player.notifyResult();
		}
		System.out.println("Player.notifyResult()のテストを実行．");
	}
	/**
	 * getWinCountのテスト
	 * @param player
	 * @param testNum
	 */
	public void test_getWinCount(Player player, int testNum) {
		
		int testWinCount	= player.getWinCount();
		boolean testPassFlg	= false;
		
		if (testWinCount != testNum) {
			System.out.println("テストが失敗しました．");
			System.out.println("Player.getWinCount()の返り値："+testWinCount);
		} else {
			testPassFlg	= true;
		}
		if (testPassFlg == true) {
			System.out.println("Player.getWinCount()のテストは成功しました．");
		}
	}
}
