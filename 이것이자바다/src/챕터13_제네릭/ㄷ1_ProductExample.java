package é��13_���׸�;

public class ��1_ProductExample {
	public static void main(String[] args) {
		��1_ProductExample Product = new ��1_ProductExample();
		
		��1_Product<Tv, String> product1 = new ��1_Product<Tv, String>();
		product1.setKind(Product.new Tv());
		product1.setModel("����ƮTv");
		Tv tv = product1.getkind();
		String tvModel = product1.getModel();
		
		��1_Product<Car, String> product2 = new ��1_Product<Car, String>();
		product2.setKind(Product.new Car());
		product2.setModel("����");
		Car car = product2.getkind();
		String carModel = product2.getModel();
		
	}
	
	public class Tv{
		
	}
	
	public class Car{
		
	}
}


