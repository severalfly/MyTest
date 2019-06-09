import java.util.*;
public class TestClass
{
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.printName();
	}
}
class Man
{
	protected String name;
	protected int age;
	protected String address;
	public Man()
	{
		this.name= "default";
	}
	public Man(String name)
	{
		this.name = name;
	}
	public void printName()
	{
		System.out.println("my name is: " + this.name);
	}

}
class Teacher extends Man
{
	protected String course;
	protected String studentsNames;
	public Teacher()
	{
		super();
		this.studentsNames = "default student names";
	}
	public Teacher(String name, String studentsNames)
	{
		super(name);
		this.studentsNames = studentsNames;
	}
}

class Charge extends Teacher
{
	protected String techerNames;
	public Charge()
	{
		super();
	}
	public Charge(Strng name, Strng studentsNames, String techerNames)
	{
		super(name, studentsNames);
		this.techerNames = "default teacher names";
	}
}

class Student extends Man
{
	protected String myTeacher;
}

class School
{
	private List<Teacher> teachers;
	private List<Student> students;
	private List<Charge> charges;

}