package com.concentrate.admin.codegen.selector.impl;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.selector.SelectorConfig;
import com.concentrate.admin.codegen.selector.base.BaseSelectorConfig;
import com.concentrate.admin.codegen.util.GenerateUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/2/9.
 */
public class AttrValSelector extends BaseSelectorConfig implements SelectorConfig {

    private ProjectConfig projectConfig = null;

    public AttrValSelector(ProjectConfig projectConfig){
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
        GenerateUtil.addField(results, "ID", "ID", "NOT_NULL");
        GenerateUtil.addField(results, "NAME", "属性值", "NOT_NULL");
        GenerateUtil.addField(results, "CODE", "属性值编码", "NOT_NULL");
        GenerateUtil.addField(results, "ATTR_NAME", "属性名");
        GenerateUtil.addField(results, "UNIT", "单位");
        GenerateUtil.addField(results,"STATUS", "账号状态", "NOT_NULL");
        return results;
    }


    @Override
    public String getReturnFileds() {
        return "ID,NAME";
    }

    @Override
    public String getSearchFileds() {
        return "NAME,CODE,ALIAS,STATUS";
    }

    @Override
    public String getViewFields() {
        return "NAME,CODE,ALIAS,STATUS";
    }

    @Override
    public String getSelectorName() {
        return "user";
    }

    @Override
    public String getSelectorCNName() {
        return "用户";
    }

    @Override
    public String getQuerySql() {
        return "select A.ID,ATTR_ID,B.NAME AS ATTR_NAME,B.UNIT AS ATTR_UNIT,A.CODE,A.NAME,A.SORT,A.STATE,A.REMARK,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER from T_ATTR_VALUE A LEFT JOIN T_ATTR B ON A.ATTR_ID = B.ID ORDER BY B.NAME,A.SORT,A.ID";
    }
}
