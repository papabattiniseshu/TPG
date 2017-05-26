package com.tpg.timer;

import com.tpg.ipvalidations.IPValidationRegex;
/**
 * Its a simple mechanism to know the time taken for the execution of any of the method.
 * It can be still enhanced/customised as per the requirement
 */
public class TimeMeasureTool {

	public static void main(String a[]) {
		long startTime = System.nanoTime();
		new IPValidationRegex().getFile("ip.txt");
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("duration :" + duration);
	}
}