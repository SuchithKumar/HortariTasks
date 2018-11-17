/*
 *  Task 1 :  Election Polls
 *	In an elections, each voter writes the name of a candidate on a ballot and places it in the ballot box. 
 *	The candidate with the highest number of votes wins the election. If two or more candidates have the same number of votes, 
 *	then the tied candidates' names are ordered alphabetically and the last name in the alphabetical order wins. For example, 
 *	votes are in the names ['Jessy', 'Philip', 'Jessy', 'Philip']. 
 *	Each candidate received two votes, but Philip is alphabetically later than Jessy, so he wins. 
 */
package com.hortari.assignements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Suchith Kumar M
 *
 */
public class Task1 {

	public static void main(String[] args) {
		// Votes String given by the User
		String[] votes = { "Jessy", "Philip", "Jessy", "Philip" };

		System.out.println(Task1.determineWinner(votes) + " is the Winning Candidate");

	}

	public static String determineWinner(String[] votes) {

		String winner = null;
		int numberOfCandidates = 0;
		Set<String> uniqueCandidateSet = new HashSet<String>();

		for (int i = 0; i < votes.length; i++) {
			uniqueCandidateSet.add(votes[i]);
		}

		numberOfCandidates = uniqueCandidateSet.size();

		int k = 0;
		String[] uniqueCandidates = new String[numberOfCandidates];
		for (String x : uniqueCandidateSet)
			uniqueCandidates[k++] = x;

		int results[] = new int[numberOfCandidates];

		for (int i = 0; i < numberOfCandidates; i++) {
			results[i] = countNumberOfVotes(votes, uniqueCandidates[i]);
		}

		winner = announceWinner(uniqueCandidates, results);

		return winner;

	}

	private static String announceWinner(String[] uniqueCandidates, int[] results) {
		int results2[] = new int[results.length];

		for (int i = 0; i < results.length; i++) {
			results2[i] = results[i];
		}

		Arrays.sort(results2);
		int highest = results2[results2.length - 1];

		int noOfWinners = 0;
		String winner = null;
		for (int i = 0; i < results.length; i++) {
			if (highest == results[i]) {
				noOfWinners = noOfWinners + 1;
			}
		}

		if (noOfWinners == 1) {
			for (int i = 0; i < results.length; i++) {
				if (highest == results[i]) {
					winner = uniqueCandidates[i];
				}
			}
		}

		String winners[] = new String[noOfWinners];
		if (noOfWinners > 1) {
			for (int i = 0; i < noOfWinners; i++) {
				if (highest == results[i]) {
					winners[i] = uniqueCandidates[i];
				}
			}

			sortAlphbetically(winners);
			return winners[0];
		}

		return winner;
	}

	private static void sortAlphbetically(String[] winners) {

		String temp;
		if (winners.length > 1) {
			for (int i = 0; i < winners.length - 1; i++) {
				for (int j = i + 1; j < winners.length; j++) {
					if (winners[i].compareToIgnoreCase(winners[j]) > 0) {
						temp = winners[i];
						winners[i] = winners[i + 1];
						winners[i + 1] = temp;
					}

				}
			}
		}

	}

	private static int countNumberOfVotes(String[] votes, String candidate) {
		int count = 0;
		for (int i = 0; i < votes.length; i++) {
			if (candidate == votes[i]) {
				count = count + 1;
			}
		}
		return count;
	}

}
