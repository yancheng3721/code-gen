package com.concentrate.search.codegen.beanImpl.admin;

import com.concentrate.search.codegen.ProjectConfig;
import com.concentrate.search.codegen.beanImpl.BaseModule;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * create table T_RESOURCE
 (
 ID                   bigint not null auto_increment,
 MENU_ID              bigint not null,
 NAME                 varchar(120) not null,
 CODE                 varchar(120) not null,
 ACTION               varchar(1000),
 REMARK               varchar(2000),
 CREATE_TIME          timestamp not null,
 UPDATE_TIME          timestamp not null,
 UPDATE_USER          varchar(60),
 primary key (ID)
 );

 * Created by admin on 2017/5/20.
 */
public class ResourceConfig extends BaseModule {

    public ResourceConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("MENU_ID", newField("MENU_ID", "菜单ID"));
        results.put("MENU_NAME", newField("MENU_NAME", "菜单名称"));
        results.put("NAME", newField("NAME", "资源名称", "NOT_NULL"));
        results.put("CODE", newField("CODE", "资源编码", "NOT_NULL"));
        results.put("ACTION",
                newField("ACTION", "资源链接", "NOT_NULL"));
        results.put("REMARK",
                newField("REMARK", "备注", "NOT_NULL"));
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
        return "NAME,CODE,ACTION,REMARK";
    }

    @Override
    public String getViewFields() {
        return "NAME,CODE,ACTION,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "NAME,MENU_ID,CODE,ACTION,REMARK";
    }

    @Override
    public String getExportFields() {
        return "NAME,MENU_ID,MENU_NAME,CODE,ACTION,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "NAME,MENU_ID,CODE,ACTION,REMARK";
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
        return "resource";
    }

    @Override
    public String getModuleCN() {
        return "资源";
    }

    @Override
    public String getTableName() {
        return "T_RESOURCE";
    }

    @Override
    public String getUniqKeys() {
        return "NAME";
    }


    /**
     *  ID                   bigint not null auto_increment,
     MENU_ID              bigint not null,
     NAME                 varchar(120) not null,
     CODE                 varchar(120) not null,
     ACTION               varchar(1000),
     REMARK               varchar(2000),
     CREATE_TIME          timestamp not null,
     UPDATE_TIME          timestamp not null,
     UPDATE_USER          varchar(60),
     * @return
     */
    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "SELECT A.NAME,A.MENU_ID,A.CODE,A.ACTION,A.REMARK,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER,B.NAME AS MENU_NAME FROM T_RESOURCE A LEFT JOIN T_MENU B ON A.MENU_ID=B.ID";
    }
}
