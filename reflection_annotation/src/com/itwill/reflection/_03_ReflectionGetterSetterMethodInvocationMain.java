package com.itwill.reflection;

import java.lang.reflect.Method;

public class _03_ReflectionGetterSetterMethodInvocationMain {

	public static void main(String[] args) throws Exception {
		
		String className = "com.itwill.guest.Guest";
		String propertyName = "guest_name";
		String nameArg="김경호";
		
		
		System.out.println("1.############ 객체생성 ##############");
		Class clazz = Class.forName(className);
		Object instance = clazz.newInstance();
		System.out.println("2.######### setter 메쏘드찾기 ########");
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (isSetter(method)) {
				//System.out.println(">>>>>>>> setter: " + method);
				String methodName=method.getName();
				//System.out.println("set메쏘드이름:"+methodName);
				String targetSetMethod="set"+propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
				//System.out.println("target 메쏘드이름:"+targetSetMethod);
				if(targetSetMethod.equals(methodName)) {
					System.out.println();
					System.out.println("3.######### setter 메쏘드호출 ########");
					method.invoke(instance, nameArg);
				}
			}
		}
		System.out.println("4.######### 필드값확인 ########");
		System.out.println(instance);
		System.out.println("5.######### getter 메쏘드찾기 ########");
		methods = clazz.getMethods();
		for (Method method : methods) {
			if (isGetter(method)) {
				//System.out.println(">>>>>>>> getter: " + method);
				String methodName=method.getName();
				//System.out.println("get메쏘드이름:"+methodName);
				String targetSetMethod="get"+propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
				//System.out.println("target 메쏘드이름:"+targetSetMethod);
				if(targetSetMethod.equals(methodName)) {
					System.out.println();
					System.out.println("6.######### getter 메쏘드호출 ########");
					Object returnObject=method.invoke(instance, null);
					String returnValue=(String)returnObject;
					System.out.println("7.######### 반환값확인 ########");
					System.out.println(returnValue);
				}
			}
		}
		
	}

	public static boolean isGetter(Method method){
		  if(!method.getName().startsWith("get"))       return false;
		  if(method.getParameterTypes().length != 0)    return false;  
		  if(void.class.equals(method.getReturnType())) return false;
		  return true;
		}

	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}
}
