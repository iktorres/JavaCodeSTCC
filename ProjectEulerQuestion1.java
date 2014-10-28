//Ian Torres
//This is a simple program used to answer ProjectEuler -> Question 1

package page1;

public class Project01 {
	
	private int sum;
	
	
	public Project01(int limit) {
		int value = integerTester(limit);
		System.out.println("Your sum with limit -> " + limit + " is -> " + sum);
	}
	
	public int integerTester(int limit) {
		
		for(int i = 0; i < limit; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Project01 myProject = new Project01(10);
		Project01 myProject2 = new Project01(1000);
	}
	

}
