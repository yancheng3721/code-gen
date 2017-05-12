package com.concentrate.search.codegen.impl.esp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class ModuleCacheConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("NAME", CodeGenerator.newField("NAME", "模块名", "NOT_NULL"));
		results.put("FILE_PATH",
				CodeGenerator.newField("FILE_PATH", "读取文件路径", "NOT_NULL"));
		results.put("FIELDS_PATTERN",
				CodeGenerator.newField("FIELDS_PATTERN", "属性模式", "NOT_NULL"));
		results.put("SEPERATOR",
				CodeGenerator.newField("SEPERATOR", "属性分隔符", "NOT_NULL"));
		results.put("DTO_CLASSNAME",
				CodeGenerator.newField("DTO_CLASSNAME", "DTO类名"));
		results.put("CACHE_TYPE",
				CodeGenerator.newField("CACHE_TYPE", "存储类型", "NOT_NULL"));
		results.put("SINGLE_CACHE_INTERFACE", CodeGenerator.newField(
                "SINGLE_CACHE_INTERFACE", "是否单个存储", "NOT_NULL"));
		results.put("COLLECTION_CACHE_INTERFACE", CodeGenerator.newField(
                "COLLECTION_CACHE_INTERFACE", "是否集合存储", "NOT_NULL"));
		results.put("MAP_CACHE_INTERFACE", CodeGenerator.newField(
                "MAP_CACHE_INTERFACE", "是否MAP存储", "NOT_NULL"));
		results.put("CACHE_CLASS",
				CodeGenerator.newField("CACHE_CLASS", "存储类", "NOT_NULL"));
		results.put("CACHE_LIMIT",
				CodeGenerator.newField("CACHE_LIMIT", "存储个数限制", "NOT_NULL"));
		results.put("PREPARE_MASTER_URL", CodeGenerator.newField(
                "PREPARE_MASTER_URL", "准备MASTER_URL", "NOT_NULL"));
		results.put("CRONTAB_TIME",
				CodeGenerator.newField("CRONTAB_TIME", "定时任务时间", "NOT_NULL"));
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
		Map<String, String> cacheType = new HashMap<String, String>();
		cacheType
				.put("DEF_VALUE,DEF_KEY",
						"SELECT DEF_KEY,DEF_VALUE from (select a.doc_code,b.def_key ,b.def_value FROM TF_DEFINITION_DOC as a join TF_DEFINITION_DETAIL as b on a.id=b.doc_id) where doc_code = 'CACHE_TYPE'");
		results.put("CACHE_TYPE", cacheType);
		Map<String, String> single = new HashMap<String, String>();
		single.put(
				"DEF_VALUE,DEF_KEY",
				"SELECT DEF_KEY,DEF_VALUE from (select a.doc_code,b.def_key ,b.def_value FROM TF_DEFINITION_DOC as a join TF_DEFINITION_DETAIL as b on a.id=b.doc_id) where doc_code = 'CACHE_INTERFACE'");
		results.put("SINGLE_CACHE_INTERFACE", single);
		Map<String, String> collection = new HashMap<String, String>();
		collection
				.put("DEF_VALUE,DEF_KEY",
						"SELECT DEF_KEY,DEF_VALUE from (select a.doc_code,b.def_key ,b.def_value FROM TF_DEFINITION_DOC as a join TF_DEFINITION_DETAIL as b on a.id=b.doc_id) where doc_code = 'CACHE_INTERFACE'");
		results.put("COLLECTION_CACHE_INTERFACE", collection);
		Map<String, String> map = new HashMap<String, String>();
		map.put("DEF_VALUE,DEF_KEY",
				"SELECT DEF_KEY,DEF_VALUE from (select a.doc_code,b.def_key ,b.def_value FROM TF_DEFINITION_DOC as a join TF_DEFINITION_DETAIL as b on a.id=b.doc_id) where doc_code = 'CACHE_INTERFACE'");
		results.put("MAP_CACHE_INTERFACE", map);
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "modulecache");
		replacement.put("@upperHeadModule@", "ModuleCache");
		replacement.put("@moduleCN@", "模块缓存");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller.modulecache");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.modulecache");
		replacement.put("@packageDao@",
				"com.concentrate.search.admin.dao.modulecache");
		replacement.put("@TBName@", "EB_MODULE_CONFIG");
		replacement.put("@uniqKeys@", "ID");
		replacement
				.put("@querySql@",
						"SELECT ID,NAME,FILE_PATH,FIELDS_PATTERN,SEPERATOR,DTO_CLASSNAME,CACHE_TYPE,SINGLE_CACHE_INTERFACE,"
								+ "COLLECTION_CACHE_INTERFACE,MAP_CACHE_INTERFACE,CACHE_CLASS,CACHE_LIMIT,PREPARE_MASTER_URL,"
								+ "CRONTAB_TIME FROM EB_MODULE_CONFIG");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "NAME,SINGLE_CACHE_INTERFACE,COLLECTION_CACHE_INTERFACE,MAP_CACHE_INTERFACE";
	}

	@Override
	public String getViewFields() {
		return "NAME,FILE_PATH,FIELDS_PATTERN,SEPERATOR,DTO_CLASSNAME,CACHE_TYPE,SINGLE_CACHE_INTERFACE,"
				+ "COLLECTION_CACHE_INTERFACE,MAP_CACHE_INTERFACE,CACHE_CLASS,CACHE_LIMIT,PREPARE_MASTER_URL,CRONTAB_TIME";
	}

	@Override
	public String getSaveFields() {
		return "NAME,FILE_PATH,FIELDS_PATTERN,SEPERATOR,DTO_CLASSNAME,CACHE_TYPE,SINGLE_CACHE_INTERFACE,"
				+ "COLLECTION_CACHE_INTERFACE,MAP_CACHE_INTERFACE,CACHE_CLASS,CACHE_LIMIT,PREPARE_MASTER_URL,CRONTAB_TIME";
	}

	@Override
	public String getExportFields() {
		return "NAME,FILE_PATH,FIELDS_PATTERN,SEPERATOR,DTO_CLASSNAME,CACHE_TYPE,SINGLE_CACHE_INTERFACE,"
				+ "COLLECTION_CACHE_INTERFACE,MAP_CACHE_INTERFACE,CACHE_CLASS,CACHE_LIMIT,PREPARE_MASTER_URL,CRONTAB_TIME";
	}

	@Override
	public String getImportFields() {
		return "NAME,FILE_PATH,FIELDS_PATTERN,SEPERATOR,DTO_CLASSNAME,CACHE_TYPE,SINGLE_CACHE_INTERFACE,"
				+ "COLLECTION_CACHE_INTERFACE,MAP_CACHE_INTERFACE,CACHE_CLASS,CACHE_LIMIT,PREPARE_MASTER_URL,CRONTAB_TIME";
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
