package assignment05;

import assignment05.Player.Hand;

/**
 * RandomTactics.java
 * @author 15M39241　西坂 直登
 *
 */
public class RandomTactics implements Tactics {
	public Hand readTactics(){
		// ジャンケンの手を決めるのに使用する乱数
		double randomNum = 0;		
		// プレイヤーが出す手
		Hand playerHand	= null;
		
		// 手をランダムに決める
		randomNum	= Math.random() * 3;
		if (randomNum < 1)
		{
			playerHand = Hand.STONE;
		}
		else if (randomNum < 2)
		{
			playerHand = Hand.SCISSORS;
		}
		else if (randomNum < 3)
		{
			playerHand = Hand.PAPER;
		}
		return playerHand;
	}
}
