//Ian Torres
//This program answers ProjectEueler -> Question5
package page1;

public class Project05 {

	private int testingNumber = 19;
	private int targetNumber = 0;
	private int count = 1;
	private boolean isSatisfied = false;
	
	
	public int isEvenlyDivisible() {
		int i = 1;
		while(!isSatisfied) {
			if(count == 20) {
				isSatisfied = true;
				targetNumber = testingNumber;
			}
			if(testingNumber % i == 0) {
				i++;
				count++;
			}else {
				i = 1;
				count = 1;
				testingNumber++;
			}
		}
		
		return targetNumber;
	}
	
	
	
	public static void main(String[] args) {
		Project05 myProject = new Project05();
		
		System.out.println(myProject.isEvenlyDivisible());
		
		
	}
	
}
