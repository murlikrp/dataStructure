package com.practice.ds.movearray;

/* Given an integer array nums[], move all 0’s to the end of it while maintaining the relative order of the non-zero elements.
Note: You must do this in-place without making a copy of array
Constraints: 
1<=N<=104
-231 <= nums[i] < 231 - 1

Write java program. Implement method/function with name ‘solve’.

The method accepts following parameters:
1. Nums is of type List<Integer>
Return List<Integer> */


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static List<Integer> solve(List<Integer> nums) {
		int left = 0;
		int right = 0;
		int n = nums.size();
		
		while(right < n) {
			if(nums.get(left) != 0) {
				left++;
				right++;
			} else if(nums.get(right) != 0) {
				Collections.swap(nums, left, right);
				left++;
				right++;
			} else {
				right++;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(0, 1, 0, 3, 12);
		List<Integer> result = solve(nums);
		System.out.println(result);

	}

}
