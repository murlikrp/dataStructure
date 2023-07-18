package com.practice.ds.addbinary;

/* Given two binary strings a and b, find their sum as a binary string ie perform binary addition operation on these values

Contraints: 1<=a.length, b.length <= 104

Write java program. Implement method/function with name ‘solve’.

The method accepts following parameters:
1. A is of type string
2. B is of type string
Return String */

public class Main {
	
	public static String solve(String a, String b) {
		StringBuilder result = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		
		while(i >= 0 || j >= 0) {
			int sum = carry;
			if(i >= 0) {
				sum += a.charAt(i) - '0';
				i--;
			}
			if(j >= 0) {
				sum += b.charAt(j) - '0';
				j--;
			}
			
			result.append(sum % 2);
			carry = sum/2;
		}
		
		if(carry != 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "101";
		String b = "1101";
		String result = solve(a, b);
		System.out.println(result);
	}

}
