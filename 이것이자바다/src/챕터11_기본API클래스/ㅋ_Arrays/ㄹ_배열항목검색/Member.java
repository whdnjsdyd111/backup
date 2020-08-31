package 챕터11_기본API클래스.ㅋ_Arrays.ㄹ_배열항목검색;

// 기본 타입 또는 String 배열은 Arrays.sort() 메소드의 매개값으로 지정해주면 자동으로 오름차순 정렬이 된다.
// 사용자 정의 클래스 타입일 경우에는 클래스가 Comparable 인터페이스를 구현하고 있어야 정렬된다.
// Member 배열에서 Member 객체들을 name 필드값으로 정렬하고 싶다면 다음과 같이 Member 클래스를 작성하면 된다.

public class Member implements Comparable<Member>{
	String name;
	
	Member(String name){
		this.name = name;
	}
	
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
	
	// Comparable<Member>는 Member 타입만 비교하기 위해 제네릭 <>을 사용하였고, compareTo() 메소드는 비교값을 리턴하도록 오버라이딩했다.
	// compareTo() 메소드의 리턴값은 오름차순일 때 자신이 매개값보다 낮을 경우 음수, 같은 경우 0, 높을 경우 양수를 리턴하면 된다.
	// 반대로 내림차순일때 자신이 매개값보다 낮을 경우 양수, 같을 경우 0, 높을 경우 음수를 리턴하면 된다.
	// name 필드값으로 정렬한다고 했으니 유니코드로 비교해야 하므로 String의 compareTo() 리턴값을 사용했다.
}
