package com.spring.tutorial.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	/*
	 * Pointcut: Pointcut are expressions that is matched with join points to
	 * determine whether advice needs to be executed or not. Pointcut uses
	 * different kinds of expressions that are matched with the join points and
	 * Spring framework uses the AspectJ pointcut expression language.
	 */

	/*
	 * @Before annotation is used to create Before advice, similarly others
	 */

	// "execution(public String simpleEmployeeGetter())" are the pointcut
	// expressions

	@After("execution(public String simpleEmployeeGetter())")
	public void logAfterAllMethods1(JoinPoint joinPoint) {
		System.out.println("****LoggingAspect.logAfterAllMethods1() : " + joinPoint.getSignature().getName());
	}

	@After("execution(public String simpleEmployeeGetter())")
	public void logAfterAllMethods2() {
		System.out.println("****LoggingAspect.logAfterAllMethods1() : with no arguments");
	}

	@After("execution(* com.spring.tutorial.service.EmployeeManagerImpl.*(..))")
	public void logAfterAllMethods3(JoinPoint joinPoint) {
		System.out.println("****LoggingAspect.logAfterAllMethods3() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.spring.tutorial.service.EmployeeManagerImpl.getEmployeeById(..))")
	public void logAfterGetEmployee(JoinPoint joinPoint) {
		System.out.println("****LoggingAspect.logAfterGetEmployee() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.spring.tutorial.service.EmployeeManagerImpl.createEmployee(..))")
	public void logAfterCreateEmployee(JoinPoint joinPoint) {
		System.out.println("****LoggingAspect.logAfterCreateEmployee() : " + joinPoint.getSignature().getName());
	}

	/*
	 * We can use asterisk (*) as wild card in Pointcut expressions,
	 * getAllAdvice() will be applied for all the classes in
	 * com.spring.tutorial.service package
	 */
	/*
	 * @After("execution(* com.spring.tutorial.service.*())") public void
	 * getAllAdvice() {
	 * System.out.println("****LoggingAspect.getAllAdvice() : "); }
	 */

	@AfterReturning(pointcut = "execution(* com.spring.tutorial.service.EmployeeManagerImpl.addEmployeeReturnValue(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}

	/*
	 * Around aspect to cut the method execution before and after
	 */
	@Around("execution(* com.spring.tutorial.service.EmployeeManagerImpl.addEmployeeAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("Around before is running!");
		joinPoint.proceed(); // continue on the intercepted method
		System.out.println("Around after is running!");

		System.out.println("******");
	}

	/*
	 * Around advice are always required to have ProceedingJoinPoint as argument
	 * and we should use it’s proceed() method to invoke the target object
	 * advised method. If advised method is returning something, it’s advice
	 * responsibility to return it to the caller program. For void methods,
	 * advice method can return null. Since around advice cut around the advised
	 * method, we can control the input and output of the method as well as it’s
	 * execution behavior
	 */
	@Around("execution(* com.spring.tutorial.service.EmployeeManagerImpl.addEmployeeAround(..))")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println(">>>>>>> Before invoking addEmployeeAround() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>> After invoking addEmployeeAround() method. Return value=" + value);
		return value;
	}

	/*
	 * If you look at all the above advices pointcut expressions, there are
	 * chances that they gets applied to some other beans where it’s not
	 * intended. For example, someone can define a new spring bean with
	 * getName() method and the advices will start getting applied to that even
	 * though it was not intended. That’s why we should keep the scope of
	 * pointcut expression as narrow as possible.
	 * 
	 * An alternative approach is to create a custom annotation and annotate the
	 * methods where we want the advice to be applied. This is the purpose of
	 * having Employee customAnnotationDemoMethod() method annotated
	 * with @Loggable annotation.
	 */
	@Before("@annotation(com.spring.tutorial.custom.annotation.Loggable)")
	public void myAdvice() {
		System.out.println(":::::: Executing myAdvice before a method annotated by Loggable !!");
	}

}
