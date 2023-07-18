package com.practice.ds.wordbreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
