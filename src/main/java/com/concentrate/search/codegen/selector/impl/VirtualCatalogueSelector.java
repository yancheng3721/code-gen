package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class VirtualCatalogueSelector implements SelectorConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",Field.newFiled("ID","虚拟目录ID"));
        results.put("VIRTUAL_NAME",Field.newFiled("VIRTUAL_NAME","虚拟目录名称"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		 LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
	        replacement.put("@QuerySql@","SELECT ID,VIRTUAL_NAME FROM EB_VIRTUAL_CATALOGUE");
	        replacement.put("@UpperHeadSelectorName@","VirtualCatalogue");
	        replacement.put("@SelectorName@","virtualCatalogue");
	        replacement.put("@SelectorCNName@","虚拟目录");
	        return replacement;
	}

	@Override
	public String getReturnFileds() {
		return "ID,VIRTUAL_NAME";
	}

	@Override
	public String getSearchFileds() {
		return "ID,VIRTUAL_NAME";
	}

	@Override
	public String getViewFields() {
		return "ID,VIRTUAL_NAME";
	}

}
