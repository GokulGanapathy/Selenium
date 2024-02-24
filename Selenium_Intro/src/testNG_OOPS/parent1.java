package testNG_OOPS;


import org.testng.annotations.Test;

public class parent1 {
	
	@Test
	public void test() {
		
		int a=10;
		child Child= new child(a);
		System.out.println(Child.increment());
		System.out.println(Child.decrement());
		System.out.println(Child.multiply());
	}

}
