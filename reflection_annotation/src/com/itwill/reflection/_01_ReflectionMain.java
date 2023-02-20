package com.itwill.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.itwill.guest.Guest;

public class _01_ReflectionMain {
	public static void main(String[] args) throws Exception {
		String className = "com.itwill.guest.GuestServiceImpl";
		Class clazz = Class.forName(className);
		//Class clazz=Guest.class;
		
		
		
		
		Method[] public_methods = clazz.getMethods();
		Method[] all_methods = clazz.getDeclaredMethods();
		Field[] public_fields = clazz.getFields();
		Field[] all_fields = clazz.getDeclaredFields();
		Constructor[] public_constructors = clazz.getConstructors();
		Constructor[] all_constructors = clazz.getDeclaredConstructors();

		System.out.println("################### all_methods #################");
		for (int i = 0; i < all_methods.length; i++) {
			System.out.println("<<< " + public_methods[i].toString() + " >>>");
			Method m = all_methods[i];
			System.out.println("메쏘드        이름 = " + m.getName());
			System.out.println("메쏘드선언된클래스 = " + m.getDeclaringClass());
			Class parameterClazzArray[] = m.getParameterTypes();
			for (int j = 0; j < parameterClazzArray.length; j++)
				System.out.println("메쏘드    파라메타" + j + "= " + parameterClazzArray[j]);
			System.out.println("메쏘드    반환타입 = " + m.getReturnType());
			System.out.println("-----------------------------");

		}
		System.out.println("################### all_fields #################");
		for (int i = 0; i < all_fields.length; i++) {
			System.out.println("<<< " + all_fields[i].toString() + " >>>");
			Field fld = all_fields[i];
			System.out.println("필드  이름 = " + fld.getName());
			System.out.println("필드클래스 = " + fld.getDeclaringClass());
			System.out.println("필드  타입 = " + fld.getType());
			int mod = fld.getModifiers();
			System.out.println("필드제한자 = " + Modifier.toString(mod));
			System.out.println("-------------------");

		}
		System.out.println("------------all_constructors-------------");
		for (int i = 0; i < all_constructors.length; i++) {
			System.out.println("<<< " + all_constructors[i].toString() + " >>>");
			Constructor constructor = all_constructors[i];
			System.out.println("생성자      이름 = " + constructor.getName());
			System.out.println("생성자선언클래스 = " + constructor.getDeclaringClass());
			Class[] parameterClazzArray = constructor.getParameterTypes();
			for (int j = 0; j < parameterClazzArray.length; j++)
				System.out.println(" 생성자파라메타 #" + j + " " + parameterClazzArray[j]);
		}
		
		
	



	}
}
