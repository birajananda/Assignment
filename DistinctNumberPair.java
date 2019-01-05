package com.assignment;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.sort;


/**
 * @author Biraja
 *
 */
public class DistinctNumberPair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Valid number pair and sum
		int[] dataArray = {1, 2, 3, 4, 5, 6};
		DistinctNumberPair.findNumberPair(dataArray, 7 );
		
		// valid number pair but sum is different
		int[] dataArray2 = {2, 3, 4, 5, 6};
		DistinctNumberPair.findNumberPair(dataArray2, 1 );
		
		// valid number pair but sum is different
		int[] dataArray1 = {1, 2, 3, 4, 5, 6};
		DistinctNumberPair.findNumberPair(dataArray1, 122 );
		
		// Empty list
		DistinctNumberPair.findNumberPair(null, 7 );
	}
	
	/**
	 *  This method will verify the data and sum input. Once it is satisfy the verification it will create the number paire's for that sum. 
	 * @param dataArray
	 * @param sumTotal
	 * @return
	 */
	public static Set<NumberPair> findNumberPair(int[] dataArray, int sumTotal) {
		Set<NumberPair> finalNumberPair = new HashSet<>();

		if (dataArray != null) {

			int[] sortedDataArray = dataArray.clone();

			sort(sortedDataArray);

			if (sumTotal < (sortedDataArray[0] + sortedDataArray[1])) {
				new CustomizedMessage(
						"Sum total is less than the sum of first and second. Hence no pairing will be created");
				return finalNumberPair;
			} else if (sumTotal > (sortedDataArray[sortedDataArray.length - 1]
					+ sortedDataArray[sortedDataArray.length - 2])) {
				new CustomizedMessage(
						"Sum total is less than the sum of second last and last. Hence no number pairing will be created");
				return finalNumberPair;
			} else {

				int currentLowest = 0;
				int currentHighest = sortedDataArray.length - 1;

				while (currentLowest != currentHighest) {
					if (sortedDataArray[currentLowest] + sortedDataArray[currentHighest] > sumTotal) {
						currentHighest -= 1;
					} else if (sortedDataArray[currentLowest] + sortedDataArray[currentHighest] < sumTotal) {
						currentLowest += 1;
					} else if (sortedDataArray[currentLowest] + sortedDataArray[currentHighest] == sumTotal) {
						finalNumberPair.add(new NumberPair(sortedDataArray[currentLowest], sortedDataArray[currentHighest]));
						currentHighest -= 1;
					}

				}

				if (finalNumberPair.size() > 0) {
					new CustomizedMessage(
							"Different combinations of number pair(s) are : " + finalNumberPair.toString());
				} else {
					new CustomizedMessage("Couldn't find any number pair ...  Try another set of inputs.");
				}
			}
		} else {
			new CustomizedMessage("As dataArray is null it will return a empty array list of number pair");
		}

		return finalNumberPair;

	}

	/**
	 * This class will have a parameterized constructor which will take the input as integer
	 * 
	 * It will override the hashCode and equals methods for unique object check.  
	 * 
	 * @author Biraja
	 */
	static final class NumberPair {

		int sumPart1;
		int sumPart2;

		NumberPair(int sumPart1, int sumPart2) {
			this.sumPart1 = sumPart1;
			this.sumPart2 = sumPart2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = (int) (prime * result + Math.sqrt(sumPart1 + sumPart2));
			// result = prime * result + b;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;

			NumberPair tempNumberPair = (NumberPair) obj;
			if ((sumPart1 == tempNumberPair.sumPart1) && (sumPart2 == tempNumberPair.sumPart2)) {
				return true;
			} else if ((sumPart1 == tempNumberPair.sumPart2) && (sumPart2 == tempNumberPair.sumPart1)) {
				return true;
			} else {
				return false;
			}

		}

		@Override
		public String toString() {
			return "[" + sumPart1 + "," + sumPart2 + "] ";
		}

	}
	/**
	 * This class to print the message
	 * @author Biraja
	 *
	 */
	static final class CustomizedMessage {


		public CustomizedMessage(String message) {
			System.out.println(message);
		}

	}

}
