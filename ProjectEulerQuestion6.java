//Ian Torres
//This program answers ProjectEueler -> Question6
package page1;

public class Project06 {

	//_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	// These variables are for the first 100
	// natural numbers
	//_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
	private int difference;
	private int sumOfSquares;
	private int squareOfSum;
	
	public int findSumOfSquares() {
		for(int i = 1; i < 101; i++) {
			sumOfSquares += Math.pow(i, 2);
		}
		return sumOfSquares;
	}
	
	public int findSquareOfSum() {
		for(int i = 1; i < 101; i++) {
			squareOfSum += i;
		}
		squareOfSum = (int) Math.pow(squareOfSum, 2);
		return squareOfSum;
	}
	
	
	public static void main(String[] args) {
	
		Project06 myProject = new Project06();
		int second = myProject.findSquareOfSum();
		int first = myProject.findSumOfSquares();
		int third = second - first;
		System.out.println("-> " + third);
		
	}
	
}
