package 챕터13_제네릭;

import java.util.Arrays;

public class ㅂ2_WildCardExample {
	
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
	
	public static void registerCourse( ㅂ1_Course<?> course ) {
		System.out.println(course.getName() + " 수강생 : " +
				Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent( ㅂ1_Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker( ㅂ1_Course<? super Worker> course ) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		ㅂ2_WildCardExample wildCard = new ㅂ2_WildCardExample();
		
		ㅂ1_Course<Person> personCourse = new ㅂ1_Course<Person>("일반인과정", 5);
		personCourse.add(wildCard.new Person("일반인"));
		personCourse.add(wildCard.new Worker("직장인"));
		personCourse.add(wildCard.new Student("학생"));
		personCourse.add(wildCard.new HighStudent("고등학생"));
		
		ㅂ1_Course<Student> studentCourse = new ㅂ1_Course<Student>("학생과정", 5);
		studentCourse.add(wildCard.new Student("학생"));
		studentCourse.add(wildCard.new HighStudent("고등학생"));
		
		ㅂ1_Course<Worker> workerCourse = new ㅂ1_Course<Worker>("직장인과정", 5);
		workerCourse.add(wildCard.new Worker("직장인"));
		
		ㅂ1_Course<HighStudent> highStudent = new ㅂ1_Course<HighStudent>("고등학생과정", 5);
		highStudent.add(wildCard.new HighStudent("고등학생"));
		
		registerCourse(personCourse);
		registerCourse(studentCourse);
		registerCourse(workerCourse);
		registerCourse(highStudent);		// 모두 가능
		
		System.out.println();

		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudent);	// Student를 포함하여 Student의 하위 클래스들만 가능
		
		System.out.println();
		
		registerCourseWorker(workerCourse);
		registerCourseWorker(personCourse);	// Worker를 포함하여 Worker의 상위 클래스만 가능
	}
}
