package é��13_���׸�;

public class ��1_ChildProductAndStorageExample {
	public static void main(String[] args) {
		��1_ChildProduct<Tv, String, String> product = new ��1_ChildProduct<>();
		product.setKind(new Tv());
		product.setModel("SmartTv");
		product.setCompany("Samsung");
		
		��1_Storage<Tv> storage = new ��1_StorageImpl<Tv>(100);
		storage.add(new Tv(), 0);
		Tv tv = storage.get(0);
	}
}
