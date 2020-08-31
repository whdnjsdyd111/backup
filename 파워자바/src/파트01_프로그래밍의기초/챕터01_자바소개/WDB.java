package 파트01_프로그래밍의기초.챕터01_자바소개;

class Car {
	 public int speed;
	 public int mileage;
	 private String color;

	 public String getColor() {
	  return color;
	 }

	 public void setColor(String color) {
	  this.color = color;
	 }

	 private int getSpeed() {
	  int speed = -1;
	  return speed;
	 }

	 public int getMileage() {
	  return mileage;
	 }

	 public void print(int speed) {
	  int result = mileage * speed;
	  this.speed = speed + result;
	  return;
	 }

	}

	public class WDB {
	 public static void main(String[] args) {
	  int i = 200;      // 기초 변수의 선언
	  Car myCar = new Car();  // 참조 변수의 선언 , 객체의 생성후 대입(객체의 첫주소가  myCar에 대입)
	  Car yourCar; 
	  myCar.setColor("green");
	  myCar.mileage = 20;
	  myCar.speed = 10;
	  myCar.print(50);

	  yourCar = myCar;
	  System.out.println(i + "," + myCar.getMileage() + "," + yourCar.speed);
	  return;
	 }
	}  