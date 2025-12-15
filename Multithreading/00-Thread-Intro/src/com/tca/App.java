package com.tca;

public class App {

	/*
	 What is main ?
	 --> It's a method !
	 
	 Yeah, It is a method, but it is also a thread, 
	 the (main) thread of your application,
	 When JVM runs your application, it creates it's thread, 
	 
	  JVM has Thread manager, which manages threads
	  */
	
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println(main);
		main.setName("Not main");
		System.out.println(main);
	}
	
	
	/*
	 Chat GPT :-
	 	 1. “main is a method” vs “main is a thread”
			main is a method:

				public static void main(String[] args)


The code inside main() executes on a thread called the main thread.

So people loosely say “main is a thread”, but correctly:

main() is a method executed by the main thread.

2. Who creates the main thread?

Not your code. Not Runnable. Not Thread.
The JVM itself creates the main thread.

Flow at high level:

You run:

java Demo


OS creates a process for the JVM.

JVM starts and initializes:

Class loader

Memory areas

Garbage collector

JVM creates one native thread → called main thread

JVM loads class Demo

JVM looks for:

public static void main(String[] args)


JVM invokes Demo.main() on the main thread

That’s it.

3. Why Runnable / Thread is NOT required for main?

Because:

Runnable / Thread is Java-level API

The main thread is JVM-level, created before your Java code runs

You only need Runnable or Thread when YOU want to create extra threads, not for the first one.

Think of it like this:

Thing	Created by
Main thread	JVM
Your custom threads	Your Java code
4. Does JVM wrap main() inside some Thread object?

Conceptually yes, implementation-wise no (not visible to you).

Internally (simplified):

JVM has native thread structure (C/C++)

That native thread is associated with a Java Thread object

Name = "main"

Priority = normal

Non-daemon

You can prove it:

public static void main(String[] args) {
    Thread t = Thread.currentThread();
    System.out.println(t.getName());      // main
    System.out.println(t.getClass());     // java.lang.Thread
}


So:

JVM already created a Thread object

Your main() is already running inside it

5. Important clarification about run()

You might be mixing this rule:

“To create a thread, you must implement Runnable or extend Thread and override run()”

Correct — but only when YOU create threads.

Example:

new Thread(() -> {
    System.out.println("New thread");
}).start();


But for main:

You are not creating it

JVM is

So no run() required.

6. Is main() similar to run()?

Conceptually:

run() → entry point of your thread

main() → entry point of your program

They serve different roles.

JVM does not do:

new Thread(Demo::main).start(); // ❌ (this is NOT how it works)


Instead:

JVM creates a native thread

Then directly calls main() using JVM internals

7. Mental model (important)

Think like this:

OS Process
   |
   └── JVM
        |
        └── Main Thread (created by JVM)
                |
                └── calls Demo.main()


After that:

If you create threads → use Thread / Runnable

If you don’t, program still runs fine on main thread

8. Final precise statement

main() is a static method.
JVM creates a special thread called the main thread before any user code runs.
That thread invokes the main() method.
Runnable / Thread is required only for threads created by user code, not for the main thread.
	 
	 */

}
