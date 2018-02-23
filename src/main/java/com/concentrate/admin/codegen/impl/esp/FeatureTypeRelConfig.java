package com.concentrate.admin.codegen.impl.esp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.admin.codegen.CodeGenerator;
import com.concentrate.admin.codegen.ModuleConfig;

public class FeatureTypeRelConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("FEATURE_ID",
				CodeGenerator.newField("FEATURE_ID", "专题ID", "NOT_NULL"));
		results.put("FEATURE_TYPE_ID",
				CodeGenerator.newField("FEATURE_TYPE_ID", "类型ID", "NOT_NULL"));
		results.put("UPDATE_USER",
				CodeGenerator.newField("UPDATE_USER", "更新用户"));
		results.put("CREATE_TIME",
				CodeGenerator.newField("CREATE_TIME", "创建时间"));
		results.put("UPDATE_TIME",
				CodeGenerator.newField("UPDATE_TIME", "更新时间"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "feature");
		replacement.put("@upperHeadModule@", "FeatureTypeRel");
		replacement.put("@moduleCN@", "专题与类型对应关系");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.controller.feature");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.feature");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.feature");
		replacement.put("@TBName@", "EB_FEATURE_TYPE_REL");
		replacement.put("@uniqKeys@", "FEATURE_ID");
		replacement
				.put("@querySql@",
						"SELECT A.ID,A.FEATURE_ID,B.SHOW_NAME,A.FEATURE_TYPE_ID,C.NAME "
								+ "FROM EB_FEATURE_TYPE_REL AS A "
								+ "LEFT JOIN EB_FEATURE AS B ON B.ID = A.FEATURE_ID "
								+ "LEFT JOIN EB_FEATURE_TYPE AS C ON C.ID = A.FEATURE_TYPE_ID");
		return replacement;
	}
	@Override
	public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSearchFileds() {
		return "SHOW_NAME,NAME";
	}

	@Override
	public String getViewFields() {
		return "SHOW_NAME,NAME";
	}

	@Override
	public String getSaveFields() {
		return "FEATURE_ID,FEATURE_TYPE_ID";
	}

	@Override
	public String getExportFields() {
		return "FEATURE_ID,SHOW_NAME,FEATURE_TYPE_ID,NAME";
	}

	@Override
	public String getImportFields() {
		return "FEATURE_ID,FEATURE_TYPE_ID";
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
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
