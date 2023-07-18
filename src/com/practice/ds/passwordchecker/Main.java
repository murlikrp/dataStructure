package com.practice.ds.passwordchecker;

/* A password is considered strong if the below conditions are all met:
* It has at least 6 characters and at most 20 characters.
* It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
* It does not contain three repeating characters in a row (i.e., "Baaabb0" is weak, but "Baaba0" is strong).
Write a Java program, Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.
In one step, you can:
* Insert one character to password,
* Delete one character from password, or
* Replace one character of password with another character.

Example 1:
Input: password = "a"
Output: 5
Example 2:
Input: password = "aA1"
Output: 3
Example 3:
Input: password = "1337C0d3"
Output: 0

Constraints:
* 1 <= password.length <= 50
* password consists of letters, digits, dot '.' or exclamation mark '!'
*/

public class Main {
	
	public static int strongPasswordChecker(String password) {
		int length = password.length();
        int missingRequirements = getMissingRequirements(password);
        
        if (length < 6) {
            return Math.max(6 - length, missingRequirements);
        } else if (length <= 20) {
            return missingRequirements;
        } else {
            int deleteCount = length - 20;
            int replaceCount = 0;
            int repeatCount = 0;
            int totalSteps = 0;
            
            // Count the number of repeating characters
            for (int i = 0; i < length; ) {
                int j = i;
                while (j < length && password.charAt(j) == password.charAt(i)) {
                    j++;
                }
                
                int repeatLength = j - i;
                repeatCount += repeatLength / 3;
                i = j;
            }
            
            // Calculate the number of replacements required
            if (missingRequirements <= deleteCount) {
                replaceCount = repeatCount;
            } else {
                replaceCount = Math.max(repeatCount - (missingRequirements - deleteCount), 0);
                totalSteps += missingRequirements - deleteCount;
                totalSteps += (replaceCount * 2) / 3;
            }
            
            totalSteps += deleteCount;
            
            return totalSteps + Math.max(missingRequirements, replaceCount);
        }
    }
	
	private static int getMissingRequirements(String password) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        
        int missingRequirements = 3;
        if (hasLowerCase) {
            missingRequirements--;
        }
        if (hasUpperCase) {
            missingRequirements--;
        }
        if (hasDigit) {
            missingRequirements--;
        }
        
        return missingRequirements;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password1 = "a";
		System.out.println("Steps required for password '" + password1 + "': " + strongPasswordChecker(password1));
		
		String password2 = "aA1";
		System.out.println("Steps required for password '" + password1 + "': " + strongPasswordChecker(password2));
		
		String password3 = "1337COd3";
		System.out.println("Steps required for password '" + password1 + "': " + strongPasswordChecker(password3));
	}

}
