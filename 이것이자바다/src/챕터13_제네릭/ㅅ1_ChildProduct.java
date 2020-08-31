package 챕터13_제네릭;

public class ㅅ1_ChildProduct<T, M, C> extends ㅅ1_Product<T, M> {
	private C company;
	
	public C getCompany() { return this.company; }
	public void setCompany(C company) { this.company = company; }
}
