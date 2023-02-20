package com.itwill.reflection;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductService;

public class _05_ReflectionProductServiceMain {

	public static void main(String[] args) throws Exception{
		System.out.println("--------------------Spring설정파일(XML)-------------------------");
		String daoBeanName="productDao";
		String serviceBeanName="productService";
		String daoClassName="com.itwill.product.ProductDaoImpl";
		String serviceClassName="com.itwill.product.ProductServiceImpl";
		String propertyName="productDao";
		/*
		 * 1.Spring Bean의 설정파일을 읽어서 Spring Container객체[ApplicationContext객체]생성
		 */
		System.out.println("############### Spring Container 초기화 start ############# ");
		HashMap applicationContext=new HashMap();
		Class daoClazz = Class.forName(daoClassName);
		Class serviceClazz = Class.forName(serviceClassName);
		System.out.println("1.Spring Container  Dao,Service 객체생성");
		Object daoInstnace=daoClazz.newInstance();
		Object serviceInstance=serviceClazz.newInstance();
		applicationContext.put(daoBeanName, daoInstnace);
		applicationContext.put(serviceBeanName, serviceInstance);
		System.out.println("2.Spring Container Service객체 setter 메쏘드 호출");
		Method[] methods = serviceClazz.getMethods();
		for (Method method : methods) {
			System.out.println("\tA. >>>>>>>> 모든 method 검사: " + method);
			if (method.getName().startsWith("set")&& method.getParameterTypes().length == 1) {
				String methodName=method.getName();
				System.out.println("\tB. >>>>>>>> setter method 찾기: " + methodName);
				String targetSetMethod="set"+propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
				System.out.println("\tC. >>>>>>>> setter method 중에 호출메쏘드찾기: " + targetSetMethod);
				if(targetSetMethod.equals(methodName)) {
					System.out.println("\tD. >>>>>>>> "+targetSetMethod+" 호출");
					method.invoke(serviceInstance, daoInstnace);
				}
			}
		}
		System.out.println("############### Spring Container 초기화 end ############# ");
		
		
		System.out.println("가. Spring Container객체[ApplicationContext객체]로부터 productService란 빈이름의 객체참조얻기");
		ProductService productService=(ProductService)applicationContext.get(serviceBeanName);
		System.out.println("-------product list------");
		System.out.println(productService.productList());
		System.out.println("-------product detail------");
		System.out.println(productService.productDetail(300));
	}
	

}
