package com.concentrate.search.codegen.impl.she;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class OperationTaskConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newFiled("ID", "ID"));
		results.put("SUBJECT",
				CodeGenerator.newFiled("SUBJECT", "任务主题", "NOT_NULL"));
		results.put("DETAIL",
				CodeGenerator.newFiled("DETAIL", "任务描述", "NOT_NULL"));
		results.put("DEADLINE",
				CodeGenerator.newFiled("DEADLINE", "截止时间", "NOT_NULL"));
		results.put("UPDATE_USER",
				CodeGenerator.newFiled("UPDATE_USER", "更新用户"));
		results.put("CREATE_TIME",
				CodeGenerator.newFiled("CREATE_TIME", "创建时间"));
		results.put("UPDATE_TIME",
				CodeGenerator.newFiled("UPDATE_TIME", "更新时间"));
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
		replacement.put("@module@", "operationtask");
		replacement.put("@upperHeadModule@", "OperationTask");
		replacement.put("@moduleCN@", "任务清单");
		replacement.put("@packageController@",
				"com.concentrate.search.she.controller.operationtask");
		replacement.put("@packageService@",
				"com.concentrate.search.she.service.operationtask");
		replacement.put("@packageDao@",
				"com.concentrate.search.she.dao.operationtask");
		replacement.put("@TBName@", "SHE_OPERATION_TASK");
		replacement.put("@uniqKeys@", "SUBJECT");
		replacement.put("@querySql@",
				"SELECT ID,SUBJECT,DETAIL,DEADLINE FROM SHE_OPERATION_TASK");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "SUBJECT,DEADLINE";
	}

	@Override
	public String getViewFields() {
		return "SUBJECT,DETAIL,DEADLINE";
	}

	@Override
	public String getSaveFields() {
		return "SUBJECT,DETAIL,DEADLINE";
	}

	@Override
	public String getExportFields() {
		return "SUBJECT,DETAIL,DEADLINE";
	}

	@Override
	public String getImportFields() {
		return "SUBJECT,DETAIL,DEADLINE";
	}

	@Override
	public String[] getExportTips() {
		return "1请保证上传数据列数正确;每次上传限制1000条;上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		return 300;
	}

}
