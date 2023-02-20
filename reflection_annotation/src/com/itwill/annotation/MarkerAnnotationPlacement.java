package com.itwill.annotation;

@MakerAnnotation
public class MarkerAnnotationPlacement {
	@MakerAnnotation
	String field;
	@MakerAnnotation
	public void method1(@MakerAnnotation String str) {
		@MakerAnnotation
		String test;
	}
}