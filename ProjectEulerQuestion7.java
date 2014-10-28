//Ian Torres
//This program answers ProjectEueler -> Question7
package page1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Project07 {

	private File myKill = null;
	private PrintWriter myPrinter = null;
	private ArrayList<Long> myList = new ArrayList<Long>();
	private int counter = 0;
	private long factorableNumberCounter = 0L;

	public Project07() {
		initializeFile();
		findThe10001PrimeNumber();
		sendPrimesToFile();
	}

	public Project07(String password) {

	}
	
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// Beware instantiating this method will cause
	// the program to run for 37 minutes
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void findThe10001PrimeNumber() {
		long i = 1L;
		long currentElement = 0L;
		while (currentElement < 2000000) {
			System.out.println("Counter -> " + counter + " -> " + currentElement);
			if (isPrime(i)) {
				currentElement = i;
				myList.add(i);
				counter++;
			} else
				factorableNumberCounter++;
			i++;
		}
		System.out.println("10001 prime -> " + myList.get(myList.size() - 1));
		System.out.println("Factorable Numbers -> " + factorableNumberCounter);
	}

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// This method is for research purposes
	//
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void findThe10001PrimeNumber(int limit) {
		long i = 1L;
		while (!(counter == limit)) {
			if (isPrime(i)) {
				System.out.println("P -> " + i);
				myList.add(i);
				counter++;
			} else {
				System.out.println("I -> " + i);
				factorableNumberCounter++;
			}
			i++;
		}
		System.out.println("Factorable Numbers -> " + factorableNumberCounter);
	}

	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// &*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*
	// &*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*
	// _+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

	public void sendPrimesToFile() {
		try {
			myPrinter = new PrintWriter(myKill);
			myPrinter.println("Prime Numbers 1-10001");
			myPrinter.flush();
			for (int i = 0; i < myList.size(); i++) {
				myPrinter.println(i + " ->" + myList.get(i));
				myPrinter.flush();
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} finally {
			try {
				myPrinter.close();
			} catch (Exception ex) {
				ex.getMessage();
				System.out.println("Nope a roony!");
			}
		}
	}

	public boolean isPrime(long number) {
		for (int i = 2; i < number - 1; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void initializeFile() {
		myKill = new File(
				"c:\\users\\Ian Torres\\Desktop\\Summer2014Prog\\Java\\MyFolder\\MyOutput3.txt");

		if (myKill.exists()) {
			System.out.println("Hell Yeah Now I can get down to business!!!");
		} else {
			myKill.getParentFile().mkdirs();
			System.out.println("We're about to be in business!");
		}

	}

	public static void main(String[] args) {
		Project07 myProject = new Project07();
//		Project7 myProject2 = new Project7("SecretPassword");
//		myProject2.findThe10001PrimeNumber(25);

	}

}
