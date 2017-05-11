package com.concentrate.search.codegen.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 终端SEO META TITLE KEYWORDS 管理
 *
 *
 *SELECT A.ID,A.BRAND_ID,A.DIRECTORY_ID,A.TITLE,A.DESCRIPTION,A.KEYWORDS,A.UPDATE_USER,A.CREATE_TIME,A.UPDATE_TIME,B.NAME AS DIR_NAME FROM TF_TMN_META_DATA  A
  LEFT JOIN TF_DIRECTORY B ON A.DIRECTORY_ID=B.ID WHERE 1=1 ORDER BY UPDATE_TIME DESC
 * @author 12091669
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TmnMetaDataConfig implements ModuleConfig {

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID",CodeGenerator.newFiled("ID","ID"));
        results.put("BRAND_ID",CodeGenerator.newFiled("BRAND_ID","品牌ID","NOT_NULL"));
        results.put("DIRECTORY_ID",CodeGenerator.newFiled("DIRECTORY_ID","目录ID","NOT_NULL"));
        results.put("TITLE",CodeGenerator.newFiled("TITLE","title","NOT_NULL"));
        results.put("DESCRIPTION",CodeGenerator.newFiled("DESCRIPTION","DESCRIPTION","NOT_NULL"));
        results.put("KEYWORDS",CodeGenerator.newFiled("KEYWORDS","KEYWORDS","NOT_NULL"));
        results.put("UPDATE_USER",CodeGenerator.newFiled("UPDATE_USER","更新用户"));
        results.put("CREATE_TIME",CodeGenerator.newFiled("CREATE_TIME","创建时间"));
        results.put("UPDATE_TIME",CodeGenerator.newFiled("UPDATE_TIME","更新时间"));
        results.put("DIR_NAME",CodeGenerator.newFiled("DIR_NAME","目录名称"));
        return results;
    }

    @Override
    public LinkedHashMap<String, String> getAllReplaceMent() {
        LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@module@","tmnmetadata");
        replacement.put("@upperHeadModule@","TmnMetaData");
        replacement.put("@moduleCN@","终端SEO");
        replacement.put("@packageController@","com.concentrate.search.admin.web.controller.tmnmetadata");
        replacement.put("@packageService@","com.concentrate.search.admin.web.service.tmnmetadata");
        replacement.put("@packageDao@","com.concentrate.search.admin.service.dao.tmnmetadata");
        replacement.put("@TBName@","TF_TMN_META_DATA");
        replacement.put("@uniqKeys@","BRAND_ID,DIRECTORY_ID");
        replacement.put("@querySql@","SELECT A.ID,A.BRAND_ID,A.DIRECTORY_ID,A.TITLE,A.DESCRIPTION,A.KEYWORDS,A.UPDATE_USER,A.CREATE_TIME,A.UPDATE_TIME,B.NAME AS DIR_NAME,C.NAME AS BRAND_NAME FROM TF_TMN_META_DATA A LEFT JOIN TF_DIRECTORY B ON A.DIRECTORY_ID=B.ID LEFT JOIN TF_BRAND C ON A.BRAND_ID = C.CODE WHERE 1=1 #queryParams#  ORDER BY UPDATE_TIME DESC");
        
        return replacement;
    }

    @Override
    public String getSearchFileds() {
        return "DIRECTORY_ID,B.NAME,BRAND_ID";
    }

    @Override
    public String getViewFields() {
        
        return "DIRECTORY_ID,DIR_NAME,BRAND_ID,TITLE,DESCRIPTION,KEYWORDS,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        
        return "DIRECTORY_ID,DIR_NAME,BRAND_ID,TITLE,DESCRIPTION,KEYWORDS";
    }

    @Override
    public String getExportFields() {
        return "DIRECTORY_ID,BRAND_ID,TITLE,DESCRIPTION,KEYWORDS";
    }

    @Override
    public int getUploadLimit() {
        return 1000;
    }
    
    @Override
    public String[] getExportTips() {
        return "1 请保证上传数据列数正确;2 每次上传限制1000条;3 上传文件为CSV格式，GBK编码".split(";");
    }

    @Override
    public String getImportFields() {
        return "DIRECTORY_ID,DIR_NAME,BRAND_ID,TITLE,DESCRIPTION,KEYWORDS";
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
