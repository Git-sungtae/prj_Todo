package todo;

import java.util.ArrayList;

public class Test {
	String name;
	int age;
	
	public Test(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return "[name : " + name + " age + " + age + "]";
	}
	

	public static void main(String[] args) {
		ArrayList<Test> al = new ArrayList<>();
		Test test1 = new Test("장성태", 20);
		Test test2 = new Test("김영광", 40);
		Test test3 = new Test("김태산", 50);
		
		al.add(test1);
		al.add(test2);
		al.add(test3);
		
		for (Test yg : al) {
			System.out.println(yg.name);
			System.out.println(yg.age);
		}
		
		
		
	}

}
