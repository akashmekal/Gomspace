package regEx;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlay 
{ 

	public static void main(String[] args) throws Exception 
	{ 
		String data = readFileAsString(System.getProperty("user.dir")  + "\\config_data\\exercise_data.txt"); 
		String searchtext = "bee";
		char start = 'a';
		char end = 'g';
		char startreg = 'd';
		char endreg = 'b';
		String reg = "cc";
		getCount(data,searchtext);
		getstring2(data,start,end);
		getstring (data,startreg,endreg,reg);
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
		System.out.println("Count of string with" +" "+searchtext+ " "+ "is" + " " +count);
	}

	static void getstring (String str, char startreg,char endreg, String reg) {
		final String regex = startreg+"(["+reg+"]){2}[a-z]{4}"+endreg;
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		final Matcher matcher = pattern.matcher(str);
		ArrayList <String> countarray = new ArrayList();
		while (matcher.find()) {
			//System.out.println("Full match: " + matcher.group(0));
			countarray.add(matcher.group(0));
		}
		int count = countarray.size();
		System.out.println("Count of string that starts with" +" "+startreg+ " " + "and ends with" +" "+endreg+ " " + "with the sequence"+ " " +reg+ " "+ "present somewhere in the string is" +" "+count);
	}

	static void getstring2 (String str,char start,char end) {
		final String regex = start+"[a-z]{2}"+end;
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		final Matcher matcher = pattern.matcher(str);
		ArrayList <String> countarray = new ArrayList();
		while (matcher.find()) {
			//System.out.println("Full match: " + matcher.group(0));
			countarray.add(matcher.group(0));
		}
		int count = countarray.size();
		System.out.println("Count of string that starts with" +" "+start+ " " + "and ends with" +" "+end+ " " + "is" +" "+count);
	}

} 

