package com.arshiner.common;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/**
 * 类型转换
 * @author 士林
 *
 */
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ConverterFacade;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arshiner.model.Rzcjqjcs;

@Component
public class JsonToObject extends ConvertUtilsBean {
	/**
	 * Map转JSON
	 * 
	 * @param hashmap
	 * @return
	 */
	public static JSONObject MapconsvertToJson(Map<String, Object> map) {

		JSONObject json = new JSONObject(map);
		return json;

	}

	/**
	 * Json转String
	 * 
	 * @param json
	 * @return
	 */
	public static String JSONconsvertToString(JSONObject json) {
		String value = json.toJSONString();
		return value;
	}

	/**
	 * JSON转Map
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> JSONconsvertToMap(JSONObject json) {
		Map<String, Object> map = (Map<String, Object>) json;
		return map;
	}

	/**
	 * String转JSON String格式必须是此模式{"password":"123","username":"yaomy"}
	 * 
	 * @param str
	 * @return
	 */
	public static JSONObject StringconsvertToJSONObject(String str) {
		JSONObject json = JSONObject.parseObject(str);
		return json;
	}

	/**
	 * String 转JSONArray 格式 [{}]
	 * 
	 * @param str
	 * @return
	 */
	public static JSONArray StringconsvertToJSONArray(String str) {
		return JSONArray.parseArray(str);
	}

	/**
	 * JSONArray 转 list<Map<String,Object>>
	 * 
	 * @param jsonArray
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static List JSONArrayconsvertToList(JSONArray jsonArray) {
		return (List) jsonArray;
	}

	/**
	 * list 转JSONArray
	 *  
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized static String ListconsvertToJSON(List list) {
		List maplist = new ArrayList<>();
		for (Object object : list) {
			Map<String, String> strlist = (Map<String, String>) objectToMapStr(object);
			if (strlist.containsKey("class")) {
				strlist.remove("class");
			}
			maplist.add(strlist);

		}
//		System.out.println(maplist.toString());
		return JSONArray.toJSONString(maplist);
	}

	/**
	 * map 转object 通过BeanUtils
	 * 
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;
		Object obj = beanClass.newInstance();
		transMap2Bean(map, obj);
		return obj;
	}

	/**
	 * object 转map 通过BeanMap
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<?, ?> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}
		return new org.apache.commons.beanutils.BeanMap(obj);
	}
public static void main(String[] args) {
	Rzcjqjcs record = new Rzcjqjcs();
	record.setCsmc("testcsmc");
	record.setGjz("testgjz");
	record.setMrz("testmrz");
	List<Rzcjqjcs> rzlist = new ArrayList<>();
	rzlist.add(record);
	System.out.println();
	System.out.println(ListconsvertToJSON(rzlist));
}
	/**
	 * object 转map 通过BeanMap
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> objectToMapStr(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			BeanUtilsBean bean = new BeanUtilsBean(new JsonToObject());
			DateConverter converter = new DateConverter();
			converter.setPattern("yyyy-MM-dd HH:mm:ss");
			bean.getConvertUtils().register(new ConverterFacade(converter), java.util.Date.class);
			Map<String,String> strmap = bean.describe(obj);
			if (strmap.containsKey("class")) {
				strmap.remove("class");
			}
			return strmap;
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 注册 日期解析器
	 * 
	 * @param map
	 * @param obj
	 */
	public static void transMap2Bean(Map<String, Object> map, Object obj) {
		// ConvertUtils.register(new DateLocaleConverter(), Date.class);
		ConvertUtils.register(new Converter() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public Object convert(Class arg0, Object arg1) {
				// System.out.println("注册字符串转换为date类型转换器");
				if (arg1 == null) {
					return null;
				}
				if (!(arg1 instanceof String)) {
					throw new ConversionException("只支持字符串转换 !");
				}
				String str = (String) arg1;
				if (str.trim().equals("")) {
					return null;
				}

				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				try {
					return sd.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}

			}

		}, java.util.Date.class);
		if (map == null || obj == null) {
			return;
		}
		try {
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			System.out.println("Map<String,Object>转化Bean异常：" + e);
		}
	}
	@Override
	public String convert(Object value) {
		if (value == null) {
			return null;
		} else if (value.getClass().isArray()) {
			if (Array.getLength(value) < 1) {
				return (null);
			}
			value = Array.get(value, 0);
			if (value == null) {
				return null;
			} else {
				Converter converter = lookup(String.class);
				return (converter.convert(String.class, value));
			}
		} else {
			Converter converter = null;
			if (value instanceof java.util.Date) {
				converter = lookup(java.util.Date.class);
			} else {
				converter = lookup(String.class);
			}
			return (converter.convert(String.class, value));
		}
	}
}
