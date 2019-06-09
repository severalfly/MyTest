package leon.server;
public class Test
{
	public static void main(String[] args) {
		System.out.println(MyTest.compileContant);
		System.out.println(MyTest.a);
	}
}

class MyTest
{
	static
	{
		System.out.println("static initial...");
	}
	static String compileContant = "compileContant Test";
	static int a = 5;
}