package com.itwill.guest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductServiceImpl;

public class ReflectionAnnotationGuestServiceMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 1.com.itwill.guest package에있는 모든클래스의  @Annotation을 읽어서 
		 *   Spring Container객체[ApplicationContext객체]생성
		 */
		System.out.println("############### Spring Container 초기화 start ############# ");
		HashMap applicationContext = new HashMap();

		
		
		Class guestPackageClass0 = DataSource.class;
		Class guestPackageClass1 = GuestDaoImpl.class;
		Class guestPackageClass2 = GuestServiceImpl.class;
		Class[] guestPackageClasses = new Class[3];
		guestPackageClasses[0] = guestPackageClass0;
		guestPackageClasses[1] = guestPackageClass1;
		guestPackageClasses[2] = guestPackageClass2;

		System.out.println("--------@MyComponent 객체생성--------------");
		for (Class clazz : guestPackageClasses) {
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof MyComponent) {
					System.out.println(clazz.getSimpleName() + ":" + annotation);
					MyComponent myComponent = (MyComponent) annotation;
					String componentName = myComponent.value();
					Object newInstance = clazz.newInstance();
					applicationContext.put(componentName, newInstance);
				}
			}
		}

		System.out.println("--------@MyAutoWire setter method호출--------------");
		Iterator<String> beanIdIterator= applicationContext.keySet().iterator();
		while (beanIdIterator.hasNext()) {
			String beanId=beanIdIterator.next();
			Object beanInstance=applicationContext.get(beanId);
			Class beanClass=beanInstance.getClass();
			Method[] methods = beanInstance.getClass().getMethods();
			for (Method method : methods) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					if (annotation instanceof MyAutoWire) {
						MyAutoWire myAutoWire = (MyAutoWire) annotation;
						System.out.println(myAutoWire);
						System.out.println(beanClass.getSimpleName() + ":" + method);
						String componentId = myAutoWire.value();
						Object injectionObject=applicationContext.get(componentId);
						method.invoke(beanInstance, injectionObject);
						
					}
				}
			}
		}

		//System.out.println(applicationContext);
		System.out.println("############### Spring Container 초기화 end ############# ");

		System.out.println("가. Spring Container객체[ApplicationContext객체]로부터 guestService 란 빈이름의 객체참조얻기");
		 GuestService guestService = (GuestService) applicationContext.get("guestService");
		 System.out.println(guestService.selectAll());
	}

}
