package com.concentrate.admin.codegen.beanImpl.admin.relation;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * create table T_MENU
 (
 ID                   bigint not null auto_increment,
 PARENT_ID            bigint not null,
 NAME                 varchar(120) not null,
 CODE                 varchar(120) not null,
 ACTION               varchar(1000),
 ICON                 varchar(1000),
 REMARK               varchar(2000),
 STATUS               smallint not null,
 CREATE_TIME          timestamp not null,
 UPDATE_TIME          timestamp not null,
 UPDATE_USER          varchar(60),
 primary key (ID)
 );
 * Created by admin on 2017/5/20.
 */
public class RUserRoleConfig extends BaseModule {

    public RUserRoleConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("PARENT_ID", newField("PARENT_ID", "上级菜单ID"));
        results.put("PARENT_CODE", newField("PARENT_CODE", "上级菜单编码"));
        results.put("PARENT_NAME", newField("PARENT_NAME", "上级菜单名称"));
        results.put("NAME", newField("NAME", "菜单名称", "NOT_NULL"));
        results.put("CODE", newField("CODE", "菜单编码"));
        results.put("ACTION",
                newField("ACTION", "地址", "NOT_NULL"));
        results.put("ICON",
                newField("ICON", "图标", "NOT_NULL"));
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
        return "NAME,CODE";
    }

    @Override
    public String getViewFields() {
        return "NAME,CODE,PARENT_CODE,PARENT_NAME,ACTION,ICON,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "NAME,CODE,PARENT_ID,ACTION,ICON";
    }

    @Override
    public String getExportFields() {
        return "NAME,CODE,PARENT_CODE,PARENT_NAME,ACTION,ICON";
    }

    @Override
    public String getImportFields() {
        return "NAME,CODE,PARENT_ID,ACTION,ICON";
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
        return "menu";
    }

    @Override
    public String getModuleCN() {
        return "菜单";
    }

    @Override
    public String getTableName() {
        return "T_MENU";
    }

    @Override
    public String getUniqKeys() {
        return "ID";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "SELECT A.ID,A.NAME,A.CODE,A.PARENT_ID,A.ACTION,A.ICON,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER,B.NAME AS PARENT_NAME,B.CODE AS PARENT_CODE FROM T_MENU A LEFT JOIN T_MENU B ON A.PARENT_ID=B.ID";
    }
}
