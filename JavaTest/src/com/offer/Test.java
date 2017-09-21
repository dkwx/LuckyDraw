package com.offer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static <T extends Collection<K>, K,N extends Collection<K>> N selectValueFromColl2(
			final T coll, Class<K> clazz, Class<N> collClass, String fieldName,
			Object value) {
		try {
			// 返回值反射
			N returnColl = collClass.newInstance();

			Iterator<K> it = coll.iterator();

			while (it.hasNext()) {
				K obj = it.next();
				// 循环迭代查找该类以及该父类有没有该属性
				Field f = getDeclaredField(clazz, fieldName);
				if (null == f) {
					throw new NoSuchFieldException("没有" + fieldName + "属性！");
				}
				f.setAccessible(true);
				if (value.equals(f.get(obj))) {
					// 返回集合中增加这条数据
					returnColl.add(obj);
				}
			}

			return returnColl;

		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		}
	}
	public static Field getDeclaredField(Class<?> clazz, String fieldName) {
		Field field = null;
		while (clazz != Object.class) {
			try {
				field = clazz.getDeclaredField(fieldName);
				return field;
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
			clazz = clazz.getSuperclass();
		}
		return null;
	}
	public static void main(String[] args) {
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto d1 = new Dto();
		d1.setTestAttr("a");
		Dto d2 = new Dto();
		d2.setTestAttr("b");
		dtoList.add(d1);
		dtoList.add(d2);
		dtoList  = selectValueFromColl2(dtoList, Dto.class, dtoList.getClass(), "testAttr", "a");
		System.out.println("测试结果");
		System.out.println(dtoList.get(0).getTestAttr());
		
	}
}
class Dto{
	private String testAttr;

	public String getTestAttr() {
		return testAttr;
	}

	public void setTestAttr(String testAttr) {
		this.testAttr = testAttr;
	}
	
}
