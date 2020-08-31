package 챕터15_컬렉션프레임워크;

import java.util.Comparator;

public class ㅁ4_DescendingComparator implements Comparator<ㅁ4_Fruit>{
	@Override
	public int compare(ㅁ4_Fruit o1, ㅁ4_Fruit o2) {
		if(o1.price < o2.price) return 1;	// 가격이 적을 경우 뒤에 오게 함
		else if(o1.price == o2.price) return 0;
		else return -1;						// 가격이 클 경우 앞에 오게 함
	}
}
