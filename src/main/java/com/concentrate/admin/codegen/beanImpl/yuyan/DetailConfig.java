package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.ModuleRelConfig;
import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/12/7.
 *
 * create table T_DEFINITION_DETAIL
 (
 ID                   bigint not null auto_increment,
 DOC_ID               bigint not null,
 DEF_KEY              varchar(300) not null,
 DEF_VALUE            varchar(300) not null,
 STATE                int comment '0 1',
 REMARK               varchar(600),
 CREATE_TIME          timestamp not null,
 UPDATE_TIME          timestamp not null,
 UPDATE_USER          varchar(60) not null,
 primary key (ID)
 );
 */
public class DetailConfig  extends BaseModule {
    public DetailConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("DOC_ID", newField("DOC_ID", "字典ID", "NOT_NULL"));
        results.put("DOC_CODE", newField("DOC_CODE", "字典编码", "NOT_NULL"));
        results.put("DOC_NAME", newField("DOC_NAME", "字典名称", "NOT_NULL"));
        results.put("DEF_KEY", newField("DEF_KEY", "字典键", "NOT_NULL"));
        results.put("DEF_VALUE", newField("DEF_VALUE", "字典值", "NOT_NULL"));
        results.put("STATE", newField("STATE", "状态", "NOT_NULL"));
        results.put("REMARK", newField("REMARK", "备注", "NOT_NULL"));

        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> select = new HashMap<String,String>();
        select.put("ID,DOC_NAME","select ID,DOC_NAME from T_DEFINITION_DOC");
        result.put("DOC_ID",select);
        return result;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
        return null;
    }

    @Override
    public String getSearchFileds() {
        return "DOC_CODE,DOC_NAME,DEF_KEY,DEF_VALUE";
    }

    @Override
    public String getViewFields() {
        return "DOC_CODE,DOC_NAME,DEF_KEY,DEF_VALUE,STATE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "DOC_ID,DEF_KEY,DEF_VALUE,STATE,REMARK";
    }

    @Override
    public String getExportFields() {
        return "DOC_CODE,DOC_NAME,DEF_KEY,DEF_VALUE,STATE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "DOC_ID,DEF_KEY,DEF_VALUE,STATE,REMARK";
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
        return "defdetail";
    }

    @Override
    public String getModuleCN() {
        return "业务字典值";
    }

    @Override
    public String getTableName() {
        return "t_definition_detail";
    }

    @Override
    public String getUniqKeys() {
        return "DOC_ID,DEF_KEY,DEF_VALUE,STATE";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select A.id,A.DOC_ID,A.DEF_KEY,A.DEF_VALUE,A.STATE,A.remark,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER,B.DOC_CODE,B.DOC_NAME from t_definition_detail A LEFT JOIN t_definition_doc B ON A.DOC_ID=B.ID";
    }

    @Override
    public List<ModuleRelConfig> getModuleRelConfigs() {
        return null;
    }
}
