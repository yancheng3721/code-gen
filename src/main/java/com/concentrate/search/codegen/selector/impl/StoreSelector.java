package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class StoreSelector implements SelectorConfig {

	/**
	 * select ID,NAME,CODE from tf_brand where name NOT like '%出版社%'
	 */
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		
		
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",Field.newFiled("ID","ID"));
        results.put("STORE_ID",Field.newFiled("STORE_ID","店铺ID"));
        results.put("STORE_NAME	",Field.newFiled("STORE_NAME","店铺名称"));
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
        replacement.put("@QuerySql@","select ID,STORE_ID,STORE_NAME from tf_brand_store");
        replacement.put("@UpperHeadSelectorName@","Store");
        replacement.put("@SelectorName@","store");
        replacement.put("@SelectorCNName@","店铺");
        
        return replacement;
    }

	@Override
	public String getReturnFileds() {
		return "STORE_ID,STORE_NAME";
	}

	
	@Override
	public String getSearchFileds() {
		return "STORE_ID,STORE_NAME";
	}
	
	@Override
	public String getViewFields() {
		return "STORE_ID,STORE_NAME";
	}

}
