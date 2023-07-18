package com.practice.ds.triplecount;

import java.util.List;

/* The cost of stock on each dat is given in an array, arr. An investor wants to buy the stocks in triplets such that sum of the cost for three days is divisible by d. Write java program to find the number of distinct triplets (i, j, k) such that i < j < k and sum (a[i] +a[j] + a[k]) is divisible by d. 

Example: 
Let arr, prices of stock = [3, 3, 4, 7, 8] and d = 5. Following are the triplets whose sum is divisible by d (1-based indexing):
1. Triplet with indices - (1, 2, 3), sum = 3 + 3 + 4 which is equal to 10
2. Triplet with indices - (1, 3, 5), sum = 3 + 4 + 8 which is equal to 15
3. Triplet with indices - (2, 3, 4), sum = 3 + 4 + 8 which is equal to 15

Functon Description: Complete the function getTripletCount. The function must return integer denoting the total number of distinct triplets.

getTripletCount has following parameters:
arr[]: List of integers
d: an integer

Constraints:
3 <= n <= 10^3
1 <= arr[i] <= 10^9
2 <= d <= 10^6

*/ 

public class StockTriplets {
	
	static int getTripletCount(List<Integer> arr, int d) {
		int count = 0;
		int n = arr.size();
		
		for (int i=0; i<n-2; i++) {
			for (int j=i+1; j<n; j++) {
				for (int k=j+1; k<n; k++) {
					int sum = arr.get(i) + arr.get(j) + arr.get(k);
					if(sum % d == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = List.of(3, 3, 4, 7, 8);
		int d = 5;
		int result = getTripletCount(arr, d);
		System.out.println("Number of distinct triplets: "+result ); // Output = 3
	}

}
