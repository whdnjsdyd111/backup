package 챕터16_스트림_병렬처리;

import java.util.ArrayList;
import java.util.List;

public class ㅋ2_MaleStudent {
	private List<ㅋ1_Student> list;
	
	public ㅋ2_MaleStudent() {
		list = new ArrayList<ㅋ1_Student>();
		System.out.println("[ " + Thread.currentThread().getName() + " ] MaleStudent()");
	}
	
	public void accumulate(ㅋ1_Student student) {
		list.add(student);
		System.out.println("[ " + Thread.currentThread().getName() + " ] accumulate()");
	}
	
	public void combine(ㅋ2_MaleStudent other) {
		list.addAll(other.getList());
		System.out.println("[ " + Thread.currentThread().getName() + " ] combine()");
	}
	
	public List<ㅋ1_Student> getList() { return list; }
}
