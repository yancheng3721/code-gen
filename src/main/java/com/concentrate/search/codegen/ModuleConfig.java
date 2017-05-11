package com.concentrate.search.codegen;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModuleConfig {

	LinkedHashMap<String,Map<String,String>> getAllFileds();
	
	LinkedHashMap<String,Map<String,String>> getSelectFileds();//下拉框的值不固定
	
	LinkedHashMap<String,Map<String,String>> getFixedSelectFileds();//下拉框的值固定
	
	LinkedHashMap<String,String> getAllReplaceMent();
	
	String getSearchFileds();
	
	String getViewFields();
	
	String getSaveFields();
	
	String getExportFields();
    
	String getImportFields();
    
    String [] getExportTips();
    
	int getUploadLimit();
}
