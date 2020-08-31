package 矇攪13_薯啻葛;

public class 之1_ProductExample {
	public static void main(String[] args) {
		之1_ProductExample Product = new 之1_ProductExample();
		
		之1_Product<Tv, String> product1 = new 之1_Product<Tv, String>();
		product1.setKind(Product.new Tv());
		product1.setModel("蝶葆おTv");
		Tv tv = product1.getkind();
		String tvModel = product1.getModel();
		
		之1_Product<Car, String> product2 = new 之1_Product<Car, String>();
		product2.setKind(Product.new Car());
		product2.setModel("蛤薨");
		Car car = product2.getkind();
		String carModel = product2.getModel();
		
	}
	
	public class Tv{
		
	}
	
	public class Car{
		
	}
}


