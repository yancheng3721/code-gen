package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class ModuleSelector implements SelectorConfig{

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("DOC_NAME",Field.newFiled("DOC_NAME","模块名"));
        results.put("DOC_CODE",Field.newFiled("DOC_CODE","模块编码"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@QuerySql@","SELECT DOC_NAME,DOC_CODE FROM TF_DEFINITION_DOC WHERE PARENT_ID IN(SELECT ID FROM TF_DEFINITION_DOC WHERE DOC_CODE= 'ES_CHANNEL') AND DOC_CODE != 'global'");
        replacement.put("@UpperHeadSelectorName@","Module");
        replacement.put("@SelectorName@","module");
        replacement.put("@SelectorCNName@","专题模块");
        return replacement;
	}

	@Override
	public String getReturnFileds() {
		return "DOC_NAME,DOC_CODE";
	}

	@Override
	public String getSearchFileds() {
		return "DOC_NAME,DOC_CODE";
	}

	@Override
	public String getViewFields() {
		return "ID,DOC_NAME,DOC_CODE";
	}

}
