package com.tca;

import java.time.LocalDate;

import com.tca.util.ArrayAlgo;
import com.tca.util.Pair;

public class App {

	public static void main(String[] args) {

		LocalDate [] birthdays = {
			LocalDate.of(2006, 11, 21),
			LocalDate.of(2006, 10, 4),
			LocalDate.of(2005, 10, 10),
			LocalDate.of(2006, 2, 5)
		};
		
		Pair<LocalDate> minMax = ArrayAlgo.<LocalDate>minMax(birthdays);
		
		System.out.println("Min : " + minMax.getFirstValue());
		System.out.println("Max : " + minMax.getSecondValue());
		
		System.out.println();
		
	}

}
