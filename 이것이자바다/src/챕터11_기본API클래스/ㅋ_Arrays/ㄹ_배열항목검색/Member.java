package é��11_�⺻APIŬ����.��_Arrays.��_�迭�׸�˻�;

// �⺻ Ÿ�� �Ǵ� String �迭�� Arrays.sort() �޼ҵ��� �Ű������� �������ָ� �ڵ����� �������� ������ �ȴ�.
// ����� ���� Ŭ���� Ÿ���� ��쿡�� Ŭ������ Comparable �������̽��� �����ϰ� �־�� ���ĵȴ�.
// Member �迭���� Member ��ü���� name �ʵ尪���� �����ϰ� �ʹٸ� ������ ���� Member Ŭ������ �ۼ��ϸ� �ȴ�.

public class Member implements Comparable<Member>{
	String name;
	
	Member(String name){
		this.name = name;
	}
	
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
	
	// Comparable<Member>�� Member Ÿ�Ը� ���ϱ� ���� ���׸� <>�� ����Ͽ���, compareTo() �޼ҵ�� �񱳰��� �����ϵ��� �������̵��ߴ�.
	// compareTo() �޼ҵ��� ���ϰ��� ���������� �� �ڽ��� �Ű������� ���� ��� ����, ���� ��� 0, ���� ��� ����� �����ϸ� �ȴ�.
	// �ݴ�� ���������϶� �ڽ��� �Ű������� ���� ��� ���, ���� ��� 0, ���� ��� ������ �����ϸ� �ȴ�.
	// name �ʵ尪���� �����Ѵٰ� ������ �����ڵ�� ���ؾ� �ϹǷ� String�� compareTo() ���ϰ��� ����ߴ�.
}
