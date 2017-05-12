package com.concentrate.search.codegen.impl.she;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class RoleMenuMappingConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("ROLE_ID",
				CodeGenerator.newField("ROLE_ID", "角色ID", "NOT_NULL"));
		results.put("MENU_ID",
				CodeGenerator.newField("MENU_ID", "菜单ID", "NOT_NULL"));
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
		return null;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		return null;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "roleMenuMapping");
		replacement.put("@upperHeadModule@", "RoleMenuMapping");
		replacement.put("@moduleCN@", "角色菜单权限");
		replacement.put("@packageController@",
				"com.concentrate.search.she.controller.system");
		replacement.put("@packageService@",
				"com.concentrate.search.she.service.system");
		replacement.put("@packageDao@", "com.concentrate.search.she.dao.system");
		replacement.put("@TBName@", "SHE_ROLE_MENU_MAPPING");
		replacement.put("@uniqKeys@", "ROLE_ID,MENU_ID");
		replacement
				.put("@querySql@",
						"SELECT A.ROLE_ID,B.NAME AS ROLE_NAME,A.MENU_ID,C.NAME AS MENU_NAME FROM SHE_ROLE_MENU_MAPPING AS A LEFT JOIN SHE_ROLE AS B ON B.ID = A.ROLE_ID LEFT JOIN SHE_MENU AS C ON C.ID = A.MENU_ID");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "ROLE_NAME,MENU_NAME";
	}

	@Override
	public String getViewFields() {
		return "ROLE_NAME,MENU_NAME";
	}

	@Override
	public String getSaveFields() {
		return "ROLE_ID,MENU_ID";
	}

	@Override
	public String getExportFields() {
		return "ROLE_NAME,MENU_NAME";
	}

	@Override
	public String getImportFields() {
		return "ROLE_ID,MENU_ID";
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
