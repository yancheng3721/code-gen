package com.concentrate.search.codegen.impl.admin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class MenuConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("TYPE", CodeGenerator.newField("TYPE", "类型", "NOT_NULL"));
		results.put("PARENT_ID", CodeGenerator.newField("PARENT_ID", "父菜单"));
		results.put("NAME",
				CodeGenerator.newField("NAME", "菜单（功能）名", "NOT_NULL"));
		results.put("URL", CodeGenerator.newField("URL", "功能路径"));
		results.put("UPDATE_USER",
				CodeGenerator.newField("UPDATE_USER", "更新用户"));
		results.put("CREATE_TIME",
				CodeGenerator.newField("CREATE_TIME", "创建时间"));
		results.put("UPDATE_TIME",
				CodeGenerator.newField("UPDATE_TIME", "更新时间"));
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> parent = new HashMap<String, String>();
		parent.put("ID,NAME", "SELECT ID,NAME FROM T_MENU WHERE TYPE = '1'");
		results.put("PARENT_ID", parent);
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> type = new HashMap<String, String>();
		type.put("1", "菜单");
		type.put("2", "功能");
		results.put("TYPE", type);
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "menu");
		replacement.put("@upperHeadModule@", "Menu");
		replacement.put("@moduleCN@", "菜单");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.controller.system");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.system");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.system");
		replacement.put("@TBName@", "T_MENU");
		replacement.put("@uniqKeys@", "NAME");
		replacement
				.put("@querySql@",
						"SELECT A.ID,A.PARENT_ID,B.NAME AS PARENT_NAME,A.NAME,A.URL,A.TYPE FROM T_MENU AS A,T_MENU AS B WHERE A.PARENT_ID = B.ID");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "NAME,URL";
	}

	@Override
	public String getViewFields() {
		return "PARENT_NAME,NAME,URL";
	}

	@Override
	public String getSaveFields() {
		return "PARENT_ID,NAME,URL,TYPE";
	}

	@Override
	public String getExportFields() {
		return "PARENT_NAME,NAME,URL";
	}

	@Override
	public String getImportFields() {
		return "PARENT_ID,NAME,URL,TYPE";
	}

	@Override
	public String[] getExportTips() {
		return "1 请保证上传数据列数正确;2 每次上传限制1000条;3 上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		return 300;
	}

}
