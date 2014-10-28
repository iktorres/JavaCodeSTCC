//Ian Torres
//This program answers ProjectEueler -> Question8

package page1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sortingPackage.BubbleSort;

public class Project08 {

	private File myKill = null;
	private Scanner wiz = null;
	private int product;
	private static String myLongNumber = "";
	private static String[] myNumberArr;
	private static char[] myArray = null;
	private static int[] myIntegers;
	private static ArrayList<Long> productResults = new ArrayList<Long>();
	private static ArrayList<String> myListOfStrings = new ArrayList<String>();
	private static BubbleSort mine = null;

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// Default constructor does the job fine
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public Project08() {
		initializeFile();
		specialStringParser();
		parseMyNumber();
		runThroughList();
		mine = new BubbleSort(productResults, true);
		mine.printTheList2();
		//calculateSubsequences(myListOfStrings.get(1));
	}

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// This method initializes the file and
	// scanner objects
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void initializeFile() {
		myKill = new File(
				"c:\\users\\Ian Torres\\Desktop\\Summer2014Prog\\Java\\MyFolder\\MyInput.txt");

		if (myKill.exists()) {
			System.out.println("Hell Yeah Now I can get down to business!!!");
			try {
				wiz = new Scanner(myKill);
			} catch (FileNotFoundException e) {
				e.getMessage();
			}
		} else {
			myKill.getParentFile().mkdirs();
			System.out.println("We're about to be in business!");
		}

	}

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// This method loads all of the text from the
	// input file
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void specialStringParser() {
		while (wiz.hasNext()) {
			myLongNumber += wiz.next();
		}
	}

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// This method splits the 1000 digit string
	// into smaller substrings that are more
	// manageable
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void parseMyNumber() {
		myNumberArr = myLongNumber.split("0");
		for (int i = 0; i < myNumberArr.length; i++) {
			if (!(myNumberArr[i].isEmpty()) && myNumberArr[i].length() >= 13) {
				myListOfStrings.add(myNumberArr[i]);
			}
		}
	}

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	//
	//
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void runThroughList() {
		for (int i = 0; i < myListOfStrings.size(); i++) {
			//System.out.println("-> " + myListOfStrings.get(i));
			calculateSubsequences(myListOfStrings.get(i));
		}
	}

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	//
	//
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void calculateSubsequences(String number) {
		int constant = number.length() - 13 + 1;
		String[] myArrayOfStrings = new String[constant];
		int local = 13;
		for (int i = 0; i < myArrayOfStrings.length; i++) {

			myArrayOfStrings[i] = number.substring(i, local);
			middleMan(myArrayOfStrings[i]);
			//System.out.println(myArrayOfStrings[i]);
			local++;
		}

	}
	
	public void middleMan(String number) {
		myArray = number.toCharArray();
		long product = 1L;
		String temp = "";
		for(int i = 0; i < myArray.length; i++) {
			temp += myArray[i];
			product *= Integer.parseInt(temp);
			temp = "";
		}
		productResults.add(product);
	}

	public static void main(String[] args) {
		Project08 myProject = new Project08();

		// for(int i = 0; i < myListOfStrings.size(); i++) {
		// System.out.println("Length -> " + myListOfStrings.get(i).length());
		// System.out.println("Number -> " + myListOfStrings.get(i));
		// }
	}

}
