package com.concentrate.search.codegen.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class CategoryJumpWithSupplierConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newFiled("ID", "ID"));
		results.put("CATEGORY_ID", CodeGenerator.newFiled("CATEGORY_ID",
				"目录ID", "NOT_NULL", "DIRECTORY", "READONLY"));
		results.put("IF_JUMP_WITH_SUPPLIER", CodeGenerator.newFiled(
				"IF_JUMP_WITH_SUPPLIER", "是否带供应商跳转四级页", "NOT_NULL"));
		results.put("UPDATE_USER",
				CodeGenerator.newFiled("UPDATE_USER", "更新用户"));
		results.put("CREATE_TIME",
				CodeGenerator.newFiled("CREATE_TIME", "创建时间"));
		results.put("UPDATE_TIME",
				CodeGenerator.newFiled("UPDATE_TIME", "更新时间"));
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> cacheType = new HashMap<String, String>();
		cacheType.put("1", "是");
		cacheType.put("0", "否");
		results.put("IF_JUMP_WITH_SUPPLIER", cacheType);
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "categoryjumpwithsupplier");
		replacement.put("@upperHeadModule@", "CategoryJumpWithSupplier");
		replacement.put("@moduleCN@", "列表页带供应商跳转四级页");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.web.service");
		replacement.put("@packageDao@", "com.concentrate.search.admin.service.dao");
		replacement.put("@TBName@", "TF_CATEGORY_JUMP_WITH_SUPPLIER");
		replacement.put("@uniqKeys@", "CATEGORY_ID");
		replacement
				.put("@querySql@",
						"SELECT A.ID,A.CATEGORY_ID,B.NAME,A.IF_JUMP_WITH_SUPPLIER FROM TF_CATEGORY_JUMP_WITH_SUPPLIER AS A LEFT JOIN TF_DIRECTORY AS B ON CHAR(B.ID)=A.CATEGORY_ID");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "CATEGORY_ID,NAME";
	}

	@Override
	public String getViewFields() {
		return "CATEGORY_ID,NAME,IF_JUMP_WITH_SUPPLIER";
	}

	@Override
	public String getSaveFields() {
		return "CATEGORY_ID,IF_JUMP_WITH_SUPPLIER";
	}

	@Override
	public String getExportFields() {
		return "CATEGORY_ID,IF_JUMP_WITH_SUPPLIER";
	}

	@Override
	public String getImportFields() {
		return "CATEGORY_ID,NAME,IF_JUMP_WITH_SUPPLIER";
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
