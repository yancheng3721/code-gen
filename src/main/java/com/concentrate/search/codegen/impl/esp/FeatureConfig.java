package com.concentrate.search.codegen.impl.esp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class FeatureConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("SHOW_NAME",
				CodeGenerator.newField("SHOW_NAME", "展示名称", "NOT_NULL"));
		results.put("DESCRIPTION",
				CodeGenerator.newField("DESCRIPTION", "专题描述", "NOT_NULL"));
		results.put("SORT", CodeGenerator.newField("SORT", "主站排序值", "NOT_NULL"));
		results.put("APP_SORT",
				CodeGenerator.newField("APP_SORT", "APP排序值", "NOT_NULL"));
		/*
		 * results.put("SORT_TYPE", CodeGenerator.newFiled("SORT_TYPE",
		 * "结果集排序规则", "NOT_NULL"));
		 */
		results.put("FILTER",
				CodeGenerator.newField("FILTER", "过滤规则", "NOT_NULL"));
		results.put("TOPIC_NAME", CodeGenerator.newField("TOPIC_NAME", "专题名"));
		results.put("TOPIC_CODE",
				CodeGenerator.newField("TOPIC_CODE", "专题编码", "NOT_NULL"));
		results.put("SEO_CODE",
				CodeGenerator.newField("SEO_CODE", "SEO编码", "NOT_NULL"));
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
		Map<String, String> map = new HashMap<String, String>();
		map.put("DOC_CODE,DOC_NAME",
				"SELECT DOC_NAME,DOC_CODE FROM TF_DEFINITION_DOC WHERE PARENT_ID IN(SELECT ID FROM TF_DEFINITION_DOC WHERE DOC_CODE= 'ES_CHANNEL') AND DOC_CODE != 'global'");
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put(
				"ID,DEF_KEY",
				"SELECT ID,DEF_KEY from (select a.doc_code,b.ID,b.def_key FROM TF_DEFINITION_DOC as a join TF_DEFINITION_DETAIL as b on a.id=b.doc_id) where doc_code = 'FILTER_PARAM'");
		results.put("TOPIC_CODE", map);
		results.put("FILTER", map1);
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "feature");
		replacement.put("@upperHeadModule@", "Feature");
		replacement.put("@moduleCN@", "专题模块");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller.feature");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.feature");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.feature");
		replacement.put("@TBName@", "EB_FEATURE");
		replacement.put("@uniqKeys@", "TOPIC_CODE");
		replacement
				.put("@querySql@",
						"SELECT A.ID,A.SHOW_NAME,A.DESCRIPTION,A.SORT,A.APP_SORT,A.FILTER,C.DEF_KEY,B.DOC_NAME AS TOPIC_NAME,A.TOPIC_CODE,A.SEO_CODE"
								+ " FROM EB_FEATURE AS A LEFT JOIN TF_DEFINITION_DOC AS B ON B.DOC_CODE=A.TOPIC_CODE"
								+ " LEFT JOIN TF_DEFINITION_DETAIL AS C ON C.ID=A.FILTER");
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "SHOW_NAME,TOPIC_CODE,SEO_CODE";
	}

	@Override
	public String getViewFields() {
		return "SHOW_NAME,DESCRIPTION,SORT,APP_SORT,DEF_KEY,TOPIC_NAME,TOPIC_CODE,SEO_CODE";
	}

	@Override
	public String getSaveFields() {
		return "SHOW_NAME,DESCRIPTION,SORT,APP_SORT,FILTER,TOPIC_CODE,SEO_CODE";

	}

	@Override
	public String getExportFields() {
		return "SHOW_NAME,DESCRIPTION,SORT,APP_SORT,FILTER,TOPIC_CODE,SEO_CODE";

	}

	@Override
	public String getImportFields() {
		return "SHOW_NAME,DESCRIPTION,SORT,APP_SORT,FILTER,TOPIC_CODE,SEO_CODE";

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
