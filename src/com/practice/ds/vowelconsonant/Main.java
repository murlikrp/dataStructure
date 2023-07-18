package com.practice.ds.vowelconsonant;

import java.util.Scanner;

/* Write java program. The program asks the user to provide a single character from English alphabet and prints “Consonant” or “vowel”, depending on the input.
Create method that return String as output
Examples:
Input: R
Output: Consonant 

Input: e
Output: Vowel */



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a single character: ");
		String input = scanner.nextLine().toLowerCase();
		
		String result = checkConsonantOrVowel(input);
		System.out.println(result);

	}
	
	public static String checkConsonantOrVowel (String input) {
		if(input.length() != 1 || !Character.isLetter(input.charAt(0))) {
			return "Invalid input. Please enter a single character from English Alphabet";
		}
		
		char ch = input.charAt(0);
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return "Vowel";
		} else {
			return "Consonant";
		}
	}

}
