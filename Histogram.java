import java.util.*;
import java.io.*;

public class Histogram
{
	private int[] count;
	private double[] freq;


	//Default Constructor for Histogram (counts # of characters a-z)
	public Histogram()
	{
		count = new int[26];
		freq = new double[26];

	}


	//adds one to the character count of a specific character
	public void add(char c)
	{
		if(c>=65 && c<=90)
			count[c-65]++;
	}

	//returns the count of a specific character
	public int getCount(char c)
	{
		return count[c-65];
	}

	//calculates the frequency of each character
	public void calculateFrequency()
	{
		double sum = 0;
		for(int i:count)
			sum += i;
		for(int i=0;i<count.length;i++)
			freq[i] = count[i]/sum;
	}

	//prints each character and its frequency to 2 decimal places (alphabetical order)
	public void printFrequency()
	{
		for(int i=0;i<count.length;i++)
			System.out.printf("%c: %6.2f%%%n",(char)(i+65), freq[i]*100);
	}

	//prints out character and its frequency to 2 decimal places (frequency order)
	public void inOrder()
	{
		TreeMap<Double, Character> map = new TreeMap<Double, Character>();
		for(int i=0; i<freq.length; i++)
		{
			map.put(freq[i], (char)(i+65));
		}
		Stack<Double> keys = new Stack<Double>();
		Stack<Character> vals = new Stack<Character>();
		for(Double key : map.keySet())
		{
			keys.add(key);
			vals.add(map.get(key));
		}
		while(!keys.isEmpty())
		{
			System.out.printf("%c: %6.2f%%%n", vals.pop(), keys.pop()*100);
		}
	}

	//Returns a string that has each character and its count
	public String toString()
	{
		String ans = "";
		for(int i=0;i<count.length;i++)
			ans += String.format("%c: %,d%n",(char)(i+65), count[i]);

		return ans;
	}



}
