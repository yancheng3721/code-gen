package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2017/5/20.
 */
public class RoleConfig extends BaseModule {

    public RoleConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     * drop table if exists T_ROLE;

    create table T_ROLE
            (
                    ID                   bigint not null auto_increment,
                    NAME                 varchar(120) not null,
    CODE                 varchar(120) not null,
    STATUS               smallint not null,
    CREATE_TIME          timestamp not null,
    UPDATE_TIME          timestamp not null,
    UPDATE_USER          varchar(60),
    primary key (ID)
    );

    * @return
     */
    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("NAME", newField("NAME", "角色名", "NOT_NULL"));
        results.put("CODE", newField("CODE", "角色编码"));
        results.put("STATUS",
                newField("STATUS", "角色状态", "NOT_NULL"));
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
        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> status = new LinkedHashMap<String,String>();
        result.put("STATUS",status);
        status.put("0","无效");
        status.put("1","有效");
        return result;
    }

    @Override
    public String getSearchFileds() {
        return "NAME,CODE,STATUS";
    }

    @Override
    public String getViewFields() {
        return "NAME,CODE,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "NAME,CODE,STATUS";
    }

    @Override
    public String getExportFields() {
        return "NAME,CODE,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "NAME,CODE,STATUS";
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
        return "role";
    }

    @Override
    public String getModuleCN() {
        return "角色";
    }

    @Override
    public String getTableName() {
        return "T_ROLE";
    }

    @Override
    public String getUniqKeys() {
        return "NAME";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "SELECT NAME,CODE,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER FROM T_ROLE";
    }
}
