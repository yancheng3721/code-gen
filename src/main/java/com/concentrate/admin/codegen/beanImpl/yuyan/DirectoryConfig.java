package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/2/2.
 */
public class DirectoryConfig  extends BaseModule {

    public DirectoryConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     * create table T_DIRECTORY
     (
     ID                   bigint not null auto_increment,
     CODE                 varchar(60) not null,
     NAME                 varchar(120) not null,
     PARENT_ID            bigint,
     SORT                 int,
     REMARK               varchar(600),
     CREATE_TIME          timestamp not null,
     UPDATE_TIME          timestamp not null,
     UPDATE_USER          varchar(60) not null,
     primary key (ID)
     )
     auto_increment = 10000;
     *
     * @return
     */
    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("CODE", newField("CODE", "编码", "NOT_NULL"));
        results.put("NAME", newField("NAME", "目录名称", "NOT_NULL"));
        results.put("PARENT_ID", newField("PARENT_ID", "上级ID"));
        results.put("SORT", newField("SORT", "排序值"));
        results.put("REMARK", newField("REMARK", "备注"));

        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> select = new HashMap<String,String>();
        select.put("ID,NAME","select ID,NAME from T_DIRECTORY");
        result.put("PARENT_ID",select);
        return result;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
        return null;
    }

    @Override
    public String getSearchFileds() {
        return "ID,CODE,NAME";
    }

    @Override
    public String getViewFields() {
        return "ID,CODE,NAME,PARENT_ID,SORT,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "CODE,NAME,PARENT_ID,SORT,REMARK";
    }

    @Override
    public String getExportFields() {
        return "ID,CODE,NAME,PARENT_ID,SORT,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "ID,CODE,NAME,PARENT_ID,SORT,REMARK";
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
        return "directory";
    }

    @Override
    public String getModule() {
        return "directory";
    }

    @Override
    public String getModuleCN() {
        return "目录";
    }

    @Override
    public String getTableName() {
        return "T_DIRECTORY";
    }

    @Override
    public String getUniqKeys() {
        return "NAME,PARENT_ID";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select ID,CODE,NAME,PARENT_ID,SORT,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER from T_DIRECTORY";
    }
}
