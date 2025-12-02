package com.tca.util;

public interface Task {

	@SuppressWarnings("unchecked")
	public static <T extends Throwable> void throwAs(Throwable t) throws T{
		throw (T)t;
	}
}
