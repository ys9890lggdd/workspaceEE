package com.itwill.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class _02_ReflectionCreateInstanceMethodInvocationMain {

	public static void main(String[] args) throws Exception{
		System.out.println("############ 새로운 객체 만들기 ###########");
		String className = "com.itwill.guest.Guest";
		Class clazz = Class.forName(className);
		/*
		Class parameterTypeArray[] = new Class[2];
		parameterTypeArray[0] = Integer.TYPE;
		parameterTypeArray[1] = Integer.TYPE;			
		Constructor ct = clazz.getConstructor(parameterTypeArray);
		Object argumentList[] = new Object[2];			
		argumentList[0] = new Integer(37);			
		argumentList[1] = new Integer(47);			
		Object retobj = ct.newInstance(argumentList);
		*/
		Object newInstance=clazz.newInstance();
		System.out.println(newInstance);
		
		System.out.println("############ 이름으로 setGuest_no 메쏘드 실행하기 ###########");
		Class[]  parameterClassTypes= new Class[1];
		parameterClassTypes[0] = Integer.TYPE;
		Method method = clazz.getMethod("setGuest_no",parameterClassTypes[0] );
		Object[] argumentArray= new Object[1];
		argumentArray[0] = new Integer(8888);			
		Object returnObject = method.invoke(newInstance, argumentArray);
		System.out.println("############ 이름으로 getGuest_no 메쏘드 실행하기 ###########");
		parameterClassTypes = new Class[0];
		method = clazz.getMethod("getGuest_no",parameterClassTypes);
		argumentArray = new Object[0];
		returnObject = method.invoke(newInstance, argumentArray);
		Integer returnIntegerValue = (Integer) returnObject;
		System.out.println(returnIntegerValue.intValue());
		System.out.println("############ 이름으로 setGuest_name 메쏘드 실행하기 ###########");
		parameterClassTypes= new Class[1];
		parameterClassTypes[0] = String.class;
		method = clazz.getMethod("setGuest_name",parameterClassTypes[0] );
		argumentArray= new Object[1];
		argumentArray[0] = "제임스딘";			
		returnObject = method.invoke(newInstance, argumentArray);
		System.out.println("############ 이름으로 getGuest_name 메쏘드 실행하기 ###########");
		parameterClassTypes = new Class[0];
		method = clazz.getMethod("getGuest_name",parameterClassTypes);
		argumentArray = new Object[0];
		returnObject = method.invoke(newInstance, null);
		String returnStringValue = (String)returnObject;
		System.out.println(returnStringValue);
		System.out.println("############ 필드값 바꾸기 ###########");
		Field field = clazz.getDeclaredField("guest_name");
		field.setAccessible(true);
		field.set(newInstance,"공유");			
		System.out.println(newInstance);
		
	}

}
