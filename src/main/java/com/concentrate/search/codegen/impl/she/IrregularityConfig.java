package com.concentrate.search.codegen.impl.she;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class IrregularityConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("BIZCODE",
				CodeGenerator.newField("BIZCODE", "商家编码", "NOT_NULL"));
		results.put("COMMODITY_CODE",
				CodeGenerator.newField("COMMODITY_CODE", "商品编码", "NOT_NULL"));
		results.put("COMMODITY_NAME",
				CodeGenerator.newField("COMMODITY_NAME", "商品名称", "NOT_NULL"));
		results.put("HANDLE_TIME",
				CodeGenerator.newField("HANDLE_TIME", "处置时间", "NOT_NULL"));
		results.put("HANDLE_METHOD",
				CodeGenerator.newField("HANDLE_METHOD", "处置方法", "NOT_NULL"));
		results.put("HANDLE_CYCLE",
				CodeGenerator.newField("HANDLE_CYCLE", "处置周期", "NOT_NULL"));
		results.put("IRREGULARITY_TYPE",
				CodeGenerator.newField("IRREGULARITY_TYPE", "违规类型", "NOT_NULL"));
		results.put("IRREGULARITY_TIME",
				CodeGenerator.newField("IRREGULARITY_TIME", "违规时间", "NOT_NULL"));
		results.put("IRREGULARITY_REASON",
				CodeGenerator.newField("IRREGULARITY_REASON", "违规原因", "NOT_NULL"));
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
		replacement.put("@module@", "irregularity");
		replacement.put("@upperHeadModule@", "Irregularity");
		replacement.put("@moduleCN@", "违规查询");
		replacement.put("@packageController@",
				"com.concentrate.search.she.controller.irregularity");
		replacement.put("@packageService@",
				"com.concentrate.search.she.service.irregularity");
		replacement.put("@packageDao@",
				"com.concentrate.search.she.dao.irregularity");
		replacement.put("@TBName@", "SHE_IRREGULARITY");
		replacement.put("@uniqKeys@", "ID");
		replacement
				.put("@querySql@",
						"SELECT ID,BIZCODE,COMMODITY_CODE,COMMODITY_NAME,HANDLE_TIME,HANDLE_METHOD,HANDLE_CYCLE,IRREGULARITY_TYPE,IRREGULARITY_TIME,IRREGULARITY_REASON FROM SHE_IRREGULARITY");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "BIZCODE,COMMODITY_CODE,COMMODITY_NAME";
	}

	@Override
	public String getViewFields() {
		return "BIZCODE,COMMODITY_CODE,COMMODITY_NAME,HANDLE_TIME,HANDLE_METHOD,HANDLE_CYCLE,IRREGULARITY_TYPE,IRREGULARITY_TIME,IRREGULARITY_REASON";
	}

	@Override
	public String getSaveFields() {
		return "BIZCODE,COMMODITY_CODE,COMMODITY_NAME,HANDLE_TIME,HANDLE_METHOD,HANDLE_CYCLE,IRREGULARITY_TYPE,IRREGULARITY_TIME,IRREGULARITY_REASON";
	}

	@Override
	public String getExportFields() {
		return "BIZCODE,COMMODITY_CODE,COMMODITY_NAME,HANDLE_TIME,HANDLE_METHOD,HANDLE_CYCLE,IRREGULARITY_TYPE,IRREGULARITY_TIME,IRREGULARITY_REASON";
	}

	@Override
	public String getImportFields() {
		return "BIZCODE,COMMODITY_CODE,COMMODITY_NAME,HANDLE_TIME,HANDLE_METHOD,HANDLE_CYCLE,IRREGULARITY_TYPE,IRREGULARITY_TIME,IRREGULARITY_REASON";
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
