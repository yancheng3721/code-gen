package com.concentrate.search.codegen.impl.she;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class TaskAssignConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newFiled("ID", "ID"));
		results.put("TASK_ID",
				CodeGenerator.newFiled("TASK_ID", "任务ID", "NOT_NULL"));
		results.put("USER_ID",
				CodeGenerator.newFiled("USER_ID", "用户ID", "NOT_NULL"));
		results.put("STATUS",
				CodeGenerator.newFiled("STATUS", "任务状态", "NOT_NULL"));
		results.put("SUMMARY", CodeGenerator.newFiled("SUMMARY", "任务总结"));
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
		replacement.put("@module@", "taskAssign");
		replacement.put("@upperHeadModule@", "TaskAssign");
		replacement.put("@moduleCN@", "任务检查");
		replacement.put("@packageController@",
				"com.concentrate.search.she.controller.operationtask");
		replacement.put("@packageService@",
				"com.concentrate.search.she.service.operationtask");
		replacement.put("@packageDao@",
				"com.concentrate.search.she.dao.operationtask");
		replacement.put("@TBName@", "SHE_TASK_ASSIGN");
		replacement.put("@uniqKeys@", "TASK_ID,USER_ID");
		replacement
				.put("@querySql@",
						"SELECT A.ID,A.TASK_ID,B.SUBJECT,B.DETAIL,B.DEADLINE,A.USER_ID,C.NAME AS USER_NANE,C.ALIAS,A.STATUS,A.SUMMARY FROM SHE_TASK_ASSIGN AS A JOIN SHE_OPERATION_TASK AS B ON A.TASK_ID = B.ID JOIN SHE_USER AS C ON C.ID = A.USER_ID");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "SUBJECT,DETAIL,USER_NANE";
	}

	@Override
	public String getViewFields() {
		return "SUBJECT,DETAIL,DEADLINE,USER_NANE,STATUS,SUMMARY";
	}

	@Override
	public String getSaveFields() {
		return "TASK_ID,USER_ID";
	}

	@Override
	public String getExportFields() {
		return "SUBJECT,DETAIL,DEADLINE,USER_NANE,STATUS,SUMMARY";
	}

	@Override
	public String getImportFields() {
		return "TASK_ID,USER_ID";
	}

	@Override
	public String[] getExportTips() {
		return "请保证上传数据列数正确;每次上传限制300条;上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		return 300;
	}

}
