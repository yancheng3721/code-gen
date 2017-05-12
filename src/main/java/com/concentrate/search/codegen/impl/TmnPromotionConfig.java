package com.concentrate.search.codegen.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class TmnPromotionConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID",CodeGenerator.newField("ID", "ID"));
		results.put("NAME",CodeGenerator.newField("NAME", "名称", "UNIQ", "NOT_NULL"));
		results.put("SOURCE",CodeGenerator.newField("SOURCE", "源码", "NOT_NULL"));
		results.put("START_TIME",CodeGenerator.newField("START_TIME", "开始时间", "NOT_NULL", "TIME"));
		results.put("END_TIME",CodeGenerator.newField("END_TIME", "结束时间", "NOT_NULL", "TIME"));
		results.put("UPDATE_USER",CodeGenerator.newField("UPDATE_USER", "更新用户"));
		results.put("UPDATE_TIME",CodeGenerator.newField("UPDATE_TIME", "更新时间"));
		results.put("CREATE_TIME",CodeGenerator.newField("CREATE_TIME", "创建时间"));
		return results;
	}
	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
		replacement.put("@module@","tmnpromotion");
		replacement.put("@upperHeadModule@","TmnPromotion");
		replacement.put("@moduleCN@","终端促销");
		replacement.put("@packageController@","com.concentrate.search.admin.web.controller.tmnpromotion");
		replacement.put("@packageService@","com.concentrate.search.admin.web.service.tmnpromotion");
		replacement.put("@packageDao@","com.concentrate.search.admin.service.dao.tmnpromotion");
		replacement.put("@TBName@","TF_TMN_PROMOTION");
		replacement.put("@uniqKeys@","NAME");
		replacement.put("@querySql@","SELECT ID,NAME,SOURCE,START_TIME,END_TIME,UPDATE_USER,UPDATE_TIME,CREATE_TIME FROM TF_TMN_PROMOTION WHERE 1=1 #queryParams# ORDER BY UPDATE_TIME DESC");
//		
		return replacement;
	}

	@Override
	public String getSearchFileds() {
		// TODO Auto-generated method stub
		return "NAME";
	}

	@Override
	public String getViewFields() {
		// TODO Auto-generated method stub
		return "NAME,SOURCE,START_TIME,END_TIME,UPDATE_USER";
	}

	@Override
	public String getSaveFields() {
		// TODO Auto-generated method stub
		return "NAME,SOURCE,START_TIME,END_TIME";
	}
    @Override
    public String getExportFields() {
        // TODO Auto-generated method stub
        return "NAME,SOURCE,START_TIME,END_TIME,UPDATE_USER";
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
        return "NAME,SOURCE,START_TIME,END_TIME";
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
