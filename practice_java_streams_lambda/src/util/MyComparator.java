package util;

import java.util.Comparator;

import Entities.Car;

public class MyComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
	}

}
