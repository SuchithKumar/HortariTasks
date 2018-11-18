/*
 * Task:  Sticks Cutting
 *	You will be given an array of the lengths of a number of sticks. 
 *	When a turn begins, you must count the number of sticks you have. 
 *	Determine the length of a stick with the shortest length and discard any sticks of that length. 
 *	Remove that length from each of the longer sticks and discard the offcuts. Repeat until there are no sticks left. 
 *	Return an array where the elements are the numbers of sticks you had at the beginning of each turn. 
 *	For example, consider an array representing the lengths of four sticks: [1, 1, 2, 3]. 
 *	The shortest sticks are 1 unit long. Discard them. Remove 1 unit from the other two sticks and discard the scrap. 
 *	Now you have two sticks lengths [1, 2]. Do the same and you'll have one stick of length [1].
 * 	Discard it and return an array with the number of sticks you had at the start of each turn: [4, 2, 1].
 */
package com.hortari.assignements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suchith Kumar M
 *
 */
public class Task5 {
List<Integer> noOfSticks = new ArrayList<>();

	public static void main(String[] args) {
		Task5 task5 = new Task5();
		int[] stickLengths = { 1, 1, 2, 3};
		int[] sticksPerIterations ;
		int leastStickLength = stickLengths[0];
		task5.noOfSticks.add(stickLengths.length);
		
		stickLengths = cutTheSticks(stickLengths, leastStickLength);
		
		while (stickLengths.length >= 1) {
			leastStickLength=findLeastStickLength(stickLengths);
			int leastStickLength1 = stickLengths[0];
			task5.noOfSticks.add(stickLengths.length);
			stickLengths=cutTheSticks(stickLengths, leastStickLength1);
			
		}
		
		System.out.print("The number of sticks you had at the start of each turn: ");
		sticksPerIterations = listToArray(task5.noOfSticks);
		System.out.print("[");
		for (int i = 0;i<sticksPerIterations.length;i++) {
			System.out.print(sticksPerIterations[i]);
			if(i!=sticksPerIterations.length-1) {
				System.out.print(" , ");
			}
		}
		System.out.print("]");
		
	}

	private static int[] cutTheSticks(int[] stickLengths, int leastStickLength) {

		List<Integer> newStickLength = new ArrayList<>();
		
		
		for (int i = 0; i < stickLengths.length; i++) {
			stickLengths[i] = stickLengths[i] - leastStickLength;
			if (stickLengths[i] != 0) {
				newStickLength.add(stickLengths[i]);
			}

		}

		int[] stickLengths1 = listToArray(newStickLength);
		
		return stickLengths1;

	}

	private static int findLeastStickLength(int[] stickLengths) {
		int leastStickLength = 0;
		for (int i = 0; i < stickLengths.length; i++) {
			if (stickLengths[i] < leastStickLength) {
				leastStickLength = stickLengths[i];
			}
		}
		return leastStickLength;
	}

	private static int[] listToArray(List<Integer> newStickLength) {
		int[] stickLengths1 = new int[newStickLength.size()];
		for (int i = 0; i < stickLengths1.length; i++) {
			stickLengths1[i] = newStickLength.get(i);
		}
		return stickLengths1;
	}

}
