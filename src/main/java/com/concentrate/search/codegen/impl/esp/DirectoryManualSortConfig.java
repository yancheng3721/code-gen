package com.concentrate.search.codegen.impl.esp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class DirectoryManualSortConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newFiled("ID", "ID"));
		results.put("KEYWORD",
				CodeGenerator.newFiled("KEYWORD", "目录ID", "NOT_NULL"));
		results.put("NAME", CodeGenerator.newFiled("NAME", "目录名称"));
		results.put("PARTNUMBER",
				CodeGenerator.newFiled("PARTNUMBER", "商品编码", "NOT_NULL"));
		results.put("SORT", CodeGenerator.newFiled("SORT", "排序值", "NOT_NULL"));
		results.put("START_TIME", CodeGenerator.newFiled("START_TIME", "生效时间",
				"NOT_NULL", "TIME"));
		results.put("END_TIME",
				CodeGenerator.newFiled("END_TIME", "失效时间", "NOT_NULL", "TIME"));
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
		replacement.put("@module@", "sort");
		replacement.put("@upperHeadModule@", "DirectoryManualSort");
		replacement.put("@moduleCN@", "列表页人工干预排序");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller.sort");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.sort");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.sort");
		replacement.put("@TBName@", "EB_MANUAL_INTERVENTION_SORT");
		replacement.put("@uniqKeys@", "ID");
		replacement
				.put("@querySql@",
						"SELECT * FROM (SELECT A.ID,A.KEYWORD,B.NAME,A.TYPE,A.PARTNUMBER,A.SORT,A.START_TIME,A.END_TIME "
								+ "FROM EB_MANUAL_INTERVENTION_SORT AS A LEFT JOIN TF_DIRECTORY AS B ON VARCHAR(B.ID) = A.KEYWORD) WHERE TYPE =2");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "KEYWORD";
	}

	@Override
	public String getViewFields() {
		return "KEYWORD,NAME,PARTNUMBER,SORT,START_TIME,END_TIME";
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
