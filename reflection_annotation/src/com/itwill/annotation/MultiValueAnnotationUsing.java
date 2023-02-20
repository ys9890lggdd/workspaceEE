package com.itwill.annotation;
@MultiValueAnnotation(id = 2, name = "Hello", roles = {"admin", "users"})
public class MultiValueAnnotationUsing {

    @MultiValueAnnotation(id = 10) //name = user, roles = {“anonymous’}로 지정된다
    public void testMethod() {
    }
}