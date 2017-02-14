public class TestComposite
{
	public static void main(String[] args)
	{
		Wolf w = new Wolf(new Animal());
		w.breath();
		w.run();

		System.out.println();
		Bird b = new Bird(new Animal());
		b.breath();
		b.fly();
	}
}
class Animal
{
	private void beat()
	{
		System.out.println("bang bang");
	}
	public void breath()
	{
		beat();
		System.out.println("breath");
	}
}

class Bird
{
	private Animal a;
	public Bird(Animal a)
	{
		this.a = a;
	}
	public void breath()
	{
		a.breath();
	}
	public void fly()
	{
		System.out.println("bird fly");
	}

}

class Wolf
{
	private Animal a ;
	public Wolf(Animal a)
	{
		this.a = a;
	}
	public void breath()
	{
		a.breath();
	}
	public void run()
	{
		System.out.println("run");
	}
}