package com.concentrate.search.codegen.selector.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;
import com.concentrate.search.codegen.selector.SelectorConfig;

public class FullPathDirSelector implements SelectorConfig {

	/**
	 * SELECT A.ID AS ROOT_ID,A.NAME as ROOT_NAME,B.id as id1,b.name as NAME2 ,C.ID AS ID3,C.NAME AS NAME3,D.ID AS ID4 ,D.NAME AS NAME4 FROM TF_DIRECTORY A LEFT JOIN TF_DIRECTORY B ON A.ID=B.PARENT_ID LEFT JOIN TF_DIRECTORY C ON B.ID=C.PARENT_ID LEFT JOIN TF_DIRECTORY D ON C.ID=D.PARENT_ID WHERE (A.PARENT_ID=0 OR A.PARENT_ID IS NULL ) ORDER BY A.SORT,B.SORT,C.SORT,D.SORT
	 */
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		
		
		LinkedHashMap<String, Map<String, String>>  results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ROOT_ID",Field.newFiled("ROOT_ID","频道ID"));
        results.put("ROOT_NAME",Field.newFiled("ROOT_NAME","频道名称"));
        results.put("ID1",Field.newFiled("ID1","一级ID"));
        results.put("ID2",Field.newFiled("ID2","二级ID"));
        results.put("ID3",Field.newFiled("ID3","三级ID"));
        results.put("NAME1",Field.newFiled("NAME1","一级名称"));
        results.put("NAME2",Field.newFiled("NAME2","二级名称"));
        results.put("NAME3",Field.newFiled("NAME3","三级名称"));
		return results;
	}
	
	/**
	 * 	
 		@QuerySql@
		@UpperHeadSelectorName@
		@SelectorName@
		@SelectorCNName@
		@SelectorQueryTr@
		@SelectorViewTh@
		@SelectorViewTd@
		@returnArrayStr@
	 */
	@Override
    public LinkedHashMap<String, String> getAllReplaceMent() {
        LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@QuerySql@","SELECT A.ID AS ROOT_ID,A.NAME as ROOT_NAME,B.id as id1,b.name as NAME1 ,C.ID AS ID2,C.NAME AS NAME2,D.ID AS ID3 ,D.NAME AS NAME3 FROM TF_DIRECTORY A LEFT JOIN TF_DIRECTORY B ON A.ID=B.PARENT_ID LEFT JOIN TF_DIRECTORY C ON B.ID=C.PARENT_ID LEFT JOIN TF_DIRECTORY D ON C.ID=D.PARENT_ID WHERE (A.PARENT_ID=0 OR A.PARENT_ID IS NULL ) ORDER BY A.SORT,B.SORT,C.SORT,D.SORT");
        replacement.put("@UpperHeadSelectorName@","FullPathDir");
        replacement.put("@SelectorName@","fullPathDir");
        replacement.put("@SelectorCNName@","目录");
        
        return replacement;
    }

	@Override
	public String getReturnFileds() {
		return "ID3,NAME3";
	}

	
	@Override
	public String getSearchFileds() {
		return "ROOT_ID,ROOT_NAME,ID1,NAME1,ID2,NAME2,ID3,NAME3";
	}
	
	@Override
	public String getViewFields() {
		return "ROOT_ID,ROOT_NAME,ID1,NAME1,ID2,NAME2,ID3,NAME3";
	}

}
