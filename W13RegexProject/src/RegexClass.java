import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains various methods for parsing Strings based on reg exp
 * 
 * @author meh
 *
 */
public class RegexClass {

	public static void printTokens(String[] arr) {
		System.out.println("Printing tokens:");
		String finalS = "";
		// iterate over given array and contacante over each string
		for (String s : arr) {
			// System.out.print(s + ", ");
			finalS += (s + ", ");
		}
		finalS = finalS.substring(0, finalS.length() - 2);
		System.out.println(finalS);
		System.out.println();
	}

	/**
	 * Splits the given string based on the given regex
	 * 
	 * @param str
	 * @param regex
	 * @return String array
	 */
	public static String[] splitString(String str, String regex) {

		return str.split(regex);

	}

	/**
	 * replaces all instances of given pattern (rgex) with given replacement
	 * 
	 * @param str         to replaces values in
	 * @param pattern     to use for replacement
	 * @param replacement
	 * @return
	 */
	public static String replaceAllWithPattern(String str, String pattern, String replacement) {
		return str.replaceAll(pattern, replacement);
	}

	/**
	 * Parses and returns various parts of a phone number to return
	 * 
	 * @param phone
	 * @param part
	 * @return part of phone number
	 */
	public static String getPhonePart(String phone, int part) {

		// second part must be 1/2/3
		if (part < 1 || part > 3) {
			throw new IllegalArgumentException("Part must be 1, 2 or 3.");
		}

		// ()indicates groups
		// [.\\s]+indicates a character class
		// matching one of multiple characters (with repitition): -, ., whitespace
		// \b macthes an empty string or non-word char
		// at the beining of teh pattern
		String regex = "\\b(\\d{3})[-.\\s]+(\\d{3})[-.\\s]+(\\d{4})\\b";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phone);

		String phonePart = "";

		// matches enitre phone number
		while (m.find()) {
			// get the designated group
			phonePart = m.group(part);
		}
		return phonePart;
	}

	/***
	 * Replaces area code in given phone number with new given area code
	 * 
	 * @param phone
	 * @param newArea
	 * @return
	 */

	public static String replaceAreaCode(String phone, String newArea) {

		// [0-9] indiactes a char class
		return phone.replaceFirst("[0-9]{3}", newArea);
	}

	/**
	 * formats a given phone number in teh format 1234567890 to format (123)
	 * 456-7890
	 * 
	 * @param number
	 * @return
	 */
	public static String formatPhone(String number) {

		// paranthsis indiactes group
		// \b macthes an empty string or non word character at the
		// begining of the pattern.
		String regex = "\\b(\\d{3})(\\d{3})(\\d{4})\\b";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(number);

		String formattedPhone = "";
		while (m.find()) {
			formattedPhone = m.group() + " formatted as " + "(" + m.group(1) + ")" + m.group(2) + "-" + m.group(3);
		}
		return formattedPhone;
	}

	/**
	 * returns true if str starts with a number
	 * 
	 * @param str
	 * @return
	 */
	public static boolean startsWithNumeric(String str) {

		// ^ indicates begining of string
		String regex = "^\\d+";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);

		return m.find();
	}

	/**
	 * true if string ends with num
	 * 
	 * @param str
	 * @return
	 */
	public static boolean endsWithNumeric(String str) {

		// $ indicates end of string
		String regex = "\\d+$";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);

		return m.find();
	}

	/**
	 * Parses and returns various parts of a given email address.
	 * 
	 * @param email to parse
	 * @param part  of email to return: 1 (prefix) or 2 (domain)
	 * @return part of email address
	 */
	public static String getEmailPart(String email, int part) {
		if (part < 1 || part > 2) {
			throw new IllegalArgumentException("Part must be 1 or 2.");
		}

		// parenthesis() indicate groups
		// \b matches an empty string or non-word character,
		// at the beginning or end of the pattern

		// [a-zA-Z0-9._%+-]+ indicates a character class,
		// matching one of several characters (with repetition): a-z, A-Z, 0-9, ., _, %,
		// +, -

		// [a-zA-Z]{2,} matches an upper or lower-case letter, 2 or more times
		String regex = "\\b([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})\\b";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);

		String emailPart = "";
		while (m.find()) {
			// get the designated group
			emailPart = m.group(part);
		}

		// return group
		return emailPart;
	}

	//

	public static void main(String[] args) {
		String str = "The cow jumped over the moon";
		// split the string based on single space
		String[] tokens = RegexClass.splitString(str, " ");
		RegexClass.printTokens(tokens);

		tokens = RegexClass.splitString(str, "the");
		RegexClass.printTokens(tokens);

		str = "the         cow   jumped    over the\n " + "   moon";

		// split the string based on various amounts of white space
		// \s matches a single whitespace
		// \s+ macthes 1 or more whitespace chars
		// because the \ is a special char we escape it with another \ and so we use
		// \\s+
		// to match 1 or more whitespace chars
		tokens = RegexClass.splitString(str, "\\s+");
		RegexClass.printTokens(tokens);

		String updatesStr = RegexClass.replaceAllWithPattern(str, "\\s+", " ");
		System.out.println("Replacement whitespaces: " + updatesStr);
		System.out.println("");

		// get parts of phone number
		String areaCode = RegexClass.getPhonePart("123-982-6342", 1); // get area code
		String prefix = RegexClass.getPhonePart("800 787 2394", 2); // get prefix
		String lineNumber = RegexClass.getPhonePart("       508.717.0989   ", 3); // get line number
		System.out.println("Phone number parts: " + areaCode + " " + prefix + " " + lineNumber);
		System.out.println("");

		// replace area code
		String phone = "123-982-6324";
		String updatedPhone = RegexClass.replaceAreaCode(phone, "888");
		System.out.println("Updated phone: " + updatedPhone);
		System.out.println("");

		//
		String phone1 = "1234567890 ";
		String formattedPhone = RegexClass.formatPhone(phone1);
		System.out.println("Formatted phone: " + formattedPhone);
		System.out.println("");

		/// determine email conatin nums
		String email = "123med@gmail.com";
		boolean startsNumeric = RegexClass.startsWithNumeric(email);
		System.out.println(email + " starts with numeric: " + startsNumeric);
		System.out.println("");

		/// determine email conatin nums
		boolean endsNumeric = RegexClass.endsWithNumeric(email);
		System.out.println(email + " end with numeric: " + endsNumeric);
		System.out.println("");

		// get email parts
		String emailPrefix = RegexClass.getEmailPart(email, 1);
		String emailDomain = RegexClass.getEmailPart(email, 2);
		System.out.println("Email parts: " + emailPrefix + " " + emailDomain);
		System.out.println("");

		// split text into sentences
		// a question can end with a . or ! or ?
		String text = "I am fixing a hole where the rain gets in." + "AAnd stops my mind wondering! "
				+ "Where it will go?";

		tokens = RegexClass.splitString(text, "[.!?]");
		RegexClass.printTokens(tokens);

		// extract quote from text
		String quoteString = "\"Be yourself; everyone else is already taken.\" said Oscar Wild";

		// escape double-quotes " with backslash \
		tokens = RegexClass.splitString(quoteString, "\"");

		// 2nd item in the toekns array is the quote
		String quote = tokens[1];

		System.out.println("Oscar Wilde said: " + quote);
		System.out.println("");
	}
}
