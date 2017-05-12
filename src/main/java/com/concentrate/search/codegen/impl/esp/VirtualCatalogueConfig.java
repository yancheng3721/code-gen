package com.concentrate.search.codegen.impl.esp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class VirtualCatalogueConfig implements ModuleConfig{

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("VIRTUAL_NAME",
				CodeGenerator.newField("VIRTUAL_NAME", "虚拟名称", "NOT_NULL"));
		results.put("BG_IMAGE", CodeGenerator.newField("BG_IMAGE", "背景图片", "NOT_NULL"));
		results.put("SORT",
				CodeGenerator.newField("SORT", "排序值", "NOT_NULL"));
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
		replacement.put("@module@", "catalogue");
		replacement.put("@upperHeadModule@", "VirtualCatalogue");
		replacement.put("@moduleCN@", "虚拟目录管理");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller.catalogue");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.catalogue");
		replacement.put("@packageDao@",
				"com.concentrate.search.admin.dao.catalogue");
		replacement.put("@TBName@", "EB_VIRTUAL_CATALOGUE");
		replacement.put("@uniqKeys@", "VIRTUAL_NAME");
		replacement.put("@querySql@", "SELECT ID,VIRTUAL_NAME,BG_IMAGE,SORT FROM EB_VIRTUAL_CATALOGUE");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "VIRTUAL_NAME";
	}

	@Override
	public String getViewFields() {
		return "VIRTUAL_NAME,BG_IMAGE,SORT";
	}

	@Override
	public String getSaveFields() {
		return "VIRTUAL_NAME,BG_IMAGE,SORT";
	}

	@Override
	public String getExportFields() {
		return "VIRTUAL_NAME,BG_IMAGE,SORT";
	}

	@Override
	public String getImportFields() {
		return "VIRTUAL_NAME,BG_IMAGE,SORT";
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
