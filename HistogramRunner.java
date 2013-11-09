import java.util.*;
import java.io.*;

public class HistogramRunner
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Create a Histogram
		Histogram h = new Histogram();

		//Ask the user for the document you want to run a histogram on
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the name of the file to be analyzed: ");

		//Use the scanner to chop up the file to put into the histogram
		Scanner file = new Scanner(new File(kb.nextLine()));
		while(file.hasNextLine()){
			Scanner line = new Scanner(file.nextLine());
			while(line.hasNext()){
				char[] word = line.next().toUpperCase().toCharArray();
				for(char c : word){
					h.add(c);
				}
			}
		}

		//Prints the number of times each letter occurs in the file
		System.out.println("\nOccurance of letters:\n" + h);


		//Calculate and print out the frequencies of each letter in the file
		h.calculateFrequency();
		System.out.println("Frequency of letters (alphabetical order):");
		h.printFrequency();
		System.out.println("\nFrequency of letters (numerical order):");
		h.inOrder();




	}
}