import java.util.*;

public class Test {
	public static void main(String[] args) throws Exception {
		int cnt = 0;
	  while(true)
	  {
	  	cnt ++;
	  	int[] test = new int[10000];
	  	System.out.println("the " + cnt + " times");
	  	Thread.sleep(1000);
	  	new A(cnt+"").start();
	  }
	}
}
class A extends Thread{
	String name;
	public A(String a) {
		name=a;
	}
	public void getMyName(){
		System.out.println("name:"+name);
	}
}
