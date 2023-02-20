
1.어노테이션이란

		스프링 프레임워크를 사용하면 어노테이션을 자주 사용하게 됩니다. 
		자바 어노테이션은 JDK5부터 추가된 기능입니다. 
		어노테이션은 자바 소스코드에 추가적인 정보를 제공하는 메타데이터입니다. 
		어노테이션은 클래스, 메서드, 변수, 인자에 추가할 수 있습니다. 
		메타 데이타이기 때문에 비즈니스 로직에 직접적인 영향을 주지 않지만, 
		이 메타데이터 정보에 따라서 실행 흐름을 변경할 수 있는 코딩이 가능하여 
		단지 어노테이션 추가만으로 더 깔끔한 코딩이 가능해집니다.


2. 어노테이션의 기본 사용

	2.1 어노테이션 타입
		어노테이션은 3가지 타입이 존재합니다. 
		
		마커 어노테이션 (Maker Annotation)
		@NewAnnotation
		
		싱글 값 어노테이션 (Single Value Annotation)
		@NewAnnotation(id=10)
		
		멀티 값 어노테이션 (Multi Value Annotation)
		@NewAnnotation(id=10, name=“hello”, roles= {“admin”, “user"})
		
		2.1.1 마커 어노테이션
			@Override 나 @Deprecated와 같은 어노테이션처럼 표시만 해두는 어노테이션입니다. 
			메서드없이 선언하면 마커 어노테이션이 됩니다. 
			
			public @interface MakerAnnotation {
			}
		
		2.1.2 싱글 값 어노테이션
			하나의 값만 입력받을 수 있는 어노테이션입니다. 
			
			public @interface SingleValueAnnotation {
			    int id();
			}
			
			@SingleValueAnnotation(id = 1)
			public class UsingSingleValueAnnotation {}
	
	2.2 어노테이션 배치하는 곳
	
		아래 예제처럼 어노테이션은 클래스, 필드 변수, 메서드 인자, 로컬변수위에 선언할 수 있습니다. 
	
		@MakerAnnotation
		public class AnnotationPlacement {
		
		    @MakerAnnotation
		    String field;
		
		    @MakerAnnotation
		    public void method1(@MakerAnnotation String str) {
		        @MakerAnnotation
		        String test;
		    }
		}			
	

3. 빌드인 어노테이션  

	자바 언어에서 제공되는 어노테이션들입니다. 
		자바 코드에 적용되는 어노테이션
			- @Override
				오버라이드되는 메서드로 표시하는 역할을 한다
				어노테이션을 추가한 메서드가 부모 클래스나 인터페이스에 존재하지 않으면 컴파일 오류를 발생시킨다
			
			- @Deprecated
				메서드를 더 이상 사용하지 않음으로 표시한다
				메서드가 사용되면 컴파일 경고를 발생시킨다
			
			- @SuppressWarnings
				컴파일시 발생하는 경고를 무시하도록 컴파일에게 알려주는 역할을 한다

		자바7이후부터 추가된 어노테이션
			- @SafeVarargs
				자바7에 추가된 어노테이션이다
				메서드가 가변인자인 경우에 잘 못 실행될 수 있는 경고 문구를 무시하도록 하는 어노테이션이다. 


		오버라이드가 안되는 메서드에만 사용 가능하다
			final, static 메서드, 생성자, private 메서드 (자바9부터)

			- @FunctionalInterface
			 	자바8부터 추가된 어노테이션으로 함수 인터페이스로 선언할때 사용된다.
		
			- @Repeatable
				같은 어노테이션을 여러번 선언할 수 있도록 해주는 어노테이션이다


		다른 어노테이션에 적용되는 어노테이션 - 메타 어노테이션(Meta Annotation)
		
			@Retention
			@Documented
			@Target
			@Inherited

			위 메타 어노테이션은 커스텀 어노테이션을 작성할 때 사용하는 어노테이션입니다. 
			각각 어떤 역할을 하는지 알아보도록 하겠습니다. 	
	
4. 커스텀 어노테이션

	4.1 메타 어노테이션

		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.TYPE)
		
		public @interface MyClassAnnotation {
		    String name();
		    String value();
		}
		
		@MyAnnotation(name = "someName", value = "Hello World")
		public class MyClassAnnotationUsing {
		}

		2개의 String 값을 받을 수 있는 간단한 커스텀 어노테이션 예제입니다. 
		각각의 메타 어노테이션이 어떤 의미를 가지고 있는지 알아볼게요. 

		@Target
			이어노테이션은 선언한 어노테이션이 적용될 수 있는 위치를 결정한다
			- ElementType Enum에 선언된 값
			- TYPE : class, interface, enum에 적용된다. 
			- FIELD : 클래스 필드 변수
			- METHOD : 메서드
			- PARAMETER : 메서드 인자
			- CONSTRUCTOR : 생성자
			- LOCAL_VARIABLE : 로컬 변수
			- ANNOTATION_TYPE : 어노테이션 타입에만 적용된다
			- PACKAGE : 패키지 
			- TYPE_PARAMETER : 자바8부터 추가된 값으로 제네릭 타입 변수에 적용된다. (ex. MyClass<T>)
			- TYPE_USE : 자바8부터 추가된 값으로 어떤 타입에도 적용된다 (ex. extends, implements, 객체 생성시등등)
			자바8 타입 어노테이션
			- MODULE : 자바9부터 추가된 값으로 모듈에 적용된다
		@Retention
			어노테이션이 어느레벨까지 유지되는지를 결정짓는다. 
			RetentionPolicy Enum에 선언된 값 
			SOURCE : 자바 컴파일에 의해서 어노테이션은 삭제된다
			CLASS : 어노테이션은 .class 파일에 남아 있지만, runtime에는 제공되지 않는 어노테이션으로 Retention policy의 기본 값이다
			RUNTIME : runtime에도 어노테이션이 제공되어 자바 reflection으로 선언한 어노테이션에 접근할 수 있다
		@Inherited
			이 어노테이션을 선언하면 자식클래스가 어노테이션을 상속 받는다
		@Documented
			이 어노테이션을 선언하면 새로 생성한 어노테이션이 자바 문서 생성시 자바 문서에도 포함시키는 어노테이션이다. 
		@Repeatable
			자바8에 추가된 어노테이션으로 반복 선언을 할 수 있게 해준다

	4.2 커스텀 어노테이션 생성
		커스텀 어노테이션을 이용해 생성한 예제들입니다. 

		예제1 - 클래스에 선언

			@Retention(RetentionPolicy.RUNTIME)
			@Target(ElementType.TYPE)
			public @interface MyClassAnnotation {
			    String name();
			    String value();
			}

			@MyClassAnnotation(name = "someName", value = "Hello World")
			public class MyClassAnnotationUsing {
			}

		예제2 - 클래스 필드에 선언
			
			@Retention(RetentionPolicy.RUNTIME)
			@Target(ElementType.FIELD)
			public @interface MyFieldAnnotation {
			    String name();
			    String value();
			}
			
			public class MyFieldAnnotationUsing {
			    @MyFieldAnnotation(name = "someName", value = "Hello World")
			    public String myField = null;
			}

		예제3 - 메서드에 선언

			@Retention(RetentionPolicy.RUNTIME)
			@Target(ElementType.METHOD)
			public @interface MyMethodAnnotation {
			    String name();
			    String value() default "기본 값";
			}
			
			public class MyMethodAnnotationUsing {
			    @MyMethodAnnotation(name = "doThisMethod", value = "Hello World")
			    public void doThis() {
			    }
			
			    @MyMethodAnnotation(name = "doThatMethod")
			    public void doThat() {
			    }
			}


	4.3 자바 리플렉션으로 커스텀 어노테이션 사용해보기
		프로그램 실행 시 커스텀 어노테이션을 사용한 곳과 지정한 값들을 얻어오려면 자바 리플렉션을 사용해야 합니다.
		
		public class MethodAnnotationExecutor {
		    public static void main(String[] args) throws NoSuchMethodException {
		        Method method = TheClass.class.getMethod("doThis”); //자바 리플렉션 getMethod로 메서드 doThis를 얻어온다
		        Annotation[] annotations = method.getDeclaredAnnotations(); //메서드에 선언된 어노테이션 객체를 얻어온다
		
		
		        for (Annotation annotation : annotations) {
		            if (annotation instanceof MyAnnotation) {
		                MyAnnotation myAnnotation = (MyAnnotation) annotation;
		                System.out.println("name: " + myAnnotation.name()); //어노테이션에 지정한 값을 프린트한다
		
		                System.out.println("value: " + myAnnotation.value());
		            }
		        }
		
		        Annotation annotation = TheClass.class.getMethod("doThat") 
		                            .getAnnotation(MyAnnotation.class); //메서드 doThat에 선언된 MyAnnotation의 어노테이션 객체를 얻어온다
		
		
		        if (annotation instanceof MyAnnotation) {
		            MyAnnotation myAnnotation = (MyAnnotation) annotation;
		            System.out.println("name: " + myAnnotation.name());
		            System.out.println("value: " + myAnnotation.value());
		        }
		    }
		}








		