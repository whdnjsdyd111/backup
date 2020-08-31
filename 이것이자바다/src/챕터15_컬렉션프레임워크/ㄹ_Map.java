package é��15_�÷��������ӿ�ũ;

public class ��_Map {
	// Map �÷����� Ű(key)�� ��(value)���� ������ Entry ��ü�� �����ϴ� ������ ������ �ִ�.
	// ���⼭ Ű�� ���� ��� ��ü�̴�. Ű�� �ߺ� ����� �� ������ ���� �ߺ� ����� �� �ִ�. ���� ������ ����� Ű�� ������ Ű�� ���� �����ϸ� ������ ���� �������� ���ο� ������ ��ġ�ȴ�.
	
	//	�� ����
	//		Map				Ű ��ü��
	//		�÷���			Ű		Ű		Ű		Map.Entry
	//						��		��		��		
	//						�� ��ü��
	
	// Map �÷��ǿ��� HashMap, Hashtable, LinkedHashMap, Properties, TreeMap ���� �ִ�.
	// ������ Map �÷��ǿ��� ���������� ��� ������ Map �������̽��� �޼ҵ���̴�. Ű�� ��ü���� �����ϱ� ������ Ű�� �Ű������� ���� �޼ҵ尡 ����.
	
	//	���		�޼ҵ�									����
	//	
	//	��ü �߰�	V put(K key, V value)					�־��� Ű�� ���� ����, ���ο� Ű�� ��� null�� �����ϰ� ������ Ű�� ���� ��� ���� ��ü�ϰ� ���� ���� ����
	//	
	//			boolean containsKey(Object key)			�־��� Ű�� �ִ��� ����
	//			boolean containsValue(Object value)		�־��� ���� �ִ��� ����
	//	��ü		Set<Map.Entry<K, V>> entrySet()			Ű�� ���� ������ ������ ��� Map.Entry ��ü�� Set�� ��Ƽ� ����
	//	�˻�		V get(Object key)						�־��� Ű�� �ִ� ���� ����
	//			boolean isEmpty()						�÷����� ��� �ִ��� ����
	//			Set<K> ketSet()							��� Ű�� Set ��ü�� ��Ƽ� ����
	//			int size()								����� Ű�� �� ���� ����	
	//			Collection<V> values()					����� ��� ���� Collection�� ��Ƽ� ����
	//
	//	��ü		void clear()							��� Map.Entry(Ű�� ��)�� ����
	//	����		V remove(Object key)					�־��� Ű�� ��ġ�ϴ� Map.Entry�� �����ϰ� ���� ����
	
	// �� ǥ���� �޼ҵ��� �Ű� ���� Ÿ�԰� ���� Ÿ�Կ� K�� V��� Ÿ�� �Ķ���Ͱ� �ִµ�, �̰��� Map �������̽��� ������ Ÿ���̱� �����̴�. �տ����� ����ߵ��� ��ü���� Ÿ���� ���� ��ü�� ������ �� �����ȴ�.
	// ��ü �߰��� put() �޼ҵ带 ����ϰ�, Ű�� ��ü�� ã�ƿ� �뿡�� get() �޼ҵ带 ����Ѵ�. �׸��� ��ü ������ remove() �޼ҵ带 ����Ѵ�.
	
	//	Map<String, Integer> map = ...;
	//	map.put("ȫ�浿", 30);			// ��ü �߰�
	//	int score = map.get("ȫ�浿");	// ��ü ã��
	//	map.remove("ȫ�浿");				// ��ü ����
	
	// Ű�� �˰� �ʹٸ� get() �޼ҵ�� �����ϰ� ��ü�� ã�ƿ��� ������, ����� ��ü ��ü�� ������� �ϳ��� ��� ���� ��쿡�� �� ���� ����� ����� �� �ִ�.
	// ù ��° keySet() �޼ҵ�� ��� Ű�� Set �÷������� ���� ����, �ݺ��ڸ� ���� Ű�� �ϳ��� ��� get() �޼ҵ带 ���� ���� ������ �ȴ�.
	
	//	Map<K, V> map = ...;
	//	Set<K> keySet = map.keySet();
	//	Iterator<K> keyIterator = keySet.iterator();
	//	while(keyIterator.hasNext()) {
	//		k key = keyIterator.next();
	//		v value = map.get(key);
	//	}
	
	// �� ��° ����� entrySet() �޼ҵ�� ��� Map.Entry�� Set �÷������� ���� ����, �ݺ��ڸ� ���� Map.Entry�� �ϳ��� ��� getKey()�� getValue() �޼ҵ带 �̿��� Ű�� ���� ������ �ȴ�.
	
	//	Set<Map.Entry<K, V>> entrySet = map.entrySet();
	//	Iterator<Map.Entry<K, V>> entryIterator = entrySet.iterator();
	//	while(entryIterator.hasNext()) {
	//		Map.Entry<K, V> entry = entryIterator.next();
	//		k key = entry.getKey();
	//		v value = entry.getValue();
	//	}
	
			//	HashMap
	
	// HashMap�� Map �������̽��� ������ ��ǥ���� Map �÷����̴�. HashMap�� Ű�� ����� ��ü�� hashCode()�� equals() �޼ҵ带 �������ؼ� ���� ��ü�� �� ������ ���ؾ� �Ѵ�.
	// ���� ��ü, �� ������ Ű�� �� ������ hashCode()�� ���ϰ��� ���ƾ� �ϰ�, equals() �޼ҵ尡 true�� �����ؾ� �Ѵ�.
	
	//						����						true
	//	hashCode() ���ϰ�		��		equals() ���ϰ�		��		���� Ű
	//		��	��						�� false
	//		��	������������������������������������������������ٸ� Ű
	
	// �ַ� Ű Ÿ���� String�� ���� ����ϴµ�, String�� ���ڿ��� ���� ��� ���� ��ü�� �� �� �ֵ��� hashCode()�� equals() �޼ҵ尡 ������ �Ǿ� �ִ�.
	// HashMap�� �����ϱ� ���ؼ��� Ű Ÿ�԰� �� Ÿ���� �Ķ���ͷ� �ְ� �⺻ �����ڸ� ȣ���ϸ� �ȴ�.
	
	//	Map<K, V> map = new HashMap<K, V>();
	//		Ű	��					Ű	��
	
	// Ű�� ���� Ÿ���� �⺻ Ÿ��(byte, short, int, float, double, boolean, char)�� ����� �� ���� Ŭ���� �� �������̽� Ÿ�Ը� �����ϴ�.
	// Ű�� String Ÿ���� ����ϰ� ������ Integer Ÿ���� ����ϴ� HashMap�� ������ ���� ������ �� �ִ�.
	
	//	Map<String, Integer> map = new HashMap<String, Integer>();
	
	// ���� ������ �̸��� Ű��, ������ ������ �����ϴ� HashMap ��� ����� �����ش�.
	
	// ���� ������ ����� ���� ��ü�� Student�� Ű���ϰ� ������ �����ϴ� HashMap ��� ����� �����ش�. 
	// �й��� �̸��� ������ Student�� ���� Ű�� �����ϱ� ���� Student Ŭ�������� hashCode()�� equals() �޼ҵ尡 �����ǵǾ� �ִ�.
	
			//	Hashtable
	
	// Hashtable�� HashMap�� ������ ���� ������ ������ �ִ�. Hashtable�� Ű�� ����� ��ü�� hashCode()�� equals() �޼ҵ带 �������ؼ� ���� ��ü�� �� ������ ���ؾ� �Ѵ�.
	// HashMap���� �������� Hashtable�� ����ȭ��(synchronized) �޼ҵ�� �����Ǿ� �ֱ� ������ ��Ƽ �����尡 ���ÿ� �� �޼ҵ���� ������ �� ����, �ϳ��� �����尡 ������ �Ϸ��ؾ߸� �ٸ� �����带 ������ �� �ִ�.
	// �׷��� ��Ƽ ������ ȯ�濡�� �����ϰ� ��ü�� �߰�, ������ �� �ִ�. �̰��� �����尡 ����(Thread Safe)�ϴٶ�� ���Ѵ�.
	
	//	HashtableMap
	//		Ű		Ű		...		Ű	<- ������1 o
	//		��		��		...		��	<- ������2 x
	
	// Hashtable�� ���� ����� HashMap�� ũ�� �ٸ��� �ʴ�. Ű Ÿ�԰� �� Ÿ���� �����ϰ� �⺻ �����ڸ� ȣ���ϸ� �ȴ�.
	
	//	Map<K, V> map = new Hashtable<K, V>();
	
	// Ű�� String Ÿ���� ����ϰ�, ������ Integer Ÿ���� ����ϴ� Hashtable�� ������ ���� ������ �� �ִ�.
	
	//	Map<String, Integer> map = new Hashtable<String, Integer>();
	
	// ���� ������ Ű����� ���̵�� ��й�ȣ�� �Է¹޾Ƽ�, Hashtable�� ����Ǿ� �ִ� Ű(���̵�)�� ��(��й�ȣ)���� ���� �� �α��� ���θ� ����ϴ� �����̴�.
	
			//	Properties
	
	// Properties�� Hashtable�� ���� Ŭ�����̱� ������ Hashtable�� ��� Ư¡�� �״�� ������ �ִ�. �������� Hashtable�� Ű�� ���� �پ��� Ÿ������ ������ �����ѵ� ���� 
	// Properties�� Ű�� ���� String Ÿ������ ������ �÷����̴�. 
	// Properties�� ���ø����̼��� �ɼ� ����, �����ͺ��̽� ���� ���� �׸��� ����ȭ(�ٱ���) ������ ����� ������Ƽ(~.properties) ������ ���� �� �ַ� ����Ѵ�.
	
	// ������Ƽ ������ Ű�� ���� = ��ȣ�� ����Ǿ� �ִ� �ؽ�Ʈ ���Ϸ� ISO 8859-1 ���ڼ����� ����ȴ�. �� ���������� ���� ǥ���� �� ���� �ѱ��� �����ڵ�(Unicode)�� ��ȯ�Ǿ� ����ȴ�.
	// ���� ��� ������ ���� country�� language Ű�� ���� "���ѹα�", "�ѱ�"�� �Է��ϸ� �ڵ����� �����ڵ�� ��ȯ�Ǿ� ����ȴ�.
	// ��Ŭ�������� �����ڵ�� ��ȯ�� ������ �ٽ� �ѱ۷� ������ ���콺�� �����ڵ� ���� �÷� ������ �ȴ�.
	
	//	country = ���ѹα�		��		country = \uB300\uBBFC\uAD6D
	//	language = �ѱ�				language = \uD55C\uAE00
	
	// ��Ŭ������ ������� �ʴ´ٸ�, �ѱ��� ���Ե� ������Ƽ ������ �ٸ� �����Ϳ��� �ۼ��ϰ� <JDK��ġ����>\bin\native2ascii.exe ���� �̿��ؼ� ISO 8859_1 ������ ������ �ȴ�.
	
	//	native2ascii.exe ����.properties ����.properties
	
	// ���� ������ �����ͺ��̽� ���� ������ �ִ� ������Ƽ ������ ������ �����ش�. diver, url, username, password�� Ű�� �ǰ� �� ���� ���ڿ��� ���� �ȴ�.
	
	// ������Ƽ ������ �б� ���ؼ��� Properties ��ü�� �����ϰ�, load() �޼ҵ带 ȣ���ϸ� �ȴ�. load() �޼ҵ�� ������Ƽ ���Ϸκ��� �����͸� �б� ���� FileReader ��ü�� �Ű������� �޴´�.
	
	//	Properties properties = new Properties();
	//	properties.load(new FileReader("C:\Users\PC\eclipse-workspace\�̰����ڹٴ�\bin\é��15_�÷��������ӿ�ũ\��4_database.properties"));
	
	// ������Ƽ ������ �Ϲ������� Ŭ���� ����(~.class)�� �Բ� ����ȴ�. Ŭ���� ������ �������� ��� ��θ� �̿��ؼ� ������Ƽ ������ ��θ� �������� Class�� getResource() �޼ҵ带 �̿��ϸ� �ȴ�.
	// getResource()�� �־��� ������ ��� ��θ� URL ��ü�� �����ϴµ�, URL�� getPath()�� ������ ���� ��θ� �����Ѵ�.
	// ������ Ŭ���� ���ϰ� ������ ��ġ�� �ִ� "database.properties" ������ �а� Properties ��ü�� �����ϴ� �ڵ��̴�.
	
	//	String path = Ŭ����.class.getResource(C:\Users\PC\eclipse-workspace\�̰����ڹٴ�\bin\é��15_�÷��������ӿ�ũ\��4_database.properties).getPath();
	//	path = URLDecoder.decode(path, "utf-8");		// ��ο� �ѱ��� ���� ��� �ѱ��� ����
	//	Properties properties = new Properties();
	//	properties.load(new FileReader(path));
	
	// ���� �ٸ� ��Ű���� ������Ƽ ������ ���� ��쿡�� ��� �����ڷ� "/"�� ����Ѵ�.
	// ���� ��� A.class�� com.mycompany ��Ű���� �ְ�, database.properties ������ com.mycompany.config ��Ű���� ���� ��� ������Ƽ ������ ���� ��δ� ������ ���� ���� �� �ִ�.
	
	//	String path = A.class.getResource("config/database.properties").getPath();
	
	// Properties ��ü���� �ش� Ű�� ���� �������� getProperty() �޼ҵ带 ����Ѵ�. ���� Properties�� Map �÷����̹Ƿ� get() �޼ҵ�� ���� ���� �� �ִ�.
	// �׷��� get() �޼ҵ�� ���� Object Ÿ������ �����ϹǷ� ���� Ÿ�� ��ȯ�ؼ� String�� ���� �ϱ� ������ �Ϲ������� getProperty() �޼ҵ带 ����Ѵ�.
	
	//	String value = properties.getProperty("key");
	
	// ������ database.properties ���Ϸκ��� ���� �о� ����ϴ� �����̴�.
}
