package com.concentrate.search.codegen.impl.esp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class CatalogueRelationConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("VIRTUAL_CATALOGUE_ID", CodeGenerator.newField(
                "VIRTUAL_CATALOGUE_ID", "虚拟目录ID", "NOT_NULL", "READONLY"));
		results.put("CATALOGUE_ID",
				CodeGenerator.newField("CATALOGUE_ID", "实际目录ID", "NOT_NULL", "READONLY"));
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
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "catalogue");
		replacement.put("@upperHeadModule@", "CatalogueRelation");
		replacement.put("@moduleCN@", "虚拟目录与实际目录关系");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.controller.catalogue");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.catalogue");
		replacement
				.put("@packageDao@", "com.concentrate.search.admin.dao.catalogue");
		replacement.put("@TBName@", "EB_CATALOGUE_REL");
		replacement.put("@uniqKeys@", "ID");
		replacement
				.put("@querySql@",
						"SELECT A.ID,A.VIRTUAL_CATALOGUE_ID,C.VIRTUAL_NAME,A.CATALOGUE_ID,B.NAME FROM EB_CATALOGUE_REL AS A LEFT JOIN TF_DIRECTORY AS B ON B.ID = A.CATALOGUE_ID LEFT JOIN EB_VIRTUAL_CATALOGUE AS C ON C.ID = A.VIRTUAL_CATALOGUE_ID ");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "VIRTUAL_NAME,NAME";
	}

	@Override
	public String getViewFields() {
		return "VIRTUAL_CATALOGUE_ID,VIRTUAL_NAME,CATALOGUE_ID,NAME";
	}

	@Override
	public String getSaveFields() {
		return "VIRTUAL_CATALOGUE_ID,CATALOGUE_ID";
	}

	@Override
	public String getExportFields() {
		return "VIRTUAL_CATALOGUE_ID,VIRTUAL_NAME,CATALOGUE_ID,NAME";
	}

	@Override
	public String getImportFields() {
		return "VIRTUAL_CATALOGUE_ID,CATALOGUE_ID";
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
