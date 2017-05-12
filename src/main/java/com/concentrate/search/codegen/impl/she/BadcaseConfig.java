package com.concentrate.search.codegen.impl.she;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class BadcaseConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("KEYWORD", CodeGenerator.newField("KEYWORD", "关键词/目录ID"));
		results.put("CHANNEL", CodeGenerator.newField("CHANNEL", "平台"));
		results.put("PAGE_TYPE", CodeGenerator.newField("PAGE_TYPE", "页面类型"));
		results.put("MODULE_ID", CodeGenerator.newField("MODULE_ID", "模块ID"));
		results.put("SUBJECT",
				CodeGenerator.newField("SUBJECT", "主题", "NOT_NULL"));
		results.put("PARTNUMBER", CodeGenerator.newField("PARTNUMBER", "商品编码"));
		results.put("SUPPLIER_CODE",
				CodeGenerator.newField("SUPPLIER_CODE", "商家编码"));
		results.put("EXCEPTION_TIME",
				CodeGenerator.newField("EXCEPTION_TIME", "异常发生时间", "TIME"));
		results.put("DESCRIPTION",
				CodeGenerator.newField("DESCRIPTION", "描述", "NOT_NULL"));
		results.put("IMAGE_URL", CodeGenerator.newField("IMAGE_URL", "图片"));
		results.put("STATUS",
				CodeGenerator.newField("STATUS", "状态", "NOT_NULL"));
		results.put("CREATE_TIME",
				CodeGenerator.newField("CREATE_TIME", "创建时间", "TIME"));
		results.put("CREATE_USER", CodeGenerator.newField("CREATE_USER", "创建人"));
		results.put("AUDIT_TIME",
				CodeGenerator.newField("AUDIT_TIME", "审核时间", "TIME"));
		results.put("AUDIT_USER", CodeGenerator.newField("AUDIT_USER", "审核人"));
		results.put("FEEDBACK_TIME",
				CodeGenerator.newField("FEEDBACK_TIME", "反馈时间", "TIME"));
		results.put("FEEDBACK_USER",
				CodeGenerator.newField("FEEDBACK_USER", "反馈人"));
		results.put("CLOSE_TIME",
				CodeGenerator.newField("CLOSE_TIME", "关闭时间", "TIME"));
		results.put("CLOSE_USER", CodeGenerator.newField("CLOSE_USER", "关闭人"));
		results.put("REOPEN_TIME",
				CodeGenerator.newField("REOPEN_TIME", "重新打开时间", "TIME"));
		results.put("REOPEN_USER",
				CodeGenerator.newField("REOPEN_USER", "重新打开人"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "badcase");
		replacement.put("@upperHeadModule@", "Badcase");
		replacement.put("@moduleCN@", "Badcase");
		replacement.put("@packageController@",
				"com.concentrate.search.she.controller.system");
		replacement.put("@packageService@",
				"com.concentrate.search.she.service.system");
		replacement.put("@packageDao@", "com.concentrate.search.she.dao.system");
		replacement.put("@TBName@", "SHE_BADCASE");
		replacement.put("@uniqKeys@", "");
		replacement
				.put("@querySql@",
						"SELECT ID,KEYWORD,CHANNEL,PAGE_TYPE,MODULE_ID,SUBJECT,PARTNUMBER,SUPPLIER_CODE,EXCEPTION_TIME,DESCRIPTION,IMAGE_URL,STATUS,CREATE_TIME,CREATE_USER,"
								+ "AUDIT_TIME,AUDIT_USER,FEEDBACK_TIME,FEEDBACK_USER,CLOSE_TIME,CLOSE_USER,REOPEN_TIME,REOPEN_USER FROM SHE_BADCASE");
		return replacement;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> module = new HashMap<String, String>();
		module.put("ID,NAME", "SELECT ID,NAME FROM SHE_MODULE");
		results.put("MODULE_ID", module);
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> channel = new HashMap<String, String>();
		channel.put("1", "主站");
		channel.put("2", "客户端");
		channel.put("3", "WAP");
		results.put("CHANNEL", channel);

		Map<String, String> page = new HashMap<String, String>();
		page.put("1", "列表页");
		page.put("2", "搜索结果页");
		results.put("PAGE_TYPE", page);
		return results;
	}

	@Override
	public String getSearchFileds() {
		// TODO Auto-generated method stub
		return "KEYWORD,SUBJECT";
	}

	@Override
	public String getViewFields() {
		// TODO Auto-generated method stub
		return "KEYWORD,CHANNEL,PAGE_TYPE,MODULE_ID,SUBJECT,PARTNUMBER,SUPPLIER_CODE,EXCEPTION_TIME,DESCRIPTION,IMAGE_URL,STATUS,CREATE_TIME,CREATE_USER,"
				+ "AUDIT_TIME,AUDIT_USER,FEEDBACK_TIME,FEEDBACK_USER,CLOSE_TIME,CLOSE_USER,REOPEN_TIME,REOPEN_USER";
	}

	@Override
	public String getSaveFields() {
		return "KEYWORD,CHANNEL,PAGE_TYPE,MODULE_ID,SUBJECT,PARTNUMBER,SUPPLIER_CODE,EXCEPTION_TIME,DESCRIPTION,IMAGE_URL,STATUS,CREATE_TIME,CREATE_USER,"
				+ "AUDIT_TIME,AUDIT_USER,FEEDBACK_TIME,FEEDBACK_USER,CLOSE_TIME,CLOSE_USER,REOPEN_TIME,REOPEN_USER";
	}

	@Override
	public String getExportFields() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getImportFields() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String[] getExportTips() {
		return "1 请保证上传数据列数正确;2 每次上传限制1000条;3 上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

}
