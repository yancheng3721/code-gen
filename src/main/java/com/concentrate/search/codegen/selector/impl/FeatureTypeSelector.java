package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class FeatureTypeSelector implements SelectorConfig{

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",Field.newFiled("ID","类型ID"));
        results.put("NAME",Field.newFiled("NAME","类型名称"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@QuerySql@","SELECT ID,NAME FROM EB_FEATURE_TYPE");
        replacement.put("@UpperHeadSelectorName@","FeatureType");
        replacement.put("@SelectorName@","featureType");
        replacement.put("@SelectorCNName@","专题类型");
        return replacement;
	}

	@Override
	public String getReturnFileds() {
		return "ID,NAME";
	}

	@Override
	public String getSearchFileds() {
		return "NAME";
	}

	@Override
	public String getViewFields() {
		return "ID,NAME";
	}

}
