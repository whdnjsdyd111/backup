package ��Ʈ01_���α׷����Ǳ���.é��01_�ڹټҰ�;

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
	  int i = 200;      // ���� ������ ����
	  Car myCar = new Car();  // ���� ������ ���� , ��ü�� ������ ����(��ü�� ù�ּҰ�  myCar�� ����)
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