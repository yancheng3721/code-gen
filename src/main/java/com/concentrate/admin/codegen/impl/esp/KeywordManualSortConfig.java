package com.concentrate.admin.codegen.impl.esp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.admin.codegen.CodeGenerator;
import com.concentrate.admin.codegen.ModuleConfig;

public class KeywordManualSortConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("KEYWORD",
				CodeGenerator.newField("KEYWORD", "关键词", "NOT_NULL"));
		results.put("TYPE", CodeGenerator.newField("TYPE", "类型", "NOT_NULL"));
		results.put("PARTNUMBER",
				CodeGenerator.newField("PARTNUMBER", "商品编码", "NOT_NULL"));
		results.put("SORT", CodeGenerator.newField("SORT", "排序值", "NOT_NULL"));
		results.put("START_TIME", CodeGenerator.newField("START_TIME", "生效时间",
                "NOT_NULL", "TIME"));
		results.put("END_TIME",
				CodeGenerator.newField("END_TIME", "失效时间", "NOT_NULL", "TIME"));
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
		replacement.put("@module@", "sort");
		replacement.put("@upperHeadModule@", "KeywordManualSort");
		replacement.put("@moduleCN@", "搜索结果页人工干预排序");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.controller.sort");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.sort");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.sort");
		replacement.put("@TBName@", "EB_MANUAL_INTERVENTION_SORT");
		replacement.put("@uniqKeys@", "ID");
		replacement
				.put("@querySql@",
						"SELECT ID,KEYWORD,TYPE,PARTNUMBER,SORT,START_TIME,END_TIME FROM EB_MANUAL_INTERVENTION_SORT WHERE TYPE=1 ORDER BY KEYWORD");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "KEYWORD";
	}

	@Override
	public String getViewFields() {
		return "KEYWORD,PARTNUMBER,SORT,START_TIME,END_TIME";
	}

	@Override
	public String getSaveFields() {
		return "KEYWORD,TYPE,PARTNUMBER,SORT,START_TIME,END_TIME";
	}

	@Override
	public String getExportFields() {
		return "KEYWORD,TYPE,PARTNUMBER,SORT,START_TIME,END_TIME";
	}

	@Override
	public String getImportFields() {
		return "KEYWORD,TYPE,PARTNUMBER,SORT,START_TIME,END_TIME";
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
