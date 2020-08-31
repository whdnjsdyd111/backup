package é��13_���׸�;

import java.util.Arrays;

public class ��2_WildCardExample {
	
	class Person{
		private String name;
		
		public Person(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}
	class Worker extends Person{

		public Worker(String name) {
			super(name);
		}}
	class Student extends Person{

		public Student(String name) {
			super(name);
		}}
	class HighStudent extends Student{

		public HighStudent(String name) {
			super(name);
		}}
	
	public static void registerCourse( ��1_Course<?> course ) {
		System.out.println(course.getName() + " ������ : " +
				Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent( ��1_Course<? extends Student> course) {
		System.out.println(course.getName() + " ������: " + 
				Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker( ��1_Course<? super Worker> course ) {
		System.out.println(course.getName() + " ������: " + 
				Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		��2_WildCardExample wildCard = new ��2_WildCardExample();
		
		��1_Course<Person> personCourse = new ��1_Course<Person>("�Ϲ��ΰ���", 5);
		personCourse.add(wildCard.new Person("�Ϲ���"));
		personCourse.add(wildCard.new Worker("������"));
		personCourse.add(wildCard.new Student("�л�"));
		personCourse.add(wildCard.new HighStudent("����л�"));
		
		��1_Course<Student> studentCourse = new ��1_Course<Student>("�л�����", 5);
		studentCourse.add(wildCard.new Student("�л�"));
		studentCourse.add(wildCard.new HighStudent("����л�"));
		
		��1_Course<Worker> workerCourse = new ��1_Course<Worker>("�����ΰ���", 5);
		workerCourse.add(wildCard.new Worker("������"));
		
		��1_Course<HighStudent> highStudent = new ��1_Course<HighStudent>("����л�����", 5);
		highStudent.add(wildCard.new HighStudent("����л�"));
		
		registerCourse(personCourse);
		registerCourse(studentCourse);
		registerCourse(workerCourse);
		registerCourse(highStudent);		// ��� ����
		
		System.out.println();

		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudent);	// Student�� �����Ͽ� Student�� ���� Ŭ�����鸸 ����
		
		System.out.println();
		
		registerCourseWorker(workerCourse);
		registerCourseWorker(personCourse);	// Worker�� �����Ͽ� Worker�� ���� Ŭ������ ����
	}
}
