package com.concentrate.search.codegen.impl.she;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class SolutionConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newFiled("ID", "ID"));
		results.put("NAME", CodeGenerator.newFiled("NAME", "解决方案名", "NOT_NULL"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "solution");
		replacement.put("@upperHeadModule@", "Solution");
		replacement.put("@moduleCN@", "解决方案");
		replacement.put("@packageController@",
				"com.concentrate.search.she.controller.system");
		replacement.put("@packageService@",
				"com.concentrate.search.she.service.system");
		replacement.put("@packageDao@", "com.concentrate.search.she.dao.system");
		replacement.put("@TBName@", "SHE_SOLUTION");
		replacement.put("@uniqKeys@", "NAME");
		replacement
				.put("@querySql@",
						"SELECT ID,NAME FROM SHE_SOLUTION");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "NAME";
	}

	@Override
	public String getViewFields() {
		return "NAME";
	}

	@Override
	public String getSaveFields() {
		return "NAME";
	}

	@Override
	public String getExportFields() {
		return "NAME";
	}

	@Override
	public String getImportFields() {
		return "NAME";
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
