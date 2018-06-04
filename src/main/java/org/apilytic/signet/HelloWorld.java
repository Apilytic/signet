package org.apilytic.signet;

import io.reactivex.Flowable;

public class HelloWorld {

	public static void main(String[] args) {
		Flowable.just("Hell World").subscribe(System.out::println);
	}
}
