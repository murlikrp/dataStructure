package com.practice.ds.romannumeral;

/* Given an Integer, convert it into a roman numeral. 

Roman numerals are represented by seven different symbols I, V, X, L, C, D and M.

For example, 3 is written as III. 13 is written as XIII, which is X + III. 
However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five, we subtract it, making the total four. The same principle applies to the number nine, which is written as IX.

Write java program. Create method that return string
*/

public class Main {

	public static String convertToRoman (int number) {
		 int[] arabicValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	        StringBuilder romanNumeral = new StringBuilder();

	        for (int i = 0; i < arabicValues.length; i++) {
	            while (number >= arabicValues[i]) {
	                romanNumeral.append(romanSymbols[i]);
	                number -= arabicValues[i];
	            }
	        }

	        return romanNumeral.toString();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 3456;
		String romanNumeral = convertToRoman(number);
		System.out.println("Roman numeral: "+romanNumeral);
	}

}
