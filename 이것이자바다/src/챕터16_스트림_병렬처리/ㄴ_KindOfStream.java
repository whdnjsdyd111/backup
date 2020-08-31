package 챕터16_스트림_병렬처리;

public class ㄴ_KindOfStream {
	// 자바 8부터 새로 추가된 java.util.stream 패키지에는 스트림(stream) API들이 포진하고 있다.
	// 패키지 내용을 보면 BaseStream 인터페이스를 부모로 해서 자식 인터페이스들이 다음과 같은 상속 관계를 이루고 있다.
	
	//						BaseStream
	//		┌───────────┬───────┴───────┬───────────────┐
	//	Stream		IntStream		LongStream		DoubleStream
	
	// BaseStream 인터페이스에는 모든 스트림에서 사용할 수 있는 공통 메소드들이 정의되어 있을 뿐 코드에서 직접적으로 사용되지는 않는다.
	// 하위 스트림인 Stream, IntStream, LongStream, DoubleStream이 직접적으로 이용되는 스트림인데, 
	// Stream은 객체 요소를 처리하는 스트림이고, IntStream, LongStream, DoubleStream은 각각 타입인 int, long, double 요소를 처리하는 스트림이다.
	// 이 스트림 인터페이스의 구현 객체는 다양한 소스로부터 얻을 수 있다. 주로 컬렉션과 배열에서 얻지만, 다음과 같은 소스로부터 스트림 구현 객체를 얻을 수도 있다.
	
	//	리턴 타입			메소드													소스
	//
	//	Stream<T>		java.util.Collection.stream()							컬렉션
	//					java.util.Collection.parallelStream()
	//	
	//	Stream<T>		Arrays.stream(T[]),			Stream.of(T[])
	//	IntStream		Arrays.stream(int[]),		IntStream.of(int[])
	//	LongStream		Arrays.stream(long[]),		LongStream.of(long[])		배열
	//	DoubleStream	Arrays.stream(double[]),	DoubleStream.of(double[])
	//
	//	IntStream		IntStream.range(int, int)								int 범위
	//					IntStream.rangeClosed(int, int)
	//
	//	LongStream		LongStream.range(long, long)							long 범위
	//					LongStream.rangeClosed(long, long)
	//
	//	Stream<Path>	Files.find(Path, int, BiPredicate, FileVisitOption)		디렉토리
	//					Files.list(Path)
	//
	//	Stream<String>	Files.lines(Path, Charset)								파일
	//					BufferedReader.lines()									
	//
	//	DoubleStream	Random.doubles(...)
	//	IntStream		Random.ints(...)										랜덤 수
	//	LongStream		Random.longs(...)
	
			//	Getting Stream From Collection		컬렉션으로부터 스트림 얻기
	
	// 다음 예제는 List<Student> 컬렉션에서 Stream<Student>를 얻어내고 요소를 콘솔에 출력한다.
	
			//	Getting Stream From Arrays		배열로부터 스트림 얻기
	
	// 다음 예제는 String[]과 int[] 배열로부터 스트림을 얻어내고 콘솔에 출력한다.
	
			//	Getting Stream From Number Range	숫자 범위로부터 스트림 얻기
	
	// 다음은 1부터 100까지의 합을 구하기 위해 IntStream의 rangeClosed() 메소드를 이용하였다. rangeClosed()는 첫 번째 매개값에서부터 두 번째 매개값까지
	// 순차적으로 제공하는 IntStream을 리턴한다. IntStream의 또 다른 range() 메소드도 동일한 IntStream을 리턴하는데, 두 번째 매개값은 포함하지 않는다.
	
			//	Getting Stream From Files		파일들로부터 스트림 얻기
	
	// 다음 예제는 Files의 정적 메소드인 lines()와 BufferedReader의 lines() 메소드를 이용해서 문자 파일의 내용을 스트림을 통해 행 단위로 읽고 콘솔에 출력한다.
	
			// Getting Stream From Directory	디렉터리로부터 스트림얻기
	
	// 다음 예제는 Files의 정적 메소드인 list()를 이용해서 디렉토리의 내용(서브 디렉토리 또는 파일 목록)을 스트림을 통해 읽고 콘솔에 출력한다.
	
}
