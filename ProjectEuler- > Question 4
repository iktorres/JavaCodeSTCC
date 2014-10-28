//Ian Torres

//This program takes a pair of numbers with a range of 101 - 999
//and multiplies these two numbers together. If the product of the
//two multiplied numbers is a palindrome (e.g 101 * 111 = 11211)
//then the product and its factor pair are stored into an ArrayList
//of Strings. This list is sorted using BubbleSort though BubbleSort
//takes n * n time complexity to sort the size of of the file
//is relatively small so to save time I implemented
//BubbleSort rather than QuickSort.

//This is my answer in Java to (Project Euler: question 4) 
package page1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import sortingPackage.BubbleSort;



public class Project04 {

	private int starterVar1 = 101;
	private int starterVar2 = 999;
	private int counter = 0;
	private String largestPalin = "";
	private boolean isAPalin = false;
	private ArrayList<Integer> myPalins = new ArrayList<Integer>();
	// private static ArrayList<Integer> palinFactor1 = new
	// ArrayList<Integer>();
	// private static ArrayList<Integer> palinFactor2 = new
	// ArrayList<Integer>();
	private static ArrayList<String> myPalinArr = new ArrayList<String>();
	private int myArr[];
	private int mine;
	private File myKill = null;
	
	//I used an absolute path to create my file in a specified location
	private File myKill2 = new File(
			"c:\\users\\Ian Torres\\Desktop\\Summer2014Prog\\Java\\MyFolder\\MyOutput2.txt");
	private PrintWriter myPrinter = null;
	private static BubbleSort mySort = null;

	public Project04() {
		findLargestPalindrome();
		initializeFile();
		loadArray(myPalins);
		Arrays.sort(myArr, 0, myArr.length);
	}
	
	//The purpose of this method is to break apart a preset String protocol
	//that is convenient to implement in order to keep my data altogether.
	//(e.g. (101,111) -> 11211 | (firstFactor, secondFactor) -> product)
	
	//This particular method was used to get the product from the String
	//protocol.
	//(e.g. 11211)
	
	public int stringParser(String myString) {

		try {
			String[] arr = myString.split(" -> ");
			mine = Integer.parseInt(arr[1].trim());
		} catch (NumberFormatException ex) {
			System.out.println("You have formatting issues!");
			return 0;
		}

		return mine;

	}

	//This particular method was used to get the factors from the String
	//protocol.
	//(e.g. {101, 111})
	
	public int[] stringParserFactors(String myString) {
		char[] myChars = myString.toCharArray();
		int[] myFactors = new int[2];
		String myNewString1 = "";
		String myNewString2 = "";
		int startIndex1 = 0;
		int endIndex1 = 0;
		int startIndex2 = 0;
		int endIndex2 = 0;
		try {
			for(int i = 0; i < myChars.length; i++) {
				if(myChars[i] == '(') {
					startIndex1 = i + 1;
				}else if(myChars[i] == ',') {
					endIndex1 = i;
					startIndex2 = i + 1;
				}else if(myChars[i] == ')') {
					endIndex2 = i;
				}
			}
		
			for(int i = startIndex1; i < endIndex1; i++) {
				myNewString1 += myChars[i];
			}
			for(int i = startIndex2; i < endIndex2; i++) {
				myNewString2 += myChars[i];
			}
			
			myFactors[0] = Integer.parseInt(myNewString1);
			myFactors[1] = Integer.parseInt(myNewString2);
		} catch (NumberFormatException ex) {
			System.out.println("You have formatting issues!");
		}

		return myFactors;
	}
	
	//This is used to establish the file connection & hierarchies

	public void initializeFile() {
		myKill = new File(
				"c:\\users\\Ian Torres\\Desktop\\Summer2014Prog\\Java\\MyFolder\\MyOutput.txt");

		if (myKill.exists()) {
			System.out.println("Hell Yeah Now I can get down to business!!!");
		} else {
			myKill.getParentFile().mkdirs();
			System.out.println("We're about to be in business!");
		}

	}
	
	//This is pretty self explanatory

	public void loadArray(ArrayList<Integer> array) {
		myArr = new int[array.size()];
		int temp;
		for (int i = 0; i < array.size() - 1; i++) {
			temp = array.get(i);
			myArr[i] = temp;
		}
	}
	
	//This is the method that runs through every single combonation
	//of products that are within range of 101 - 999. But it runs twice
	//so it is unoptimized.

	public String findLargestPalindrome() {
		int product = 0;
		String myProduct;
		while (starterVar2 != 101) {

			product = starterVar1 * starterVar2;
			myProduct = "" + product;
			if (isPalinDrome(myProduct)) {
				myPalins.add(product);
				myPalinArr.add("(" + starterVar1 + "," + starterVar2 + ")"
						+ " -> " + product);
			}
			counter++;
			starterVar1++;
			if (counter == 999 || ("" + starterVar1).length() == 4
					|| ("" + starterVar2).length() == 4) {
				counter = 0;
				starterVar2--;
				starterVar1 = 101;
			}
		}

		return largestPalin;
	}
	
	//This prints the array of palindromes to a file

	public void printMyList() {
		try {
			myPrinter = new PrintWriter(myKill2);
			for (int i = 0; i < myPalinArr.size() - 1; i++) {
				myPrinter.println(myPalinArr.get(i));
				myPrinter.flush();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}finally {
			try {
				myPrinter.close();
			} catch (Exception ex) {
				ex.getMessage();
				System.out.println("Nope a roony!");
			}
		}
	}
	
	//Recursive helper method for finding palindromes

	public boolean isPalinDrome(String number) {
		return isPalinDrome2(number, 0, number.length() - 1);
	}
	
	//Recursive method to find palindromes

	public boolean isPalinDrome2(String number, int start, int stop) {

		if (start > stop) {
			isAPalin = true;
		} else if (number.charAt(start) == number.charAt(stop)) {
			start++;
			stop--;
			isPalinDrome2(number, start, stop);
		} else
			isAPalin = false;

		return isAPalin;

	}
	
	//The main driver is provided, once the object is created the
	//program is designed to just run so all you have to do
	//is open the file scroll to the bottom of the list and you
	//will have the answer to question 4

	public static void main(String[] args) throws FileNotFoundException {
		int[] myArray;
		Project04 myProject = new Project04();
		myArray = myProject.stringParserFactors("(101,111) -> 11211");
		for(int i = 0; i < myArray.length; i++) {
			System.out.println("-> " + myArray[i]);
		}
		mySort = new BubbleSort(myPalinArr);
		myProject.printMyList();

	}

}
