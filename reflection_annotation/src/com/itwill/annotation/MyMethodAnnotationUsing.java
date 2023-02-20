package com.itwill.annotation;

public class MyMethodAnnotationUsing {
	@MyMethodAnnotation(name = "doThisMethod", value = "Hello World")
	public void doThis() {
	}

	@MyMethodAnnotation(name = "doThatMethod")
	public void doThat() {
	}
}