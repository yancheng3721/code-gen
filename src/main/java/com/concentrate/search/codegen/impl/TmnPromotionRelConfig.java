package com.concentrate.search.codegen.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class TmnPromotionRelConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID",CodeGenerator.newField("ID", "ID"));
		results.put("TYPE",CodeGenerator.newField("TYPE", "结果页/列表页", "UNIQ", "NOT_NULL"));
		results.put("KEYWORD",CodeGenerator.newField("KEYWORD", "关键词", "UNIQ", "NOT_NULL"));
		results.put("CORE_ROOT",CodeGenerator.newField("CORE_ROOT", "终端类型", "UNIQ", "NOT_NULL"));
		results.put("PROMOTION_ID",CodeGenerator.newField("PROMOTION_ID", "专区ID", "NOT_NULL"));
		results.put("UPDATE_USER",CodeGenerator.newField("UPDATE_USER", "更新用户"));
		results.put("UPDATE_TIME",CodeGenerator.newField("UPDATE_TIME", "更新时间"));
		results.put("CREATE_TIME",CodeGenerator.newField("CREATE_TIME", "创建时间"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
		replacement.put("@module@","tmnpromotion");
		replacement.put("@upperHeadModule@","TmnPromotionRel");
		replacement.put("@moduleCN@","终端促销展示");
		replacement.put("@packageController@","com.concentrate.search.admin.web.controller.tmnpromotion");
		replacement.put("@packageService@","com.concentrate.search.admin.web.service.tmnpromotion");
		replacement.put("@packageDao@","com.concentrate.search.admin.service.dao.tmnpromotion");
		replacement.put("@TBName@","TF_TMN_PROMOTION_REL");
		replacement.put("@uniqKeys@","TYPE,KEYWORD,CORE_ROOT");
		replacement.put("@querySql@","SELECT ID,TYPE,KEYWORD,CORE_ROOT,PROMOTION_ID,UPDATE_USER,UPDATE_TIME,CREATE_TIME FROM TF_TMN_PROMOTION_REL WHERE 1=1 #queryParams# ORDER BY UPDATE_TIME DESC");
//		
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "KEYWORD,CORE_ROOT";
	}

	@Override
	public String getViewFields() {
		return "KEYWORD,CORE_ROOT,PROMOTION_ID";
	}

	@Override
	public String getSaveFields() {
		return "TYPE,KEYWORD,CORE_ROOT,PROMOTION_ID";
	}

    @Override
    public String getExportFields() {
        // TODO Auto-generated method stub
        return "KEYWORD,CORE_ROOT,PROMOTION_ID";
    }

    @Override
    public int getUploadLimit() {
        return 1000;
    }
    
    @Override
    public String[] getExportTips() {
        return null;
    }
    
    @Override
    public String getImportFields() {
        return "TYPE,KEYWORD,CORE_ROOT,PROMOTION_ID";
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
