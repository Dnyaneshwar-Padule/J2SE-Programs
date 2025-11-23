package com.tca;

public class App {

	public static void main(String[] args) {

		int a = 5;
		int b = 10;
		String str = "One";
		
		System.out.println(a + b); // ini + int = int
		System.out.println(a + b + str); // int + int =   int + str = str  
		System.out.println(str + a + b); // str + int =   str + int = str  
		//System.out.println(2++); // error, ++ is a post increment operator, it operates on a variable, not on an expression, 2 is an expression
		//System.out.println(a ++ b); // error, ++ is post increment operator, which operates only on a, it is like (a++) (b), in a and b there is no operator 
		System.out.println(a +++ b); // pretendes as, (a++) +b, so valid
		System.out.println(a);
		//System.out.println(a ++++ b); // error, pretended as, (a++) (++b), there is no operator between a and b
		System.out.println(a ++-++ b); // pretended as, (a++) - (++b), there is minus operator between a++ and ++b
		System.out.println(a + + b); // pretended as a+ (+b), so valid
		System.out.println(2 +- 3); // pretended as 2 + (-3) = (2 - 3)
		System.out.println(2 -+ 3); // pretended as 2 - (+3) = (2 - 3)
		
		//System.out.println(a++++); // error, pretended as (a++)++, here first two plus works as post increment operator, and next two plus also works as post increment operator, but first post increment operator gives a result as a expression, and second post increment operator can not work with expression
	}

}
