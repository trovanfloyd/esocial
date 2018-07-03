package com.seplag.esocial.extrator.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ClassUtils;

public class ExtratorUtil {

	/*public static HashMap<String, String> mapFields(Class<?> evento) {
		HashMap<String, String> mapXml = new HashMap<>();
		for (Field field : evento.getDeclaredFields()) {
			field.setAccessible(true);

			if (ClassUtils.isPrimitiveOrWrapper(field.getType()) || field.getType().getSimpleName().equals("String") || field.getType().getSimpleName().equals("BigInteger")
			        || field.getType().getSimpleName().equals("BigDecimal") || field.getType().getSimpleName().equals("Date")) {
				String name = field.getName();
				if (!name.equalsIgnoreCase("serialVersionUID") && !name.startsWith("isn")) {
					mapXml.put(name, "");
				}
			} else if (field.getType().getSimpleName().equals("List")) {

			}

			else {
				Class<?> eve = field.getType().getClass();
				mapFields(eve);
			}

		}

		return mapXml;
	}*/

	public static Map<String, Object> mapValueOnFields(Object source, HashMap<String, String> mapXml) {

		BeanWrapperImpl bwSource = new BeanWrapperImpl(source);
		PropertyDescriptor[] propertyDescriptors = bwSource.getPropertyDescriptors();

		Map<String, Object> mappedObject = Stream.of(propertyDescriptors).collect(HashMap::new, (m, v) -> m.put(v.getName(), bwSource.getPropertyValue(v.getName())),
		        HashMap::putAll);

		
		//Map<Object, Object> mappedObject = Stream.of(propertyDescriptors).collect( Collectors.toMap(p -> p.getName(), p -> p.getValue(p.getName()), (existingValue, newValue) -> existingValue));
		 

		return mappedObject;

		// mapXml.forEach((k, v) -> {
		//
		// String fieldName = k.substring(0, 1).toUpperCase() + k.substring(1);
		// try {
		// Method m = obj.getClass().getDeclaredMethod("get" + fieldName);
		// Object o = m.invoke(obj);
		// if (o != null) {
		// mapXml.put(k, o.toString());
		// }
		// }
		// catch (NoSuchMethodException | SecurityException |
		// IllegalAccessException | IllegalArgumentException |
		// InvocationTargetException e) {
		// e.printStackTrace();
		// }
		// });

		// return mapXml;
	}

}
