package com.concentrate.search.codegen.impl.esp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class FeatureTypeConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newFiled("ID", "ID"));
		results.put("NAME", CodeGenerator.newFiled("NAME", "名称", "NOT_NULL"));
		results.put("UPDATE_USER",
				CodeGenerator.newFiled("UPDATE_USER", "更新用户"));
		results.put("CREATE_TIME",
				CodeGenerator.newFiled("CREATE_TIME", "创建时间"));
		results.put("UPDATE_TIME",
				CodeGenerator.newFiled("UPDATE_TIME", "更新时间"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "feature");
		replacement.put("@upperHeadModule@", "FeatureType");
		replacement.put("@moduleCN@", "专题类型");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller.feature");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.feature");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.feature");
		replacement.put("@TBName@", "EB_FEATURE_TYPE");
		replacement.put("@uniqKeys@", "NAME");
		replacement.put("@querySql@", "SELECT * FROM EB_FEATURE_TYPE");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "NAME";
	}

	@Override
	public String getViewFields() {
		return "NAME";
	}

	@Override
	public String getSaveFields() {
		return "NAME";
	}

	@Override
	public String getExportFields() {
		return "NAME";
	}

	@Override
	public String getImportFields() {
		return "NAME";
	}

	@Override
	public String[] getExportTips() {
		return "1 请保证上传数据列数正确;2 每次上传限制1000条;3 上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		return 1000;
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

}
