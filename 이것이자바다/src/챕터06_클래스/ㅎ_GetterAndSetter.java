package 챕터06_클래스;

/**
 * @author PC
 *
 */
public class ㅎ_GetterAndSetter {
	// 일반적으로 객체 지향 프로그래밍에서 객체의 데이터는 객체 외부에서 직접적으로 접근하는 것을 막는다.
	// 그 이유는 객체의 데이터를 외부에서 마음대로 읽고 변경할 경우 객체의 무결성이 깨어질 수 있기 때문이다.
	// 예를 들어 자동차의 속도는 음수가 될 수 없는데, 외부에서 음수로 변경하면 객체의 무결성이 깨진다.
	// 이러한 문제점을 해결하기 위해 객체 지향 프로그래밍에서는 메소드를 통해서 데이터를 변경하는 방법을 선호한다.
	// 데이터는 외부에서 접근할 수 없도록 막고 메소드는 공개해서 외부에서 메소드를 통해 데이터에 접근하도록 유도한다.
	// 그 이유는 매개값을 검증해서 유효한 값만 데이터로 저장할 수 있기 때문이다. 이러한 역할을 하는 메소드가 Setter이다. 
	// 예를 들어 자동차의 속도를 setSpeed() 메소드로 변경할 경우 다음과 같이 검증 코드를 작성할 수 있다.
	
	//	void setSpeed(double speed) {
	//		if(speed > 0) {
	//			this.speed = 0;
	//			return;
	//		} else {
	//			this.speed = speed
	//		}
	//	}
	
	// 외부에서 객체의 데이터를 읽을 때도 메소드를 사용하는 것이 좋다. 객체 외부에서 객체의 필드값을 사용하기 부적절한 경우도 있다.
	// 이런 경우에는 메소드로 필드값을 가공한 후 외부로 전달하면 된다. 이런 메소드가 Getter이다. 
	// 예를 들어 자동차의 속도를 마일에서 KM 단위로 환산해서 외부로 리턴해주는 getSpeed() 메소드를 다음과 같이 작성할 수 있다.
	
	//	double getSpeed() {
	//		double km = speed * 1.6;
	//		return km;
	//	}
	
	// 클래스를 선언할 때 가능하다면 필드를 private로 선언해서 외부로부터 보호하고, 필드에 대한 Setter와 Getter 메소드를 작성해서 필드값을 안전하게 변경/사용하는 것이 좋다.
	// 다음은 Setter와 Getter 메소드를 선언하는 방법을 보여준다. 검증 코드나 변환 코드는 필요에 따라 추가해야한다.
	
	//	private 타입 fieldName;		// 필드 접근 제한자 private
	//	
	//	// Getter
	//	public 리턴 타입 getFieldName() {
	//		return fieldName;
	//	}
	//
	//	// Setter
	//	public void setFieldName(타입 fieldName) {
	//		this.fieldName = fieldName;	
	//	}
	
	// 필드 타입이 boolean일 경우에는 Getter는 get으로 시작하지 않고 is로 시작하는 것이 관례이다.
	
	//	private boolean stop;
	//
	//	// Getter
	//	public boolean isStop() {
	//		return stop;
	//	}
	//
	//	// Setter
	//	public boolean setStop(boolean stop){
	//		this.stop = stop;
	//	}
	
	// 만약 외부에서 필드값을 읽을 수 만 있고 변경하지 못하도록 하려면(읽기 전용) Getter 메소드만 선언해도 좋고, 아니면 Setter 메소드를 private 접근 제한을 갖도록 선언해도 좋다.
	// 이클립스는 클래스에 선언된 필드에 대해 자동적으로 Getter와 Setter 메소드를 생성시키는 기능이 있다.
	// 필드를 선언한 후 메뉴에서 [Source > Generate Getters and Setters] 를 선택하면 된다.
	// 다음 예제 Car을 살펴보자.
	
	
}
