package é��11_�⺻APIŬ����.��_SystemŬ����.��_�����������gc;

public class Gc��� {
	public static void main(String[] args) {
		Employee emp;
		
		emp = new Employee(1); // �� ��ü��
		emp = null;
		emp = new Employee(2); // �� ��ü�� �����Ⱑ ��
		emp = new Employee(3);
		
		System.out.print("emp�� ���������� �����ϴ� �����ȣ: ");
		System.out.println(emp.eno);
		System.gc();
	}
}
	
class Employee{
	public int eno;
	
	public Employee(int eno) {
		this.eno = eno;
		System.out.println("Employee(" + eno + ") �� �޸𸮿� ������");
	}

	public void finalize() {
		System.out.println("Employee(" + eno + ") �� �޸𸮿��� ���ŵ�");
	}
}
