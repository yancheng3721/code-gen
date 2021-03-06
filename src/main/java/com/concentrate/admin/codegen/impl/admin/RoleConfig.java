package com.concentrate.admin.codegen.impl.admin;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.admin.codegen.CodeGenerator;
import com.concentrate.admin.codegen.ModuleConfig;

public class RoleConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("NAME", CodeGenerator.newField("NAME", "用户名", "NOT_NULL"));
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
		replacement.put("@module@", "role");
        replacement.put("@package@", "com.concentrate.search.admin");
        replacement.put("@upperHeadModule@", "Role");
		replacement.put("@moduleCN@", "角色管理");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.controller.system");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.system");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.system");
		replacement.put("@TBName@", "T_ROLE");
		replacement.put("@uniqKeys@", "NAME");
		replacement
				.put("@querySql@",
						"SELECT ID,NAME FROM T_ROLE");

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
		return 300;
	}

}
