package com.practice.ds.wordbreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* You are given a String S and dictionary of strings wordDict. Write java program that returns true if S can be segmented into a space-separated sequence of one or more dictionary words, else return false;
Note: the same word in the dictionary may be reused multiple times in segmentation.

For example: 
Input: S = “applepenapple”, wordDict = [“apple”, “pen”]
Output: true
This should return true because “applepenapple” can be segmented as “apple pen apple”. Since you are allowed to reuse a dictionary word

Implement method/function with name ‘solve’.

The method accepts following parameters:
1. S is of type String
2. WordDict is of type List<String>
Return String */

public class Main {

	public static String solve(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
	
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				if(dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[n] ? "true" : "false";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "applepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen");
		String result = solve(s, wordDict);
		System.out.println(result);

	}

}
