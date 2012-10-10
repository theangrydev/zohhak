package net.piotrturski.mintaka.internal.model;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import net.piotrturski.mintaka.Configuration;
import net.piotrturski.mintaka.TestWith;

public class SingleTestMethod {

	public Configuration configuration;
	public final String parametersLine;
	private String[] splitedParameters;
	public final Method realMethod;
	public final TestWith annotation;
	private final Type[] genericParameterTypes;

	public SingleTestMethod(Method realMethod, int lineIndex) {
		this.realMethod = realMethod;
		annotation = realMethod.getAnnotation(TestWith.class);
		parametersLine = annotation.value()[lineIndex];
		genericParameterTypes = realMethod.getGenericParameterTypes();
	}

	public void setSplitedParameters(String[] splitedParameters) {
		this.splitedParameters = splitedParameters;
	}

	public Type getParameterType(int nr) {
		return genericParameterTypes[nr];
	}
	
	public String getInputString(int nr) {
		return splitedParameters[nr];
	}
	
	public int getArity() {
		return genericParameterTypes.length;
	}
	
}