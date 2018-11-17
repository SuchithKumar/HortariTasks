/*
 * 	Task - Let's sort 
 * 	You will be given an array of integers to sort. Sorting must first be by frequency of occurrence, 
 *	then by value. For instance, given an array [4, 5, 7, 7, 6, 5, 4, 3], 
 *	there is one each of 6's and 3's, and there are two 4's, two 7's and two 5's. 
 *  The sorted list is [3, 6, 4, 4, 5, 5, 7, 7].
 * 
 */
package com.hortari.assignements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task2 {

	public static void main(String[] args) {
		int[] array = { 4, 5, 7, 7, 6, 5, 4, 3 };
		array = Task2.sortArray(array);
		printArray(array);
	}

	private static int[] sortArray(int[] array) {
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		Map<Integer, Integer> noOfOccurances = new HashMap<>();
		List<Integer> result = new ArrayList<>();
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


		Object[] a = noOfOccurances.entrySet().toArray();
		Arrays.sort(a, new Comparator() {
		    public int compare(Object o1, Object o2) {
		        return -((Map.Entry<Integer, Integer>) o2).getValue().compareTo(
		                ((Map.Entry<Integer, Integer>) o1).getValue());
		    }
		});
		for (Object e : a) {
		    for(int i=0;i<((Map.Entry<Integer, Integer>) e).getValue();i++) {
		    	result.add(((Map.Entry<Integer, Integer>) e).getKey());
		    }
		}
		
		int[] finalArray = new int[result.size()];
		for (int i=0; i<result.size();i++) {
			finalArray[i]=result.get(i);
		}
		
		return finalArray;
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
