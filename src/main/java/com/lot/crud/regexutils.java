package com.lot.crud;

import java.util.regex.Pattern;

public class regexutils {
	public static boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern)
				.matcher(emailAddress)
				.matches();
	}
}
