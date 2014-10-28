//Ian Torres
//This program is designed to add the first 34 numbers of
//the Fibonacci Sequence. It answers ProjectEueler -> Question1
package page1;

import java.util.ArrayList;

public class Project02 {

	private ArrayList<Integer> myList = new ArrayList<Integer>();
	private int sum;
	
	public void generateFibonacci() {
		
		int counter = 0;
		int i = 0;
		int j = 1;
		int bum = 0;
		myList.add(i);
		myList.add(j);
		while(counter < 34) {
			bum = i + j;
			i = j;
			j = bum;
			myList.add(bum);
			System.out.println(myList.get(counter));
			counter++;
		}
	}
	
	public void sumEvenFibonacciNumbers() {
		for(int i = 0; i < myList.size(); i++) {
			if(myList.get(i) % 2 == 0) {
				sum += myList.get(i);
			}
		}
		System.out.println("The sum of the Even Fib is -> " + sum);
	}
	
	public static void main(String[] args) {
		Project02 myProject = new Project02();
		myProject.generateFibonacci();
		myProject.sumEvenFibonacciNumbers();
	}
}
