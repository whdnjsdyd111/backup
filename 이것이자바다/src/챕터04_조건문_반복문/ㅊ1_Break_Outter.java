package 챕터04_조건문_반복문;

public class ㅊ1_Break_Outter {
	public static void main(String[] args) {
		
		A : for(char bigLetter = 'A'; bigLetter <= 'Z'; bigLetter++) {
			for(char smallLetter = 'a'; smallLetter <= 'g'; smallLetter++) {
				
				if(bigLetter == 'C')
					break A;
				
				System.out.println(bigLetter + " - " + smallLetter);
			}
		}
	}
}
