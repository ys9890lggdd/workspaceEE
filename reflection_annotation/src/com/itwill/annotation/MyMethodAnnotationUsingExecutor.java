package com.itwill.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyMethodAnnotationUsingExecutor {
	public static void main(String[] args) throws NoSuchMethodException {
		Method method = MyMethodAnnotationUsing.class.getMethod("doThis"); // 자바 리플렉션 getMethod로 메서드 doThis를 얻어온다
		Annotation[] annotations = method.getDeclaredAnnotations(); // 메서드에 선언된 어노테이션 객체를 얻어온다
		for (Annotation annotation : annotations) {
			if (annotation instanceof MyMethodAnnotation) {
				MyMethodAnnotation myAnnotation = (MyMethodAnnotation) annotation;
				System.out.println("name: " + myAnnotation.name()); // 어노테이션에 지정한 값을 프린트한다
				System.out.println("value: " + myAnnotation.value());
			}
		}

		Annotation annotation = MyMethodAnnotationUsing.class.getMethod("doThat").getAnnotation(MyMethodAnnotation.class); // 메서드 doThat에 선언된
		
		if (annotation instanceof MyMethodAnnotation) {
			MyMethodAnnotation myAnnotation = (MyMethodAnnotation) annotation;
			System.out.println("name: " + myAnnotation.name());
			System.out.println("value: " + myAnnotation.value());
		}
	}
}
