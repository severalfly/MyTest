package leon.reflect;
import java.lang.reflect.*;

public class ClassTest
{
	private ClassTest()
	{

	}
	public ClassTest(String name)
	{
		System.out.println("constructors with paramters");
	}
	public void info(String str)
	{
		System.out.println("info method with paramters, the param is: " + str );
	}
	class Inner
	{

	}
	public static void main(String[] args) throws Exception{
		Class<ClassTest> clazz = ClassTest.class;

		Constructor[] ctors = clazz.getDeclaredConstructors();
		System.out.println("all the constructors as follows:");
		for (Constructor c  : ctors) {
			System.out.println(c);
		}
		Method[] mtds = clazz.getMethods();
		System.out.println("all the public method is:");
		for (Method md : mtds) {
			System.out.println(md);
		}

	}
}