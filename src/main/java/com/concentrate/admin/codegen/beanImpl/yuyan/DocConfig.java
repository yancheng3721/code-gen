package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 create table T_DEFINITION_DOC
 (
 ID                   bigint not null auto_increment,
 DOC_CODE             varchar(60) not null,
 DOC_NAME             varchar(120) not null,
 PARENT_ID            bigint,
 REMARK               varchar(600),
 CREATE_TIME          timestamp not null,
 UPDATE_TIME          timestamp not null,
 UPDATE_USER          varchar(60) not null,
 primary key (ID)
 );
 * Created by admin on 2017/5/20.
 */
public class DocConfig extends BaseModule {

    public DocConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("DOC_CODE", newField("DOC_CODE", "字典编码", "NOT_NULL"));
        results.put("DOC_NAME", newField("DOC_NAME", "字典名称", "NOT_NULL"));
        results.put("PARENT_ID", newField("PARENT_ID", "上级ID"));
        results.put("REMARK", newField("REMARK", "备注"));

        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> select = new HashMap<String,String>();
        select.put("ID,DOC_NAME","select ID,DOC_NAME from T_DEFINITION_DOC");
        result.put("PARENT_ID",select);
        return result;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
        return null;
    }

    @Override
    public String getSearchFileds() {
        return "DOC_CODE,DOC_NAME";
    }

    @Override
    public String getViewFields() {
        return "DOC_CODE,DOC_NAME,PARENT_ID,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "DOC_CODE,DOC_NAME,PARENT_ID,REMARK";
    }

    @Override
    public String getExportFields() {
        return "DOC_CODE,DOC_NAME,PARENT_ID,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "DOC_CODE,DOC_NAME,PARENT_ID,REMARK";
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
        return "defdoc";
    }

    @Override
    public String getModuleCN() {
        return "业务字典";
    }

    @Override
    public String getTableName() {
        return "t_definition_doc";
    }

    @Override
    public String getUniqKeys() {
        return "DOC_CODE";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select ID,DOC_CODE,DOC_NAME,PARENT_ID,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER from t_definition_doc";
    }
}
