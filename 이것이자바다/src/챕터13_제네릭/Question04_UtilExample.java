package é��13_���׸�;

public class Question04_UtilExample {
	public static void main(String[] args) {
		Question04_Pair<String, Integer> pair = new Question04_Pair<String, Integer>("ȫ�浿", 35);
		Integer age = Question04_Util.getvalue(pair, "ȫ�浿");				// ��ġ
		System.out.println(age);
		
		Question04_ChildPair<String, Integer> childPair = new Question04_ChildPair<String, Integer>("ȫ���", 20);
		Integer childAge = Question04_Util.getvalue(childPair, "ȫ���");		// ��ġ���� ����
		System.out.println(childAge);
		
		/*
		Question04_OtherPair<String, Integer> otherPair = new Question04_OtherPair<String, Integer>("ȫ���", 20);
		Integer otherAge = Question04_Util.getvalue(otherPair, "ȫ���");
		System.out.println(otherAge);*/
		
		// OtherPair�� Pair�� ������� �����Ƿ� ���ܰ� �߻�
	}
}
