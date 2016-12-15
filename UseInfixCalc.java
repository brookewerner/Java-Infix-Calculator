//Brooke Werner

//I used some code for a BufferedReader and PrintWriter from a lab I wrote for CSC 171

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UseInfixCalc {

	public static void main(String[] args) throws IOException, FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the name of the destination you would like to read from followed by the name"
				+ " of the destination you would like the answers saved to.");
		FileReader source = new FileReader(scan.next());
		String destination = scan.next();
		
		BufferedReader reader = new BufferedReader(source);

		String line;

		ArrayList<String> eachLineString = new ArrayList<String>();
		ArrayList<ArrayList<String>> eachLineChar = new ArrayList<ArrayList<String>>();

		try {
			PrintWriter out = new PrintWriter(new File(destination));

			line = reader.readLine();
			while(line != null){
				eachLineString.add(line);

				line = reader.readLine();
			}			

			int i = 0;
			for (String s: eachLineString) {
				InfixCalc calc;

				ArrayList<String> eachChar = new ArrayList<String>();
				for (int l = 0; l < s.length(); ) {
					if (!(("" + s.charAt(l)).equals(" "))) {
						//							eachChar.add(l, "" + s.charAt(l));
						eachChar.add("" + s.charAt(l));

						int j = 1;
						while ( ((l+j) < s.length()) && (!((("" + s.charAt(l+j)).equals(" ")))) && (!((("" + s.charAt(l)).equals("(")))) && (!((("" + s.charAt(l)).equals("!"))))) {

							if (("" + s.charAt(l+j)).equals(")")) {
								eachChar.add(")");
							} else {
								eachChar.set(eachChar.size()-1, "" + eachChar.get(eachChar.size()-1) + s.charAt(l+j));
							}
							j++;
						}

						l = l+j;
					} else {
						l++;
					}
				}
				eachLineChar.add(eachChar);

				calc = new InfixCalc(eachLineChar.get(i));
				//the queue in calc now has the postfix expression
				
				if (calc.answer().startsWith("Error.")) {
					out.printf(calc.answer() + "%n");
				} else {
					out.printf("%.2f%n", Double.valueOf(calc.answer())); //this will print stuff on final destination
				}
				
				i++;
			}



			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("Unable to write destination " + destination);
		}catch (IOException e){
			System.out.println("Not found");
		}
			
		reader.close();
		scan.close();
	}
}
