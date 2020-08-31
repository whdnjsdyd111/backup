package 챕터11_기본API클래스.ㅁ_System클래스.ㄴ_쓰레기수집기gc;

public class Gc사용 {
	public static void main(String[] args) {
		Employee emp;
		
		emp = new Employee(1); // 이 객체와
		emp = null;
		emp = new Employee(2); // 이 객체는 쓰레기가 됨
		emp = new Employee(3);
		
		System.out.print("emp가 최종적으로 참조하는 사원번호: ");
		System.out.println(emp.eno);
		System.gc();
	}
}
	
class Employee{
	public int eno;
	
	public Employee(int eno) {
		this.eno = eno;
		System.out.println("Employee(" + eno + ") 가 메모리에 생성됨");
	}

	public void finalize() {
		System.out.println("Employee(" + eno + ") 가 메모리에서 제거됨");
	}
}
