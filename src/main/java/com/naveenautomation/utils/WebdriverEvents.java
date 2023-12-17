package com.naveenautomation.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import com.naveenautomation.base.TestBase;

public class WebdriverEvents extends TestBase implements WebDriverListener {

	@Override
	public void beforeAnyCall(Object target, Method method, Object[] args) {
		System.out.println("Before calling method: " + method.getName());
	}

	@Override
	public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
		System.out.println("After calling method: " + method.getName());
	}

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		System.err.println("Error in method: " + method.getName() + ". Error: " + e.getMessage());
	}

	@Override
	public void beforeMaximize(WebDriver.Window window) {
		System.out.println("Before maximizing the window.");
	}

	@Override
	public void afterMaximize(WebDriver.Window window) {
		System.out.println("After maximizing the window.");
	}

	public void customMethod() {
		System.out.println("Executing custom method.");
	}
}