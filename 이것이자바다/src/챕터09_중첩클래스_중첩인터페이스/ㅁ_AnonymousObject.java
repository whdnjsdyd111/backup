package 챕터09_중첩클래스_중첩인터페이스;

public class ㅁ_AnonymousObject {
	// 익명(anonymous) 객체는 이름이 없는 객체를 말한다. 익명 객체는 단독으로 생성할 수 없고 클래스를 상속하거나 인터페이스를 구현해야만 생성할 수 있다.
	// 악명 객체는 필드의 초기값이나 로컬 변수의 초기값, 매개 변수의 매개값으로 주로 대입된다. UI 이벤트 처리 객체나 스레드 객체를 간편하게 생성할 목적으로 익명 객체가 많이 활용된다.
	
			// Creation Anonymous Child Object		익명 자식 객체 생성
	
	// 부모 타입으로 필드나 변수를 선언하고, 자식 객체를 초기값으로 대입할 경우를 생각해보자. 
	// 우선 부모 클래스를 상속해서 자식 클래스를 선언하고, new 연산자를 이용해서 자식 객체를 생성한 후, 필드나 로컬 변수에 대입하는 것이 기본이다.
	
	//	Class Child extends Parent { }		// 자식 클래스 선언
	//
	//	class A {
	//		Parent field = new Child();		// 필드에 자식 객체를 대입
	//		void method() {
	//			Parent localVar = new Child();	// 로컬 변수에 자식 객체를 대입
	//		}
	//	}
	
	// 그러나 자식 클래스가 재사용되지 않고, 오로지 해당 필드와 변수의 초기값으로만 사용할 경우라면 익명 자식 객체를 생성해서 초기값으로 대입하는 것이 좋은 방법이다.
	// 익명 자식 객체를 생성하는 방법은 다음과 같다. 주의할 점은 하나의 실행문이므로 끝에 세미콜론 을 반드시 붙여야 한다.
	
	//	부모클래스 [필드|변수] = new 부모클래스(매개값, ...) {
	//		// 필드
	//		// 메소드
	//	};
	
	// 부모클래스(매개값, ...) {}은 부모 클래스를 상속해서 중괄호{}와 같이 자식 클래스를 선언하라는 뜻이고, new 연산자는 이렇게 선언된 자식 클래스를 객체로 생성한다.
	// 부모클래스(메게값, ...)은 부모 생성자를 호출하는 코드로, 매개값은 부모 생성자의 매개 변수에 맞게 입력하면 된다. 중괄호 {} 내부에는 필드나 메소드를 선언하거나
	// 부모 클래스의 메소드를 재정의(오버라이딩)하는 내용이 온다. 일반 클래스와의 차이점은 생성자를 선언할 수 없다는 것이다.
	// 다음 코드는 필드를 선언할 때 초기값으로 익명 자식 객체를 생성해서 대입한다.
	
	//	class A {
	//		Parent field = new Parent() {
	//			int childField;
	//			void childMethod() {}
	//			@Override
	//			void parentMethod() {}
	//		};
	//	}
	
	// 다음 코드는 메소드 내에서 로컬 변수를 선언할 때 초기값으로 익명 자식 객체를 생성해서 대입한다.
	
	//	class A {
	//		void method() {
	//			Parent localVar = new Parent() {
	//				int childField;
	//				void childMethod() {}
	//				@Override
	//				void parentMethod() {}
	//			};
	//		}
	//	}
	
	// 매소드의 매개 변수가 부모 타입일 경우 메소드 호출 코드에서 익명 자식 객체를 생성해서 매개값으로 대입할 수도 있다.
	
	//	class A {
	//		void method1(Parent parent) {}
	//
	//		void method2() {
	//			method1(
	//				new Parent() {
	//					int childField1;
	//					void childMethod() {}
	//					@Override
	//					void parentMethod() {}
	//				}
	//			);
	//		}
	//	}
	
	// 익명 자식 객체에 새롭게 정의된 필드와 메소드는 익명 자식 객체 내부에서만 사용되고, 외부에서는 필드와 메소드에 접근할 수 없다.
	// 왜냐하면 익명 자식 객체는 부모 타입 변수에 대입되므로 부모 타입에 선언된 것만 사용할 수 있기 때문이다. 
	// 예를 들어 다음 코드에 필드 childField와 메소드 childMethod()는 메소드 내에서 사용이 가능하나, A 클래스의 필드인 field로는 접근할 수 없다.
	
	//	class A {
	//		Parent field = new Parent() {
	//			int childField;
	//			void method() {}
	//			@Override
	//			void parentMethod() {
	//				childField = 3;
	//				childMethod();
	//			}
	//		};
	//
	//		void method() {
	//			// field.childField = 3;	불가능
	//			// field.childMethod();		불가능
	//			field.parentMethod();		가능
	//		}
	//	}
	
	// 다음 예제를 살펴보자.
	
			// Creation Anonymous Implements Object
	
	// 이번에는 인터페이스 타입으로 필드나 변수를 선언하고, 구현 객체를 초기값으로 대입하는 경우를 생각해보자.
	// 우선 구현 클래스를 선언하고, new 연산자를 이용해서 구현 객체를 생성한 후, 필드나 로컬 변수에 대입하는 것이 기본이다.
	
	//	class TV implements RemoteControl {}
	//
	//	class A {
	//		RemoteControl field = new TV();				// 필드에 구현 객체를 대입
	//		void method() {
	//			RemoteControl localVar = new TV();		// 로컬 변수에 구현 객체를 대입
	//		}
	//	}
	
	// 그러나 구현 클래스가 재사용되지 않고, 오로지 해당 필드와 변수의 초기값으로만 사용하는 경우라면 익명 구현 객체를 초기값으로 대입하는 것이 좋다.
	// 익명 구현 객체를 생성하는 방법은 인터페이스에서 살펴보았지만 다시 한 번 살펴보자.
	
	//	인터페이스 [필드|변수] = new 인터페이스() {
	//		// 인터페이스에 선언된 추상 메소드의 실체 메소드 선언
	//		// 필드
	//		// 메소드
	//	};
	
	// 인터페이스() {}는 인터페이스를 구현해서 중괄호 {}와 같이 클래스를 선언하라는 뜻이고, new 연산자는 이렇게 선언된 클래스를 객체로 생성한다. 중괄호 {}에는 인터페이스에 선언된 모든 추상 메소드들의 실체 메소드를 작성해야한다.
	// 그렇지 않으면 컴파일 에러가 발생한다. 추가적으로 필드와 메소드를 선언할 수 있지만, 실체 메소드에서만 사용이 가능하고 외부에서는 사용하지 못한다.
	// 다음은 필드를 선언할 때 초기값으로 익명 구현 객체를 생성해서 대입하는 예이다.
	
	//	class A {
	//		RemoteControl field = new RemoteControl() {
	//			@Override
	//			void turnOn() {}
	//		};
	//	}
	
	// 다음은 메소드 내에서 로컬 변수를 선언할 때 초기값으로 익명 구현 객체를 생성해서 대입하는 예이다.
	
	//	void method() {
	//		RemoteControl localVar = new RemoteControl() {
	//			@Override
	//			void turnOn() {}
	//		};
	//	}
	
	// 메소드의 매개 변수가 인터페이스 타입일 경우, 메소드 호출 코드에서 익명 구현 객체를 생성해서 매개값으로 대입할 수도 있다.
	
	//	class A {
	//		void method1( RemoteControl rc) {}
	//
	//		void method2() {
	//			method1(
	//				new RemoteControl() {
	//					@Override
	//					void turnOn() {}
	//				}
	//			);
	//		}
	//	}
	
	// 그럼 이제 예제로 넘어가 보자.
	
	// 다음 예제는 UI 프로그램에서 흔히 사용되는 버튼의 클릭 이벤트 처리를 익명 구현 객체를 이용해서 처리하는 방법을 보여준다.
	
	// Button 클래스의 내용을 보면 중첩 인터페이스(OnClickListener) 타입으로 필드(listener)를 선언하고 Setter 메소드(setOnClickListener())로 외부에서 구현 객체를 받아 필드에 대입한다.
	// 버튼 이벤트가 발생했을 때(touch()) 메소드가 실행되었을 때) 인터페이스를 통해 구현 객체의 메소드를 호출(listener.onClick())한다.
	// 다음 Window 클래스는 두 개의 Button 객체를 가지고 있는 윈도우 창을 만드는 클래스라고 가정하자.
	// 첫 번째 button1의 클릭 이벤트 처리는 필드로 선언한 익명 객체가 담당하고, 두 번째 button2의 클릭 이벤트 처리는 setOnClickListener()를 호출할 때 매개값으로 준 익명 구혀 ㄴ객체가 담당하도록 했다.
	
			//	Using Local Variable Of Anonymous Object	익명 객체의 로컬 변수 사용
	
	// 익명 객체 내부에서는 바깥 클래스의 필드나 메소드는 제한 없이 사용할 수 있다. 문제는 메소드의 매개 변수나 로컬 변수를 익명 객체에서 사용할 때이다.
	// 메소드 내에서 생성된 익명 객체는 메소드 실행이 끝나도 힙 메모리에 존재해서 계속 사용할 수 있다. 매개 변수나 로컬 변수는 메소드 실행이 끝나면 스택 메모리에서 사라지기 때문에 익명 객체에서 사용할 수 없게 되므로 문제가 발생한다.
	// 이 문제에 대한 해결 방법은 9.3.3 로컬 클래스에서 사용 제한에서 설명한 바가 있다. 로컬 클래스와 익명 클래스와의 차이점은 클래스 이름의 존재 여부만 다를 뿐 동작 방식은 동일하다.
	// 익명 객체 내부에서 메소드의 매개 변수나 로컬 변수를 사용할 경우, 이 변수들은 final 특성을 가져야 한다.
	// 자바 7 이전까지는 반드시 final 키워드로 이 변수들을 선언해야 했지만, 자바 8 이후부터는 final 키워드 없이 선언해도 좋다.
	// final 선언을 하지 않아도 여전히 값을 수저알 수 없는 final 특성을 갖기 때문이다. 컴파일 시 final 키워드가 있다면 메소드 내부에 지역 변수로 복사되지만, final 키워드가 없다면 익명 클래스의 필드로 복사된다.
	
	//	void outMethod( final int arg1, int arg2 ) {			인터페이스 변수 = new 인터페이스() {
	//																int arg2 = 매개값;
	//		final int var1 = 1;										int var2 = 2;		// 필드로 복사
	//		int var2 = 2;										
	//														→		void method() {
	//		인터페이스 변수 = new 인터페이스() {									int arg1 = 매개값;
	//			void method() {											int var1 = 1;		// 로컬 변수로 복사
	//				int result = arg1 + arg2 + var1 + var2;		
	//			}														int result = arg1 + arg2 + var1 + var2;
	//		};														}
	//	}														};
	
	// 우리는 익명 클래스의 내부 복사 위치에 신경 쓸 필요 없이 익명 객체에서 사용된 매개 변수와 로컬 변수는 모두 final 특성을 갖는다는 것만 알면 된다.
	// 다음 예제는 매개 변수와 로컬 변수가 익명 객체에서 사용할 때 fianl 특성을 갖고 있음을 잘 보여준다. 자바 7 에서는 반드시 final 키워드를 붙여야 되지만, 자바 8 부터는 붙이지 않아도 final 특성을 가지고 있음을 주목해야 한다.
}			
