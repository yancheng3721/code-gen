package com.concentrate.search.codegen.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class AssociateWordPropertyConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("KEYWORD",
				CodeGenerator.newField("KEYWORD", "联想词", "NOT_NULL"));
		results.put("PROPERTY_A",
				CodeGenerator.newField("PROPERTY_A", "属性值1", "NOT_NULL"));
		results.put("PROPERTY_B", CodeGenerator.newField("PROPERTY_B", "属性值2"));
		results.put("PROPERTY_C", CodeGenerator.newField("PROPERTY_C", "属性值3"));
		results.put("UPDATE_USER",
				CodeGenerator.newField("UPDATE_USER", "更新用户"));
		results.put("UPDATE_TIME",
				CodeGenerator.newField("UPDATE_TIME", "更新时间"));
		results.put("CREATE_TIME",
				CodeGenerator.newField("CREATE_TIME", "创建时间"));
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "associatewordproperty");
		replacement.put("@upperHeadModule@", "AssociateWordProperty");
		replacement.put("@moduleCN@", "APP商品属性");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller.associatewordproperty");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.web.service.associatewordproperty");
		replacement.put("@packageDao@",
				"com.concentrate.search.admin.service.dao.associatewordproperty");
		replacement.put("@TBName@", "TF_ASSOCIATE_WORD_PROPERTY");
		replacement.put("@uniqKeys@", "KEYWORD");
		replacement
				.put("@querySql@",
						"select ID,KEYWORD,PROPERTY_A,PROPERTY_B,PROPERTY_C FROM TF_ASSOCIATE_WORD_PROPERTY");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		// TODO Auto-generated method stub
		return "KEYWORD";
	}

	@Override
	public String getViewFields() {
		// TODO Auto-generated method stub
		return "KEYWORD,PROPERTY_A,PROPERTY_B,PROPERTY_C";
	}

	@Override
	public String getSaveFields() {
		// TODO Auto-generated method stub
		return "KEYWORD,PROPERTY_A,PROPERTY_B,PROPERTY_C";
	}

	@Override
	public String getExportFields() {
		// TODO Auto-generated method stub
		return "KEYWORD,PROPERTY_A,PROPERTY_B,PROPERTY_C";
	}

	@Override
	public String getImportFields() {
		// TODO Auto-generated method stub
		return "KEYWORD,PROPERTY_A,PROPERTY_B,PROPERTY_C";
	}

	@Override
	public String[] getExportTips() {
		return "每次上传限制300条;上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		// TODO Auto-generated method stub
		return 300;
	}

}
