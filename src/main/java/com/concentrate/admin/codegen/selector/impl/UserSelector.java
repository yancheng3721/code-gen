package com.concentrate.admin.codegen.selector.impl;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.selector.SelectorConfig;
import com.concentrate.admin.codegen.selector.base.BaseSelectorConfig;
import com.concentrate.admin.codegen.util.GenerateUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2017/6/10.
 */
public class UserSelector extends BaseSelectorConfig implements SelectorConfig {

    private ProjectConfig projectConfig = null;

    public UserSelector(ProjectConfig projectConfig){
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
        GenerateUtil.addField(results, "NAME", "用户名", "NOT_NULL");
        GenerateUtil.addField(results, "CODE", "用户编号", "NOT_NULL");
        GenerateUtil.addField(results, "ALIAS", "别名");
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
        return "SELECT ID,NAME,CODE,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER FROM T_USER ORDER BY NAME,CREATE_TIME";
    }
}
