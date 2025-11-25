package com.tca;

import com.tca.util.Pair;

public class App {

	public static void main(String[] args) {
		
		Pair<Integer> pair1 = new Pair<>(2,3);
		Pair<String> pair2 = new Pair<>("Dnyaneshwar", "Computer Science");
		
		//No need to cast return type, compiler knows the return type is the specified type <Integer>, <String>
		System.out.println("Pair 1, first value  : " + pair1.getFirstVal());
		System.out.println("Pair 1, second value : " + pair1.getSecondVal());
		
		System.out.println("Pair 2, first value  : " + pair2.getFirstVal());
		System.out.println("Pair 2, second value : " + pair2.getSecondVal());
		
		System.out.println(pair1.getClass() == pair2.getClass());
		
		/*
		 Type Erasure happens at the time of compilation.
		 	At the time of compilation
		 	The Type parameter is replaced by Object class
		 	if it is unbounded. 
		 	
		 	(unbounded means it is not extending anything, like <T extends Comparable>)
		 	
		 	for ex. 
		 	class Pair<T>{
		 		T firstVal;
		 		T secondVal;
		 	}
		 	
		 	so after compilation this class will looks like
		 	class Pair{
		 		Object firstVal;
		 		Object secondVal;
		 	}
		 	
		 	Then why don't we need cast when we get these value,
		 	that is because, compiler also adds silent casting, 
		 	
		 	i.e. suppose we do like this
		 	Pair<Integer> p = new Pair<>(1,2);
		 	Integer a = p.getFirstVal();
		 	
		 	then after compilation it will look like
		 	Integer a = (Integer) p.getFirstVal();
		 	
		 	compiler knows that, the Type is Integer
		 	
		 	and for bounded WildCards/Types
		 	i.e for <T extends Comparable>
		 	
		 	all types are replaced by Comparable
		 	
		 	ex. 
		 	class Pair<T extends Comparable>{
		 		T firstVal;
		 		T secondVal;
		 	}
		 	
		 	so after compilation this class will looks like
		 	class Pair{
		 		Comparable firstVal;
		 		Comparable secondVal;
		 	}
		 	
		 	and if there are multiple bounds
		 	like <T extends Comparable & Serializable>
		 	
		 	The Type is replaced by the first bound 
		 	which is  ''Comparable'' , in  this case, 
		 	
		 	
		 	and because of this,
		 	if there are multiple bounds, and one of the bound is a Class
		 	then that class should written first
		 	multiple classes for as bounds are not allowed,
		 	because in Java a class extends from only one class
		 	
		 	 what is we write an Interface as first bound and then write a class
		 	 then in this case,
		 	 the type will be replaced by the first interface, and the actual class will be lost
		 	
		 	
		 */
		
		
	}
	
}
