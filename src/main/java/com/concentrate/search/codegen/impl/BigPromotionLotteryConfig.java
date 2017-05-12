package com.concentrate.search.codegen.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class BigPromotionLotteryConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("SUBJECT",
				CodeGenerator.newField("SUBJECT", "主题"));
		results.put("SHOP_LOGO",
				CodeGenerator.newField("SHOP_LOGO", "店铺logo"));
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
		replacement.put("@module@", "bigPromotionLottery");
		replacement.put("@upperHeadModule@", "BigPromotionLottery");
		replacement.put("@moduleCN@", "818大促");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.web.controller.searchLottery");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.web.service.searchLottery");
		replacement.put("@packageDao@",
				"com.concentrate.search.admin.service.dao.searchLottery");
		replacement.put("@TBName@", "TF_BIG_PROMOTION_LOTTERY");
		replacement.put("@uniqKeys@", "SUBJECT,SHOP_LOGO");
		replacement
				.put("@querySql@",
						"SELECT ID,SUBJECT,SHOP_LOGO FROM TF_BIG_PROMOTION_LOTTERY");
		return replacement;
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
	public String getSearchFileds() {
		// TODO Auto-generated method stub
		return "SUBJECT,SHOP_LOGO";
	}

	@Override
	public String getViewFields() {
		// TODO Auto-generated method stub
		return "SUBJECT,SHOP_LOGO";
	}

	@Override
	public String getSaveFields() {
		return "SUBJECT,SHOP_LOGO";
	}

	@Override
	public String getExportFields() {
		// TODO Auto-generated method stub
		return "SUBJECT,SHOP_LOGO";	}

	@Override
	public String getImportFields() {
		// TODO Auto-generated method stub
		return "SUBJECT,SHOP_LOGO";
	}

	@Override
	public String[] getExportTips() {
		return "1 请保证上传数据列数正确;2 每次上传限制1000条;3 上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		// TODO Auto-generated method stub
		return 300;
	}

}
