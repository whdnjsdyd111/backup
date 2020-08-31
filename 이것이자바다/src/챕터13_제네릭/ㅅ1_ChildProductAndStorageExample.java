package 矇攪13_薯啻葛;

public class 今1_ChildProductAndStorageExample {
	public static void main(String[] args) {
		今1_ChildProduct<Tv, String, String> product = new 今1_ChildProduct<>();
		product.setKind(new Tv());
		product.setModel("SmartTv");
		product.setCompany("Samsung");
		
		今1_Storage<Tv> storage = new 今1_StorageImpl<Tv>(100);
		storage.add(new Tv(), 0);
		Tv tv = storage.get(0);
	}
}
