package utils;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;


public class ConsoleLog {

	public static String timeOfLog() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	@SuppressWarnings("deprecation")
	public static String timeOfLog(String format, int addDay) {
		SimpleDateFormat sdfDate = new SimpleDateFormat(format);
		Date now = new Date();
		now.setDate(now.getDate() + addDay);
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public void writeLog(String message) {
		message = timeOfLog() + " | " + message;
		System.out.println("          --- " + message);
		Reporter.log(message);
	}

	public static void writeTcNameAndFeature(String feature, String tcName) {
		tcName = "######## " + tcName + " ########";

		String space = "    ";
		int lenTcName = ("######## " + tcName + " ########").length();
		int lenFeature = ("######## " + feature + " ########").length();
		if (lenTcName % 2 == 1) {
			lenTcName = lenTcName + 1;
		}
		if (lenFeature % 2 == 1) {
			lenFeature = lenFeature + 1;
		}
		int a = lenTcName / 2;
		int b = lenFeature / 2;
		System.out.print(space);
		for (int i = 0; i < a - b - 1; i++) {
			System.out.print("#");
		}
		System.out.print(" " + feature + " ");
		for (int i = 0; i < a - b - 1; i++) {
			System.out.print("#");
		}
		System.out.println();
		System.out.print(space);
		System.out.println(tcName);
		System.out.print(space);
		for (int i = 0; i < tcName.length(); i++) {
			System.out.print("#");
		}
		System.out.println();
	}

	public static void testStepDescription(String stepNumber, String contentStep) {
		String message = "    " + timeOfLog() + " |*** " + stepNumber + " ***| " + contentStep;
		System.out.println(message);
		Reporter.log(message);
	}

	public static void testStepAction(String stepAction) {
		String message = "    " + timeOfLog() + "  ----> " + stepAction;
		System.out.println(message);
		Reporter.log(message);
	}

	public static void testStepChildAction(String stepAction) {
		String message = "    " + timeOfLog() + "   +++  " + stepAction;
		System.out.println(message);
		Reporter.log(message);
	}

	public static void processing(String message) {
		message = "*" + message;
		System.out.println("\n\n" + message);
		Reporter.log(message);
	}

	public static void expectedResult(String message) {
		message = "    " + timeOfLog() + " | " + message;
		System.out.println(message);
		Reporter.log(message);
	}

	public static void stepConclusion(boolean expectedResult, boolean result, String message) {
		if (result == expectedResult) {
			message = "    " + timeOfLog() + " | " + message + " (PASSED)";
		} else {
			message = "    " + timeOfLog() + " | " + message + " (FAILED)";
		}
		System.out.println("\n" + message);
		System.out.print("    ");
		for (int i = 0; i < message.length() - 4; i++) {
			System.out.print("~");
		}
		System.out.println();
		assertEquals(result, expectedResult, message);
		Reporter.log(message);
	}

	public static void notify(String message) {
		message = "    " + timeOfLog() + " |> " + message;
		System.out.println(message);
		Reporter.log(message);
	}

	public static void additionalStep(String message) {
		message = "    " + timeOfLog() + " +++ " + message;
		System.out.println(message);
		Reporter.log(message);
	}

}
