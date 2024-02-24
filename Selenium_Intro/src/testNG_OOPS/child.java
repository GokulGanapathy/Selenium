package testNG_OOPS;

public class child extends child2{
	int a;
	
	public child(int a)
	{
		super(a);
		this.a=a;
	}
	
	public int increment() {
		a=a+5;
		return a;
	}
	
	public int decrement() {
		a=a-5;
		return a;
	}

}
