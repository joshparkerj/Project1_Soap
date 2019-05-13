package com.revature.domain;

import java.util.ArrayList;
import java.util.List;

public class FormValidation {
	
	private static List<String> states = new ArrayList<String>();	

	public FormValidation() {
		super();
		states.add("AL");
        states.add("AK");
        states.add("AR");
        states.add("AZ");
        states.add("CA");
        states.add("CO");
        states.add("CT");
        states.add("DE");
        states.add("FL");
        states.add("GA");
        states.add("HI");
        states.add("IA");
        states.add("ID");
        states.add("IL");
        states.add("IN");
        states.add("KS");
        states.add("KY");
        states.add("LA");
        states.add("MA");
        states.add("ME");
        states.add("MD");
        states.add("MI");
        states.add("MN");
        states.add("MO");
        states.add("MS");
        states.add("MT");
        states.add("NC");
        states.add("ND");
        states.add("NE");
        states.add("NH");
        states.add("NJ");
        states.add("NM");
        states.add("NV");
        states.add("NY");
        states.add("OH");
        states.add("OK");
        states.add("OR");
        states.add("PA");
        states.add("RI");
        states.add("SC");
        states.add("SD");
        states.add("TN");
        states.add("TX");
        states.add("UT");
        states.add("VA");
        states.add("VT");
        states.add("WA");
        states.add("WI");
        states.add("WV");
        states.add("WY");    
	}

	public static boolean validateLettersOnly(String text, boolean nullAllowed) {
		boolean valid = true;
		if (!nullAllowed && text.contentEquals(""))
			valid = false;
		for (char c : text.toCharArray())
			if (c < 65 && c != 32 || c > 90 && c < 97 || c > 122)
				valid = false;
		return valid;
	}

	public static boolean validateNumbersOnly(String text, boolean nullAllowed) {
		boolean valid = true;
		if (!nullAllowed && text.contentEquals(""))
			valid = false;
		for (char c : text.toCharArray())
			if (c < 48 || c > 57)
				valid = false;
		return valid;
	}

	public static boolean validateMathValue(String text, boolean nullAllowed) {
		boolean valid = true;
		if (!nullAllowed && text.contentEquals(""))
			valid = false;
		int numDecimal = 0;
		for (char c : text.toCharArray()) {
			if (c == 46)
				numDecimal++;
			if (c < 48 && c != 46 || c > 57) {
				valid = false;
			}
		}			
		if (numDecimal > 1)
			valid = false;
		return valid;
	}

	public static boolean validateLettersAndNumbersOnly(String text, boolean nullAllowed) {
		boolean valid = true;
		if (!nullAllowed && text.contentEquals(""))
			valid = false;
		for (char c : text.toCharArray())
			if (c < 48 && c != 32 || c > 57 && c < 65 || c > 90 && c < 97 || c > 122)
				valid = false;
		return valid;
	}

	public static boolean validatePassword(String password) {
		boolean check1 = true;
		boolean check2 = false;
		boolean check3 = false;
		if (password.length() < 8)
			check1 = false;
		String temp = password.toLowerCase();
		if (temp.equals(password))
			check1 = false;
		temp = password.toUpperCase();
		if (temp.equals(password))
			check1 = false;
		for (char c : password.toCharArray()) {
			if (c >= 48 && c <= 57)
				check2 = true;
		}
		for (char c : password.toCharArray()) {
			if (c >= 33 && c <= 47 || c >= 58 && c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 126)
				check3 = true;
		}
		if (!check1 || !check2 || !check3) {
			System.out.println("Password must be at least 8 characters in length,");
			System.out.println("Contain at least 1 uppercase letter,");
			System.out.println("Contain at least 1 lowercase letter,");
			System.out.println("Contain at least 1 number, and");
			System.out.println("Contain at least 1 special character\n");
			return false;
		}
		return true;
	}

	public static boolean validateEmail(String email) {
		String[] emailArray = email.split("@");
		if (emailArray.length != 2)
			return false;
		String[] emailArray2 = emailArray[1].split("\\.");
		if (emailArray2.length < 2)
			return false;
		if ((email.endsWith(".com") || email.endsWith(".edu") || email.endsWith(".net") || email.endsWith(".org")
				|| email.endsWith(".mil") || email.endsWith(".gov")))
			return true;
		else {
			System.out.println("Invalid Email Address.");
			return false;
		}
	}
	
	public static boolean validateAddress(String address1) {
		String[] temp = address1.split(" ");
		if (temp.length < 2)
			return false;
		boolean valid = true;
		if (!validateNumbersOnly(temp[0], false))
			return false;
		for (int i = 1; i < temp.length; i++) {
			valid = validateLettersOnly(temp[i], false);
			if (!valid) {
				System.out.println("Invalid Address. Include Apt/Suite numbers in Address2.");
				return false;
			}
		}
		return valid;
	}
	
	public static boolean validateState(String state) {
		boolean valid = false;
		for (String s : states) {
			if (s.equals(state))
				valid = true;
		}
		if (!valid)
			System.out.println("Invalid State. Please Use State Abbreviation.");
		return valid;
	}

	public static boolean validateCity(String city) {
		boolean valid = true;
		if (city.length() < 2 || !validateLettersOnly(city, false)) {
			System.out.println("Invalid City.");
			valid = false;
		}
		return valid;
	}
	
	public static boolean validateZip(String zip) {
		boolean valid = true;
		String[] zipCode = zip.split("-");
		if (zipCode.length >= 1 && zipCode.length <= 2) {
			if (!validateNumbersOnly(zipCode[0], false) || zipCode[0].length() != 5)
				valid = false;
			if (zipCode.length == 2) {
				if (!validateNumbersOnly(zipCode[1], false) || zipCode[1].length() != 4)
					valid = false;
			}
		} else
			valid = false;
		if (!valid)
			System.out.println("Invalid ZipCode.");
		return valid;
	}
	
	public static boolean validatePhone(String phone) {
		boolean valid = true;
		if (phone.length() == 12) {
			String[] digits = phone.split("-");
			if (!validateNumbersOnly(digits[0], false))
				valid = false;
			if (!validateNumbersOnly(digits[1], false))
				valid = false;
			if (!validateNumbersOnly(digits[2], false))
				valid = false;
		} else {
			valid = false;
		}
		if (!valid) {
			System.out.println("Invalid Phone Number.");
		}
		return valid;
	}

	public static String modifyPhone(String phone) {
		if (phone.length() == 10) {
			phone = phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);
		}
		if (phone.length() == 13) {
			if (phone.charAt(0) == 40 && phone.charAt(4) == 41) {
				phone = phone.substring(1, 4) + "-" + phone.substring(5);
			}
		}
		return phone;
	}
}
