package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class BrandSelector implements SelectorConfig {

	/**
	 * select ID,NAME,CODE from tf_brand where name NOT like '%出版社%'
	 */
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		
		
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",Field.newFiled("ID","ID"));
        results.put("NAME",Field.newFiled("NAME","品牌名称"));
        results.put("CODE",Field.newFiled("CODE","品牌编码"));
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
        replacement.put("@QuerySql@","select ID,NAME,CODE from tf_brand where name NOT like '%出版社%'");
        replacement.put("@UpperHeadSelectorName@","Brand");
        replacement.put("@SelectorName@","brand");
        replacement.put("@SelectorCNName@","品牌");
        
        return replacement;
    }

	@Override
	public String getReturnFileds() {
		return "CODE,NAME";
	}

	
	@Override
	public String getSearchFileds() {
		return "NAME,CODE";
	}
	
	@Override
	public String getViewFields() {
		return "NAME,CODE";
	}

}
