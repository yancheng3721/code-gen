package com.concentrate.search.codegen.selector;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 

 * @author 12091669
 *
 */
public interface SelectorConfig {

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
	
	LinkedHashMap<String,String> getAllReplaceMent();
	
	String getReturnFileds();
	
	String getSearchFileds();
	
	String getViewFields();
	
}
