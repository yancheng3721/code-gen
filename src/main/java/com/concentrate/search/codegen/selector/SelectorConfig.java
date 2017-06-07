package com.concentrate.search.codegen.selector;

import com.concentrate.search.codegen.ProjectConfig;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 

 * @author 12091669
 *
 */
public interface SelectorConfig {

    public ProjectConfig getProjectInfo();
	/**
		@QuerySql@
		@UpperHeadSelectorName@
		@SelectorName@
		@SelectorCNName@
		@SelectorQueryTr@
		@SelectorViewTh@
		@SelectorViewTd@
		@returnArrayStr@
		
	 * 
	 * 
	 * @return
	 */
	LinkedHashMap<String,Map<String,String>>getAllFileds();

    LinkedHashMap<String, String> getAllReplaceMent();

    String getReturnFileds();
	
	String getSearchFileds();
	
	String getViewFields();

    String getSelectorName();

    String getSelectorCNName();

    String getQuerySql();
}
