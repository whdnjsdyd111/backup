package é��16_��Ʈ��_����ó��;

import java.util.ArrayList;
import java.util.List;

public class ��2_MaleStudent {
	private List<��1_Student> list;
	
	public ��2_MaleStudent() {
		list = new ArrayList<��1_Student>();
		System.out.println("[ " + Thread.currentThread().getName() + " ] MaleStudent()");
	}
	
	public void accumulate(��1_Student student) {
		list.add(student);
		System.out.println("[ " + Thread.currentThread().getName() + " ] accumulate()");
	}
	
	public void combine(��2_MaleStudent other) {
		list.addAll(other.getList());
		System.out.println("[ " + Thread.currentThread().getName() + " ] combine()");
	}
	
	public List<��1_Student> getList() { return list; }
}
