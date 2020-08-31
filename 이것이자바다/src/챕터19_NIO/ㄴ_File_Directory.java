package é��19_NIO;

public class ��_File_Directory {
	// IO�� ������ �Ӽ� ������ �б� ���� File Ŭ������ ����������, NIO�� �� �� �پ��� ������ �Ӽ� ������ �������ִ� Ŭ������ �������̽���
	// java.nio.file, java.nio.file.attribute ��Ű������ �����ϰ� �ִ�.
	
			//	Path
	
	// NIO���� ���� ���� ������� �� API�� java.nio.file.Path �������̽��̴�. Path�� IO�� java.io.File Ŭ������ �����Ǵ� NIO �������̽��̴�.
	// NIO�� API���� ������ ��θ� �����ϱ� ���� Path�� ����ϱ� ������ Path ��� ����� �� �����ξ�� �Ѵ�.
	// Path ���� ��ü�� ��� ���ؼ��� java.nio.file.Path Ŭ������ ���� �޼ҵ��� get() �޼ҵ带 ȣ���ؾ� �Ѵ�.
	
	//	Path path = Paths.get(String first, String ... more);
	//	Path path = Paths.get(URI uri);
	
	// get() �޼ҵ��� �Ű����� ������ ����ε�, ���ڿ��� ������ ���� �ְ�, URI ��ü�� ������ ���� �ִ�. ���ڿ��� ������ ��� ��ü ��θ� �Ѳ����� �����ص� ����, ���� ���丮�� ���� ���丮�� �����ؼ� �����ص� ����.
	// ������ "C:\Temp\dir\file.txt" ��θ� �̿��ؼ� Path ��ü�� ��� ����� �����ش�.
	
	//	Path path = Paths.get("C:/Temp/dir/file.txt");
	//	Path path = Paths.get("C:/Temp/dir", "file.txt");
	//	Path path = Paths.get("C:", "Temp", "dir", "file.txt");
	
	// ������ ��δ� ���� ��ο� ��� ��θ� ��� ����� �� �ִ�. ���� ���� ���丮 ��ġ�� "C:\Temp"�� ��� "C:\Temp\dir\file.txt"�� ������ ���� ������ �����ϴ�.
	
	//	Path path = Paths.get("dir/file.txt");
	//	Path path = Paths.get("./dir/file.txt");
	
	// ���� ��ġ�� C:\Temp\dir1" �̶�� "C:\Temp\dir2\file.txt"�� ������ ���� ������ �����ϴ�.
	
	//	Path path = Paths.get(".../dir2/file.txt");
	
	// Path �������̽����� ������ ���� ���� ��ο��� ���� �� �ִ� ���� ���� ������ �������ִ� �޼ҵ尡 �ִ�.
	
	//	���� Ÿ��		�޼ҵ�(�Ű� ����)					����
	//		
	//												���� ��ΰ� �����ϸ� 0�� ����,
	//	int				compareTo(Path other)		���� ��θ� ����,
	//												���� ��θ� ����� ����,
	//												������ ��� ���� ���̳��� ���ڿ��� ��
	//
	//	Path			getFileName()				�θ� ��θ� ������ ���� �Ǵ� ���丮 �̸��� ���� Path ����
	//
	//	FileSystem		getFileSystem()				FileSystem ��ü ����
	//
	//												C:\Temp\dir\file.txt�� ���
	//												index�� 0�̸� "Temp"�� Path ��ü ����
	//	Path			getName(int index)			index�� 1�̸� "dir"�� Path ��ü ����
	//												index�� 2�̸� "file.txt"�� Path ��ü ����
	//
	//	int				getNameCount()				��ø ��� ��, C:\Temp\dir\file.txt�� ��� 3�� ����
	//	
	//	Path			getParent()					�ٷ� �� �θ� ������ Path ����
	//
	//	Path			getRoot()					��Ʈ ���丮�� Path ����
	//
	//	Iterator<Path>	iterator()					��ο� �ִ� ��� ���丮�� ������ Path ��ü�� �����ϰ� �ݺ��ڸ� ����
	//
	//	Path			normalize()					��� ��η� ǥ���� �� ���ʿ��� ��Ҹ� ����
	//												C:\Temp\dir\...\dir\file.txt -> C:\Temp\dir2\file.txt
	//
	//	WatchKey		register(...)				WatchService�� ���(��ġ ���񽺿��� ������)
	//
	//	File			toFile()					java.io.File ��ü�� ����
	//
	//	String			toString()					���� ��θ� ���ڿ��� ����
	//
	//	URI				toURI()						���� ��θ� URI ��ü�� ����
	
	// ���� ������ ��� ��θ� �̿��ؼ� �ҽ� ���Ͽ� ���� Path ��ü�� ���, ���ϸ�, �θ� ���丮��, �߫� ��� ��, ��λ� �ִ� ��� ���丮�� ����Ѵ�.
	
			//	FileSystem
	
	// �ü���� ���� �ý����� FileSystem �������̽��� ���ؼ� ������ �� �ִ�. FileSystem ���� ��ü�� FileSystems�� ���� �޼ҵ��� getDefault()�� ���� �� �ִ�.
	
	//	FileSystem fileSystem = FileSystems.getDefault();
	
	// FileSystem�� ������ ���� �޼ҵ带 �����Ѵ�.
	
	//	���� Ÿ��					�Ű� ����					����
	//
	//	Iterable<FileStore>		getFileStores()			����̹� ������ ���� FileStore ��ü���� ����
	//	Iterable<Path>			getRootDirectories()	��Ʈ ���丮 ������ ���� Path ��ü���� ����
	//	String					getSeparator()			���丮 ������ ����
	
	// FileStore�� ����̹��� ǥ���� ��ü�� ������ ���� �޼ҵ带 �����Ѵ�.
	
	//	���� Ÿ��		�޼ҵ�(�Ű� ����)				����
	//		
	//	long		getTotalSpace()			����̹� ��ü ���� ũ��(����: ����Ʈ) ����
	//	long		getUnallocatedSpace()	�Ҵ���� ���� ���� ũ��(����: ����Ʈ) ����
	//	long		getUsableSpace()		��� ������ ���� ũ��, getUnallocatedSpace()�� ������ ��
	//	boolean		isReadOnly()			�б� ���� ����
	//	String		name()					����̹��� ����
	//	String		type()					���� �ý��� ����
	
			//	Reading File Properties And File, Directory Creation/ Delete	���� �Ӽ� �б� �� ����,���丮 ����/����
	
	// java.nio.Files Ŭ������ ���ϰ� ���丮�� ���� �� ����, �׸��� �̵��� �Ӽ��� �д� �޼ҵ带 �����ϰ� �ִ�.
	// ���⼭ �Ӽ��̶� �����̳� ���丮�� ��������, ���丮����, ũ�Ⱑ ��� �Ǵ���, �ҿ��ڰ� ���������� ���� ������ ���Ѵ�.
	// ������ java.nio.file.Files Ŭ������ �����ϴ� ���� �޼ҵ���̴�. �Ű� ������ ���� �ڼ��� ������ API ��ť��Ʈ�� ��������.
	
	//	���� Ÿ��					�޼ҵ�(�Ű�����					����
	//
	//	long �Ǵ� Path			copy(..)					����
	//	Path					createDirectories(..)		��� �θ� ���丮 ����
	//	Path					createDirectory(..)			����� ������ ���丮�� ����
	//	Path					createFile(..)				���� ����
	//	void					delete(..)					����
	//	boolean					deleteExists(..)			�����Ѵٸ� ����
	//	boolean					exists(..)					���� ����
	//	FileStore				getFileStore(..)			������ ��ġ�� FileStore(����̺�) ����
	//	FileTime				getLastModifiedTime(..)		������ ���� �ð��� ����
	//	UserPrincipal			getOwner(..)				������ ������ ����
	//	boolean					isDirectory(..)				���丮���� ����
	//	boolean					isExecutable(..)			���� ���� ����
	//	boolean					isHidden(..)				���� ����
	//	boolean					isReadable(..)				�б� ���� ����
	//	boolean					isRegularFile(..)			�Ϲ� �������� ����
	//	boolean					isSameFile(..)				���� �������� ����
	//	boolean					isWritable(..)				���� ���� ����
	//	Path					move(..)					���� �̵�
	//	BufferedReader			newBufferedReader(..)		�ؽ�Ʈ ������ �д� BufferedReader ����
	//	BufferedWriter			newBufferedWriter(..)		�ؽ�Ʈ ���Ͽ� ���� BufferedWriter ����
	//	SeekableByteChannel		newByteChannel(..)			���Ͽ� �а� ���� ����Ʈ ä���� ����
	//	DirectoryStream<Path>	newDirectoryStream(..)		���丮�� ��� ������ ��Ʈ������ ����
	//	InputStream				newInputStream(..)			������ InputStream ����
	//	OutputStream			newOutputStream(..)			������ OutputStream ����
	//	boolean					notExists(..)				�������� �ʴ��� ����
	//	String					probeContentType(..)		������ MIME Ÿ���� ����
	//	byte[]					readAllBytes(..)			������ ��� ����Ʈ�� �а� �迭�� ����
	//	List<String>			readAllLines(..)			�ؽ�Ʈ ������ ��� ������ �а� ����
	//	long					size(..)					������ ũ�� ����
	//	Path					write(..)					���Ͽ� ����Ʈ�� ���ڿ��� ����
	
	// ���� ������ ������ �Ӽ��� �а� ����Ѵ�.
	
			//	WatchService
	
	// ��ġ ����(WatchService)�� �ڹ� 7���� ó�� �Ұ��� ������ ���丮 ���ο��� ���� ����, ����, ���� ���� ���� ��ȭ�� �����ϴµ� ���ȴ�.
	// ���ϰ� �� �� �ִ� ��ġ ������ ���� ���� �����Ϳ��� ������ �����ϰ� ���� ��, ������ �ٱ����� ���� ������ �����ϰ� �Ǹ� ���� ������ ��������� ������ �ٽ� �ҷ��� ������ ���� ��ȭ���ڸ� ���� ���̴�.
	// ��ġ ���񽺴� �Ϲ������� ���� ���� ���� ��Ŀ�������� �˷��� �ִ�. WatchService�� �����Ϸ��� ������ ���� FileSystem�� newWatchService() �޼ҵ带 ȣ���ϸ� �ȴ�.
	
	//	WatchService watchService = FileSystems.getDefault().newWatchService();
	
	// WatchService�� �����ߴٸ� ���ð� �ʿ��� ���丮�� Path ��ü���� register() �޼ҵ�� WatchService�� ����ϸ� �ȴ�. �̶� � ��ȭ(����, ����, ����)�� ������ ��������
	// StandardWatchEventKinds ����� ������ �� �ִ�. ������ ����, ����, ������ �����ϵ��� WatchService�� ����Ѵ�.
	
	//	path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
	//								StandardWatchEventKinds.ENTRY_MODIFY,
	//								StandardWatchEventKinds.ENTRY_DELETE);
	
	// ���丮(Path)�� WatchService�� ����� �������� ���丮 ���ο��� ������ �߻��Ǹ� ��ġ �̺�Ʈ(WatchEvent)�� �߻��ϰ�, WatchService�� �ش� �̺�Ʈ ������ ���� ��ġŰ(WatchKey)�� �����Ͽ�
	// ť(Queue)�� �־��ش�. ���α׷��� ���� ������ ���鼭 WatchService�� take() �޼ҵ带 ȣ���Ͽ� WatchKey�� ť�� ���� ������ ����ϰ� �ִٰ� WatchKey�� ť�� ������ WatchKey�� ��� ó���ϸ� �ȴ�.
	
	//	while(true) {
	//		WatchKey watchKey = watchService.take()		// ť�� WatchKey�� ���� ������ ���
	//	}
	
	// WatchKey�� ����� �ؾ� �� ���� pollEvents() �޼ҵ带 ȣ���ؼ� WatchEvent ����Ʈ�� ���� ���̴�.
	// �� ���� WatchEvent�� �ƴ϶� List<WatchEvent<?>>�� �����ϴ� ������ �������� ������ ���ÿ� ����, ����, ������ �� �ֱ� �����̴�. ����� WatchEvent�� ���ϴ� �ϳ��� �߻��Ѵ�.
	
	//	List<WatchEvent<?>> list = watchKey.pollEvents();
	
	// ���α׷��� WatchEvent ����Ʈ���� WatchEvent�� �ϳ��� ������ �̺�Ʈ�� ������ Path ��ü�� �� ���� ������ ó���ϸ� �ȴ�.
	
	//	for(WatchEvent watchEvent : list) {
	//		// �̺�Ʈ ���� ���
	//		Kind kind = watchEvent.kind();
	//		// ������ Path ���
	//		Path path = (Path) watchEvent.context();
	//		// �̺�Ʈ �������� ó��
	//		if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
	//			// �����Ǿ��� ���, ������ �ڵ�
	//		} else if(kind == StandardWatchEventKinds.ENTRY_DELETE) {
	//			// �����Ǿ��� ���, ������ �ڵ�
	//		} else if(kind == StandardWatchEventKinds.ENTRY_MODIFY) {
	//			// ����Ǿ��� ���, ������ �ڵ�
	//		} else if(kind == StandardWatchEventKinds.OVERFLOW) {
	//		}	
	//	}
	
	// OVERFLOW �̺�Ʈ�� �ü������ �̺�Ʈ�� �ҽǵưų� ������ ��쿡 �߻��ϹǷ� ������ ó�� �ڵ尡 �ʿ� ����. ���� CREATE, DELETE, MODIFY �̺�Ʈ�� ó���ϸ� �ȴ�.
	// �� �� ���� WatchKey�� reset() �޼ҵ�� �ʱ�ȭ�ؾ� �ϴµ�, ���ο� WatchEvent�� �߻��ϸ� ť�� �ٽ� ���� �����̴�. �ʱ�ȭ�� �����ϸ� reset() �޼ҵ�� true�� ����������, 
	// �����ϴ� ���丮�� ���� �Ǿ��ų� Ű�� �� �̻� ��ȿ���� ���� ��쿡�� false�� �����Ѵ�. WatchKey�� �� �̻� ��ȿ���� �ʰ� �Ǹ� ���� ������ �������� WatchService�� close() �޼ҵ带 ȣ���ϰ� �����ϸ� �ȴ�.
	
	//	while(true) {
	//		WatchKey watchKey = watchService.take();
	//		List<WatchEvent<?>> list = watchKey.pollEvents();
	//		
	//		for(WatchEvent watchEvent : list) {
	//			...
	//		}
	//		boolean valid = watchKey.reset();
	//		if(!valid) { break; }
	//	}
	//	watchService.close();
	
	// ���� ������ C:\Temp ���丮�� ���� ���丮�� �����ߴ�. ���� ��, C:\Temp\dir ���丮�� C:\Temp\file.txt ������ �����ϰ�, file.txt ���� ������ ������ ���� �����Ͽ���.
	// �׸��� dir, file.txt�� ���ÿ� ���� �ߴ�. �� ��� �������� TextArea�� ��ϵǴ� ���� �� �� �ִ�.
}
