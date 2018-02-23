package com.concentrate.admin.codegen.beanImpl.yuyan.relation;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/2/3.
 */
public class DirAttrConfig  extends BaseModule {

    public DirAttrConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     * create table T_DIR_ATTR
     (
     ID                   bigint not null auto_increment,
     DIR_ID               bigint,
     ATTR_ID              bigint,
     TEMPLATE_NAME        varchar(600),
     CREATE_TIME          timestamp not null,
     UPDATE_TIME          timestamp not null,
     UPDATE_USER          varchar(60) not null,
     primary key (ID)
     );
     *
     * @return
     */
    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("DIR_ID", newField("DIR_ID", "目录ID", "NOT_NULL"));
        results.put("DIR_NAME", newField("DIR_NAME", "目录名称"));
        results.put("TEMPLATE_NAME", newField("TEMPLATE_NAME", "模版名称", "NOT_NULL"));

        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> select = new HashMap<String,String>();
        select.put("ID,NAME","select ID,NAME from T_DIRECTORY");
        result.put("DIR_ID",select);

        return result;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
        return null;
    }

    @Override
    public String getSearchFileds() {
        return "DIR_ID,DIR_NAME,TEMPLATE_NAME";
    }

    @Override
    public String getViewFields() {
        return "DIR_ID,DIR_NAME,TEMPLATE_NAME,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "DIR_ID,TEMPLATE_NAME";
    }

    @Override
    public String getExportFields() {
        return getViewFields();
    }

    @Override
    public String getImportFields() {
        return "DIR_ID,TEMPLATE_NAME";
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
        return "template";
    }

    @Override
    public String getModule() {
        return "dirattr";
    }

    @Override
    public String getModuleCN() {
        return "参数模版";
    }

    @Override
    public String getTableName() {
        return "T_DIR_ATTR";
    }

    @Override
    public String getUniqKeys() {
        return "DIR_ID,NAME";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select A.ID,A.DIR_ID,B.NAME AS DIR_NAME,A.TEMPLATE_NAME,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER from T_DIR_ATTR A LEFT JOIN T_DIRECTORY B ON A.DIR_ID=B.ID ORDER BY B.NAME,A.ID";
    }

}
