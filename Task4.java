/*
 * Task4 - Check the Divisibility
 * Given an integer string, create all integer permutations of its digits.
 * Determine if there is a permutation whose integer value is evenly divisible by 8, i.e. (permutation value) % 8 = 0. For example, 
 * the possible permutations of 123 are p = {123, 132, 213, 231, 312, 321}. 
 * Of these values, p[4] = 312 is divisible by 8 because 312 % 8 = 0.
 * 
 */
 package com.hortari.assignements;

/**
 * @author Suchith Kumar M
 *
 */
public class Task4 {

	public static void main(String[] args) {

		String integerString = "123";
		permute(integerString, 0, integerString.length() - 1);

	}

	private static void permute(String string, int i, int j) {

		if (i == j) {
			if (Integer.parseInt(string) % 8 == 0) {
				System.out.println("Permutation " + string + " is divisible by 8 because " + string + " % 8 = 0");
			}

		} else {
			for (int k = i; k <= j; k++) {
				string = swap(string, i, k);
				permute(string, i + 1, j);
				string = swap(string, i, k);
			}
		}

	}

	public static String swap(String string, int i, int j) {
		char temp;
		char[] charArray = string.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
