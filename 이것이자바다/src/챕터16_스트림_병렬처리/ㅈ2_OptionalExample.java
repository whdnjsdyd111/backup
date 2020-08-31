package 茅磐16_胶飘覆_捍纺贸府;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class じ2_OptionalExample {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		// 抗寇 惯积
		/*
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.getAsDouble();
		*/
		
		// 规过1
		OptionalDouble optional = list.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if(optional.isPresent()) {
			System.out.println("规过1_乞闭: " + optional.getAsDouble());
		} else {
			System.out.println("规过1_乞闭: " + 0.0);
		}
		
		// 规过2
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		System.out.println("规过2_乞闭: " + avg);
		
		// 规过3
		list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.ifPresent( a -> System.out.println("规过3_乞闭: " + a) );
	}
}
