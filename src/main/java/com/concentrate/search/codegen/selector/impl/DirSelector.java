package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;
import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class DirSelector implements SelectorConfig {

	/**
	 * 
	 */
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",Field.newFiled("ID","ID"));
        results.put("NAME",Field.newFiled("NAME","名称"));
		return results;
	}
	
	/**
	 * 	
 		@QuerySql@
		@UpperHeadSelectorName@
		@SelectorName@
		@SelectorCNName@
		@SelectorQueryTr@
		@SelectorViewTh@
		@SelectorViewTd@
		@returnArrayStr@
	 */
	@Override
    public LinkedHashMap<String, String> getAllReplaceMent() {
        LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@QuerySql@","SELECT ID,NAME FROM TF_DIRECTORY ORDER BY ID,SORT DESC WITH UR");
        replacement.put("@UpperHeadSelectorName@","Dir");
        replacement.put("@SelectorName@","dir");
        replacement.put("@SelectorCNName@","目录");
        
        return replacement;
    }

	@Override
	public String getReturnFileds() {
		return "ID,NAME";
	}

	@Override
	public String getSearchFileds() {
		return "ID,NAME";
	}
	
	@Override
	public String getViewFields() {
		return "ID,NAME";
	}
	
}
