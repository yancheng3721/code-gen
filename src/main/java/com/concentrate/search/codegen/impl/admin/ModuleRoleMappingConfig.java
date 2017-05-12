package com.concentrate.search.codegen.impl.admin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class ModuleRoleMappingConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("MODULE_ID",
				CodeGenerator.newField("MODULE_ID", "模块ID", "NOT_NULL"));
		results.put("ROLE_ID",
				CodeGenerator.newField("ROLE_ID", "角色ID", "NOT_NULL"));
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
		Map<String, String> role = new HashMap<String, String>();
		role.put("ID,NAME", "SELECT ID,NAME FROM SHE_ROLE");
		results.put("ROLE_ID", role);

		Map<String, String> module = new HashMap<String, String>();
		module.put("ID,NAME", "SELECT ID,NAME FROM SHE_MODULE");
		results.put("MODULE_ID", module);

		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "moduleRoleMapping");
		replacement.put("@upperHeadModule@", "ModuleRoleMapping");
		replacement.put("@moduleCN@", "模块角色对应关系");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.controller.system");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.system");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.system");
		replacement.put("@TBName@", "SHE_MODULE_ROLE_MAPPING");
		replacement.put("@uniqKeys@", "MODULE_ID,ROLE_ID");
		replacement
				.put("@querySql@",
						"SELECT A.MODULE_ID,B.NAME AS MODULE_NAME,A.ROLE_ID,C.NAME AS ROLE_NAME FROM SHE_MODULE_ROLE_MAPPING AS A LEFT JOIN SHE_MODULE AS B ON A.MODULE_ID = B.ID LEFT JOIN SHE_ROLE AS C ON C.ID = A.ROLE_ID;");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "MODULE_NAME,ROLE_NAME";
	}

	@Override
	public String getViewFields() {
		return "MODULE_NAME,ROLE_NAME";
	}

	@Override
	public String getSaveFields() {
		return "MODULE_ID,ROLE_ID";
	}

	@Override
	public String getExportFields() {
		return "MODULE_NAME,ROLE_NAME";
	}

	@Override
	public String getImportFields() {
		return "MODULE_ID,ROLE_ID";
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
