package com.itwill.annotation;

public @interface MultiValueAnnotation {
    int id();
    String name() default "user"; //미지정시 기본 값으로 user가 지정된다
    String[] roles() default {"anonymous"};
}