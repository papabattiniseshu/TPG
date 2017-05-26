package com.tpg.ipvalidations;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidationRegex {

	private static final String ip_pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	private boolean isValidIP(String ipAddr) {
		Pattern pattern = Pattern.compile(ip_pattern);
		Matcher matcher = pattern.matcher(ipAddr);
		return matcher.find();
	}

	public static void main(String a[]) {
		 new IPValidationRegex().getFile("ip.txt");
	}

	public void getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line+" is valid? " + this.isValidIP(line));
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}