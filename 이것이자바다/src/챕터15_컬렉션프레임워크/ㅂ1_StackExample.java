package é��15_�÷��������ӿ�ũ;

import java.util.Stack;

public class ��1_StackExample {
	public static void main(String[] args) {
		Stack<��1_Coin> coinBox = new Stack<��1_Coin>();
		
		coinBox.push(new ��1_Coin(100));		// ������ ����
		coinBox.push(new ��1_Coin(50));
		coinBox.push(new ��1_Coin(500));
		coinBox.push(new ��1_Coin(10));
		
		while(!coinBox.isEmpty()) {
			��1_Coin coin = coinBox.pop();
			System.out.println("���� ����: " + coin.getValue());
		}
	}
}
