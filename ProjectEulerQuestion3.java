//Ian Torres
//This program is designed see what the highest prime factor
//of the given number was. It answers ProjectEueler -> Question3

package page1;

public class Project03 {

	boolean isDone = false;

	public boolean isPrime(long number) {
		for (int i = 2; i < number - 1; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	//I just didn't want to erase this so I could see
	//what alternative solution I could use.
	
	public long highestPrimeFactor(long number) {
		long i = 2L;
		if (!isPrime(number)) {
			long temp = 1;
			while (i < number - 1) {
				if (number % i == 0 && isPrime(i))
					temp = i;
				i++;
			}
			return temp;
		} else
			return number;
	}

	public long highestPrimeFactor2(long number) {
		long i = 2L;
		long temp = 2L;
		while(temp <= number) {
			//System.out.println("This is number -> " + number);
			if (number % i == 0) {
				number /= i;
				if(isPrime(i))
					temp = i;
			}
			else
				i++;
		}
		return temp;
	}

	public static void main(String[] args) {
		Project03 myProject = new Project03();
		long myNumber = 60085147514L;
		boolean myBool = myProject.isPrime(10976461);
		System.out.println("Is your number prime -> " + myBool);
		System.out.println("What is the highest prime number -> "
				+ myProject.highestPrimeFactor2(myNumber));
	}

}
