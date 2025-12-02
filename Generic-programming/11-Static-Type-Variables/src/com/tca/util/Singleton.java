package com.tca.util;

public class Singleton<T> 
{ 
	/*
	private static T singleInstance; // ERROR
	
	public static T getSingleInstance() // ERROR 
	{ 
		if (singleInstance == null) construct new instance of T 
		return singleInstance; 
	} 
	*/
}

/*
	We can't use a type variable with static members.

	If we write something like:

	private static T singleInstance;      // ERROR
	public static T getSingleInstance()   // ERROR

	and then try:

	Singleton<String> s;
	s.get...()

	and

	Singleton<Integer> r;
	r.get...()

	the problem is this:

	After type-erasure,
	Singleton<T> becomes just Singleton,
	and T becomes Object.

	So the static field becomes:

	static Object singleInstance;

	and the static method will also return Object.

	Static members are shared across all type parameters,
	so the same Object instance would be used for
	Singleton<String>, Singleton<Integer>, Singleton<Employee>, etc.

	That means we can never have separate objects for each T,
	and returning Object and casting is unsafe.

	Therefore, type variables cannot be used in static fields or static methods.

	

*/
