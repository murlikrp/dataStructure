package com.practice.ds.koko;

/* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Write java program that Return the minimum integer k such that she can eat all the bananas within h hours.
 
Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 
Constraints:
* 1 <= piles.length <= 104
* piles.length <= h <= 109
* 1 <= piles[i] <= 109 */

public class Main {
	
	public static int minEatingSpeed (int[] piles, int h) {
		int left = 1;
		int right = getMaxPile(piles);
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(canEatWithinTime(piles, h, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	private static int getMaxPile(int[] piles) {
		int maxPile = 0;
		for(int pile: piles) {
			maxPile = Math.max(maxPile, pile);
		}
		return maxPile;
	}
	
	private static boolean canEatWithinTime(int[] piles, int h, int k) {
		long hours = 0;
		for(int pile: piles) {
			hours += Math.ceil((double) pile / k);
		}
		return hours <= h;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = {3, 6, 7, 11};
		int h = 8;
		System.out.println("Minimum eating speed: " + minEatingSpeed(piles, h));
		
		int[] piles2 = {30, 11, 23, 4, 20};
		int h2 = 5;
		System.out.println("Minimum eating speed: " + minEatingSpeed(piles2, h));
		
		int[] piles3 = {3, 6, 7, 11};
		int h3 = 8;
		System.out.println("Minimum eating speed: " + minEatingSpeed(piles3, h));
	}

}
