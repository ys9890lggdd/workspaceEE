package com.itwill.reflection;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.itwill.guest.GuestService;
import com.itwill.product.ProductDao;
import com.itwill.product.ProductServiceImpl;

public class _04_ReflectionGuestServiceMain {

	public static void main(String[] args) throws Exception{
		System.out.println("--------------------Spring설정파일(XML)-------------------------");
		String dataSourceBeanName="dataSource";
		String daoBeanName="guestDao";
		String serviceBeanName="guestService";
		
		String dataSourceClassName="com.itwill.guest.DataSource";
		String daoClassName="com.itwill.guest.GuestDaoImpl";
		String serviceClassName="com.itwill.guest.GuestServiceImpl";
		
		String daoPropertyName="dataSource";
		String servicePropertyName="guestDao";
		/*
		 * 1.Spring Bean의 설정파일을 읽어서 Spring Container객체[ApplicationContext객체]생성
		 */
		System.out.println("############### Spring Container 초기화 start ############# ");
		HashMap applicationContext=new HashMap();
		Class dataSourceClazz = Class.forName(dataSourceClassName);
		Class daoClazz = Class.forName(daoClassName);
		Class serviceClazz = Class.forName(serviceClassName);
		System.out.println("1.Spring Container  Dao,Service 객체생성");
		Object dataSourceInstnace=dataSourceClazz.newInstance();
		Object daoInstnace=daoClazz.newInstance();
		Object serviceInstance=serviceClazz.newInstance();
		applicationContext.put(dataSourceBeanName, dataSourceInstnace);
		applicationContext.put(daoBeanName, daoInstnace);
		applicationContext.put(serviceBeanName, serviceInstance);
		
		System.out.println("2.Spring Container Dao객체 setter 메쏘드 호출");
		Method[] methods = daoClazz.getMethods();
		for (Method method : methods) {
			System.out.println("\tA. >>>>>>>> 모든 method 검사: " + method);
			if (method.getName().startsWith("set")&& method.getParameterTypes().length == 1) {
				String methodName=method.getName();
				System.out.println("\tB. >>>>>>>> setter method 찾기: " + methodName);
				String targetSetMethod="set"+daoPropertyName.substring(0, 1).toUpperCase()+daoPropertyName.substring(1);
				System.out.println("\tC. >>>>>>>> setter method 중에 호출메쏘드찾기: " + targetSetMethod);
				if(targetSetMethod.equals(methodName)) {
					System.out.println("\tD. >>>>>>>> "+targetSetMethod+" 호출");
					method.invoke(daoInstnace, dataSourceInstnace);
				}
			}
		}
		
		System.out.println("3.Spring Container Service객체 setter 메쏘드 호출");
		methods = serviceClazz.getMethods();
		for (Method method : methods) {
			System.out.println("\tA. >>>>>>>> 모든 method 검사: " + method);
			if (method.getName().startsWith("set")&& method.getParameterTypes().length == 1) {
				String methodName=method.getName();
				System.out.println("\tB. >>>>>>>> setter method 찾기: " + methodName);
				String targetSetMethod="set"+servicePropertyName.substring(0, 1).toUpperCase()+servicePropertyName.substring(1);
				System.out.println("\tC. >>>>>>>> setter method 중에 호출메쏘드찾기: " + targetSetMethod);
				if(targetSetMethod.equals(methodName)) {
					System.out.println("\tD. >>>>>>>> "+targetSetMethod+" 호출");
					method.invoke(serviceInstance, daoInstnace);
				}
			}
		}
		System.out.println("############### Spring Container 초기화 end ############# ");
		
		System.out.println("가. Spring Container객체[ApplicationContext객체]로부터 "+serviceBeanName+"란 빈이름의 객체참조얻기");
		GuestService guestService=(GuestService)applicationContext.get("guestService");
		System.out.println(guestService.selectAll());
	}
	

}
