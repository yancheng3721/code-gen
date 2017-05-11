package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class SubtitleSelector implements SelectorConfig{

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",Field.newFiled("ID","字幕ID"));
        results.put("CONTENT",Field.newFiled("CONTENT","字幕内容"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@QuerySql@","SELECT ID,CONTENT FROM TF_SUBTITLE");
        replacement.put("@UpperHeadSelectorName@","Subtitle");
        replacement.put("@SelectorName@","subtitle");
        replacement.put("@SelectorCNName@","字幕");
        return replacement;
	}

	@Override
	public String getReturnFileds() {
		return "ID,CONTENT";
	}

	@Override
	public String getSearchFileds() {
		return "CONTENT";
	}

	@Override
	public String getViewFields() {
		return "ID,CONTENT";
	}

}
