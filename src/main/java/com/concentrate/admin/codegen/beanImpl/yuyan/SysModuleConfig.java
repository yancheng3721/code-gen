package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * create table T_MODULE
 (
 ID                   bigint not null auto_increment,
 CODE                 varchar(120) not null,
 NAME                 varchar(120) not null,
 CREATE_TIME          timestamp not null,
 UPDATE_TIME          timestamp not null,
 UPDATE_USER          varchar(60),
 primary key (ID)
 );
 * Created by admin on 2017/5/20.
 */
public class SysModuleConfig extends BaseModule {

    public SysModuleConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("NAME", newField("NAME", "模块名", "NOT_NULL"));
        results.put("CODE", newField("CODE", "模块编码", "NOT_NULL"));
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
        return "NAME,CODE";
    }

    @Override
    public String getViewFields() {
        return "NAME,CODE,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "NAME,CODE";
    }

    @Override
    public String getExportFields() {
        return "NAME,CODE";
    }

    @Override
    public String getImportFields() {
        return "NAME,CODE";
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
        return "module";
    }

    @Override
    public String getModuleCN() {
        return "模块";
    }

    @Override
    public String getTableName() {
        return "T_MODULE";
    }

    @Override
    public String getUniqKeys() {
        return "NAME";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "SELECT ID,NAME,CODE,CREATE_TIME,UPDATE_TIME,UPDATE_USER FROM T_MODULE";
    }
}
