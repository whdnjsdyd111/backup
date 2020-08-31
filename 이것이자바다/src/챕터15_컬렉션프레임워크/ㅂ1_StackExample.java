package 챕터15_컬렉션프레임워크;

import java.util.Stack;

public class ㅂ1_StackExample {
	public static void main(String[] args) {
		Stack<ㅂ1_Coin> coinBox = new Stack<ㅂ1_Coin>();
		
		coinBox.push(new ㅂ1_Coin(100));		// 동전을 넣음
		coinBox.push(new ㅂ1_Coin(50));
		coinBox.push(new ㅂ1_Coin(500));
		coinBox.push(new ㅂ1_Coin(10));
		
		while(!coinBox.isEmpty()) {
			ㅂ1_Coin coin = coinBox.pop();
			System.out.println("꺼낸 동전: " + coin.getValue());
		}
	}
}
