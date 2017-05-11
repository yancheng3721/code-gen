package com.concentrate.search.codegen.field;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Field {

	public static LinkedHashMap<String, Map<String, String>> copyFileds(
			LinkedHashMap<String, Map<String, String>> fields, String str) {
		String[] strings = str.split(",");
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		if(strings!=null&&strings.length>0){
			for(String string:strings){
				if(fields.get(string)!=null){
					results.put(string, fields.get(string));
				}
			}
		}
		return results;
		
	}


	public static Map<String, String> newFiled(String key, String cn,String... features) {
		Map<String, String> result=new HashMap<String, String>();
		result.put("_KEY_", key);
		result.put("_CN_", cn);
		if(features!=null){
			for(String f:features){
				result.put("_"+f+"_", "1");
			}
		}
		return result;
	}
}
