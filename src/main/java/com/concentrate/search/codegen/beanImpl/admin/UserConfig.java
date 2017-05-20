package com.concentrate.search.codegen.beanImpl.admin;

import com.concentrate.search.codegen.ProjectConfig;
import com.concentrate.search.codegen.beanImpl.BaseModule;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2017/5/20.
 */
public class UserConfig extends BaseModule {

    public UserConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("NAME", newField("NAME", "用户名", "NOT_NULL"));
        results.put("ALIAS", newField("ALIAS", "别名"));
        results.put("PASSWORD",
                newField("PASSWORD", "密码", "NOT_NULL"));
        results.put("STATUS",
                newField("STATUS", "账号状态", "NOT_NULL"));
        results.put("UPDATE_USER",
                newField("UPDATE_USER", "更新用户"));
        results.put("CREATE_TIME",
                newField("CREATE_TIME", "创建时间"));
        results.put("UPDATE_TIME",
                newField("UPDATE_TIME", "更新时间"));
        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
        return null;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
        return null;
    }

    @Override
    public String getSearchFileds() {
        return "NAME,ALIAS,STATUS";
    }

    @Override
    public String getViewFields() {
        return "NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "NAME,ALIAS,PASSWORD,STATUS";
    }

    @Override
    public String getExportFields() {
        return "NAME,ALIAS,STATUS";
    }

    @Override
    public String getImportFields() {
        return "NAME,ALIAS,PASSWORD,STATUS";
    }

    @Override
    public String[] getImportTips() {
        return "1 请保证上传数据列数正确;2 每次上传限制1000条;3 上传文件为CSV格式，GBK编码".split(";");
    }

    @Override
    public int getUploadLimit() {
        return 2000;
    }

    public String getPackage(){
        return "system";
    }

    @Override
    public String getModule() {
        return "user";
    }

    @Override
    public String getModuleCN() {
        return "用户";
    }

    @Override
    public String getTableName() {
        return "T_USER";
    }

    @Override
    public String getUniqKeys() {
        return "NAME";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "SELECT ID,NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER FROM T_USER";
    }
}
