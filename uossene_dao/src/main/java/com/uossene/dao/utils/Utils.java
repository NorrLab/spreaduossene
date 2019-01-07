package com.uossene.dao.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Utils {

	private Utils()
	{
		
	}
	
	public static Class<?> gerGenericClass(Class<?> clazz)
	{
		Type t = clazz.getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		if(pt.getActualTypeArguments()[0] instanceof Class)
			return (Class<?>) pt.getActualTypeArguments()[0];
		else
			return null;
	}
}
