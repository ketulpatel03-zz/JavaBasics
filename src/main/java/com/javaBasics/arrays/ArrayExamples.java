package com.javaBasics.arrays;

import java.util.ArrayList;
import java.util.Arrays;

// adding an element in an array by converting it to ArrayList
public class ArrayExamples {

	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Array:" + Arrays.toString(arr));
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));
		arrayList.add(7);
		arr = arrayList.toArray(arr);
		System.out.println("Array after adding element: " + Arrays.toString(arr));
	}
}
