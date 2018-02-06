package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/1/5.
 *
 *    ID                   bigint not null auto_increment,
 TITLE                varchar(120) not null,
 FEATURE              varchar(120),
 IMAGE                varchar(1000),
 CONTENT              text,
 DATETIME             DATETIME,
 SORT                 int,
 CREATE_TIME          timestamp not null,
 UPDATE_TIME          timestamp not null,
 UPDATE_USER          varchar(60) not null,
 primary key (ID)
 */
public class SuccessCaseConfig   extends BaseModule {
    public SuccessCaseConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("TITLE", newField("TITLE", "案例标题", "NOT_NULL"));
        results.put("FEATURE", newField("FEATURE", "特性", "NOT_NULL"));
        results.put("IMAGE", newField("IMAGE", "图片", "NOT_NULL"));
        results.put("CONTENT", newField("CONTENT", "正文","TEXTAREA" ,"NOT_NULL"));
        results.put("DATETIME", newField("DATETIME", "时间", "TIME"));
        results.put("SORT", newField("SORT", "顺序", "NOT_NULL"));

        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> select = new HashMap<String,String>();

        return null;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
        return null;
    }

    @Override
    public String getSearchFileds() {
        return "TITLE,FEATURE,CONTENT";
    }

    @Override
    public String getViewFields() {
        return "TITLE,FEATURE,IMAGE,CONTENT,DATETIME,SORT,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "TITLE,FEATURE,IMAGE,CONTENT,DATETIME,SORT";
    }

    @Override
    public String getExportFields() {
        return "TITLE,FEATURE,IMAGE,CONTENT,DATETIME,SORT,UPDATE_TIME,UPDATE_USER,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "TITLE,FEATURE,IMAGE,CONTENT,DATETIME,SORT";
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
        return "successcase";
    }

    @Override
    public String getModuleCN() {
        return "成功案例";
    }

    @Override
    public String getTableName() {
        return "T_SUCCESS_CASE";
    }

    @Override
    public String getUniqKeys() {
        return "";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select ID,TITLE,FEATURE,IMAGE,CONTENT,DATETIME,SORT,UPDATE_TIME,UPDATE_USER,CREATE_TIME from T_SUCCESS_CASE ";
    }
}
