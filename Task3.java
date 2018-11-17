/*
 *	 Task 3 - Get Rid of Duplicates	 
 *   Given an array of integers, your task is to count the number of duplicate array elements and get rid of them to form a new array.
 *   Duplicate is defined as two or more identical elements. 
 *   For example, in the array [4, 5, 5, 6, 6, 6], the two fives are one duplicate and so are the three sixes.
 * 
 */
package com.hortari.assignements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Suchith Kumar M
 */
public class Task3 {

	public static void main(String[] args) {
		int[] array = {4, 5, 5, 6, 6, 6};
		System.out.print("Input Array : ");
		printArray(array);
		array = removeAndCountDuplicates(array);
		System.out.print("Output Array : ");
		printArray(array);
	}

	private static int[] removeAndCountDuplicates(int[] array) {

		Set<Integer> arraySet = new HashSet<>();
		Set<Integer> uniqueNumbers = new HashSet<>();
		Map<Integer, Integer> noOfOccurances = new HashMap<>();
		int max = 0;
		
		for (int i = 0; i < array.length; i++) {
			uniqueNumbers.add(array[i]);
		}

		int[] uniqueNumberArray = new int[uniqueNumbers.size()];

		int k = 0;
		for (Integer integer : uniqueNumbers) {
			uniqueNumberArray[k++] = integer;
		}

		int counter[] = new int[uniqueNumberArray.length];
		for (int i = 0; i < uniqueNumberArray.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (uniqueNumberArray[i] == array[j]) {
					counter[i]++;

				}
			}
		}

		for (int i = 0; i < uniqueNumberArray.length; i++) {
			if (max < counter[i]) {
				max = counter[i];
			}
			noOfOccurances.put(uniqueNumberArray[i], counter[i]);
		}
		
		int duplicates = 0;
		
		for (int i = 0; i < uniqueNumberArray.length; i++) {
			if(noOfOccurances.get(uniqueNumberArray[i])>1) {
				duplicates  = duplicates + (noOfOccurances.get(uniqueNumberArray[i])-1);
			}
		}

		System.out.println("Number of duplicates found and removed are : " + duplicates);
		
		
		for (int i=0;i<array.length;i++) {
			arraySet.add(array[i]);			
		}
		
		
		int l=0;
		int[] resultArray = new int[arraySet.size()];
		for (Integer setElement : arraySet) {
			resultArray[l]=setElement;
			l++;
		}
		
		return resultArray;
	}
	
	private static void printArray(int[] array) {
		System.out.print("[ ");
		for (int j = 0; j < array.length; j++) {
			System.out.print(array[j]);
			if (j == array.length - 1) {
				break;
			} else {
				System.out.print(", ");
			}
		}
		System.out.println(" ]");
	}
	
}
