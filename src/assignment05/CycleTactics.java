package assignment05;

import assignment05.Player.Hand;

/**
 * CycleTactics.java
 * @author 15M39241　西坂 直登
 *
 */
public class CycleTactics implements Tactics {
    // 最後に出した手(未開始:パー)
    Hand lastHand = Hand.PAPER;
    
    // 手を順番に出す（グー→チョキ→パー）
	public Hand readTactics()
	{
		if (lastHand == Hand.STONE) {
			lastHand	= Hand.SCISSORS;
		} else if (lastHand == Hand.SCISSORS) {
			lastHand	= Hand.PAPER;
		} else {
			lastHand	= Hand.STONE;
		}
		// 次の手を出す
		return lastHand;
	}
}
