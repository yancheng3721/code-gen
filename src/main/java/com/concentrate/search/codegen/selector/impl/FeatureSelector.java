package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class FeatureSelector implements SelectorConfig{

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",Field.newFiled("ID","专题ID"));
        results.put("SHOW_NAME",Field.newFiled("SHOW_NAME","展示名称"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@QuerySql@","SELECT ID,SHOW_NAME FROM EB_FEATURE");
        replacement.put("@UpperHeadSelectorName@","Feature");
        replacement.put("@SelectorName@","feature");
        replacement.put("@SelectorCNName@","专题");
        return replacement;
	}

	@Override
	public String getReturnFileds() {
		return "ID,SHOW_NAME";
	}

	@Override
	public String getSearchFileds() {
		return "SHOW_NAME";
	}

	@Override
	public String getViewFields() {
		return "ID,SHOW_NAME";
	}

}
