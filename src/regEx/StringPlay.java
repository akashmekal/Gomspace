package regEx;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlay 
{ 

	public static void main(String[] args) throws Exception 
	{ 
		String data = readFileAsString(System.getProperty("user.dir")  + "\\config_data\\exercise_data.txt"); 
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string that you would like to search in the file:");
		String searchtext = in.nextLine();
		getCount(data,searchtext);

		Scanner lg = new Scanner(System.in);
		System.out.println("Enter length of the substring you want to search in the file:");
		String chard = lg.nextLine();
		int charLength;
		try {
			charLength = Integer.valueOf(chard);
			System.out.println(charLength);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Illegal string length, Please enter a valid integer ");
		};

		Scanner st = new Scanner(System.in);
		System.out.println("Enter the starting charatcher of substring you want to search in the file:");
		String start = st.nextLine();

		Scanner ed = new Scanner(System.in);
		System.out.println("Enter the ending charatcher of substring you want to search in the file:");
		String end = ed.nextLine();



		getRegstringCount(data,charLength,start,end);

		Scanner lgt = new Scanner(System.in);
		System.out.println("Enter length of the substring you want to search in the file:");
		String chardd = lgt.nextLine();
		int charlen;
		try {
			charlen = Integer.valueOf(chardd);
			System.out.println(charLength);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Illegal string length, Please enter a valid integer ");
		};

		Scanner st1 = new Scanner(System.in);
		System.out.println("Enter the starting charatcher of substring you want to search in the file:");
		String startreg = st1.nextLine();

		Scanner ed1 = new Scanner(System.in);
		System.out.println("Enter the ending charatcher of substring you want to search in the file:");
		String endreg = ed1.nextLine();

		Scanner sq = new Scanner(System.in);
		System.out.println("Enter the sequence charatcher of substring you want to search in the file:");
		String reg = sq.nextLine();

		getRegstringCount(data,charlen, startreg,endreg,reg);
	} 


	public static String readFileAsString(String fileName)throws Exception 
	{ 
		String data = ""; 
		data = new String(Files.readAllBytes(Paths.get(fileName))); 
		return data;
	}

	static void getCount(String str, String searchtext) throws IOException
	{
		int count = 0;
		int idx = 0;
		while ((idx = str.indexOf(searchtext, idx)) != -1)
		{
			idx++;
			count++;
		}
		System.out.println("Count of string" +" "+searchtext+ " "+ "is" + " " +count);
	}

	static void getRegstringCount (String str, int charlen, String startreg,String endreg, String reg) {
		final String regex = startreg+"(["+reg+"]){2}[a-z]{"+(charlen -4)+"}"+endreg;
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		final Matcher matcher = pattern.matcher(str);
		ArrayList <String> countarray = new ArrayList();
		while (matcher.find()) {
			countarray.add(matcher.group(0));
		}
		int count = countarray.size();
		System.out.println("Count of string that starts with" +" "+startreg+ " " + "and ends with" +" "+endreg+ " " + "with the sequence"+ " " +reg+ " "+ "present somewhere in the string is" +" "+count);
	}

	static void getRegstringCount(String str,int charLength,String start,String end) {
		final String regex = start+"[a-z]{"+(charLength-2)+"}"+end;
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		final Matcher matcher = pattern.matcher(str);
		ArrayList <String> countarray = new ArrayList();
		while (matcher.find()) {
			countarray.add(matcher.group(0));
		}
		int count = countarray.size();
		System.out.println("Count of string that starts with" +" "+start+ " " + "and ends with" +" "+end+ " " + "is" +" "+count);
	}
} 