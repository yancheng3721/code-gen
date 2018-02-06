package com.concentrate.admin.codegen.selector.impl;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.selector.SelectorConfig;
import com.concentrate.admin.codegen.selector.base.BaseSelectorConfig;
import com.concentrate.admin.codegen.util.GenerateUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/2/3.
 */
public class AttrSelector  extends BaseSelectorConfig implements SelectorConfig {
    private ProjectConfig projectConfig = null;

    public AttrSelector(ProjectConfig projectConfig){
        super(projectConfig);
        this.projectConfig = projectConfig;
    }

    @Override
    public ProjectConfig getProjectConfig() {
        return projectConfig;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {

        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("CODE", newField("CODE", "编码", "NOT_NULL"));
        results.put("NAME", newField("NAME", "属性名称", "NOT_NULL"));
        results.put("UNIT", newField("UNIT", "单位"));
        results.put("SORT", newField("SORT", "排序值"));
        results.put("REMARK", newField("REMARK", "备注"));
        results.put("MUST", newField("MUST", "必填"));
        results.put("FACET_ABLE", newField("FACET_ABLE", "高级筛选"));
        results.put("INDEX_ABLE", newField("INDEX_ABLE", "全文检索"));

        return results;

    }


    @Override
    public String getReturnFileds() {
        return "ID,NAME";
    }

    @Override
    public String getSearchFileds() {
        return "NAME,CODE,UNIT,FACET_ABLE,INDEX_ABLE";
    }

    @Override
    public String getViewFields() {
        return "NAME,CODE,UNIT,FACET_ABLE,INDEX_ABLE";
    }

    @Override
    public String getSelectorName() {
        return "attr";
    }

    @Override
    public String getSelectorCNName() {
        return "属性";
    }

    @Override
    public String getQuerySql() {
        return "select A.ID,A.TEMPLATE_ID,B.TEMPLATE_NAME,A.CODE,A.NAME,A.SORT,A.MUST,A.UNIT,A.FACET_ABLE,A.INDEX_ABLE,A.REMARK,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER from T_ATTR A LEFT JOIN T_DIR_ATTR B ON A.TEMPLATE_ID = B.ID ORDER BY A.NAME,A.ID";
    }
}
