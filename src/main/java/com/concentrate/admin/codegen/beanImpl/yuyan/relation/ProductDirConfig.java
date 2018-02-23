package com.concentrate.admin.codegen.beanImpl.yuyan.relation;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/2/3.
 */
public class ProductDirConfig extends BaseModule {

    public ProductDirConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     *
     drop table if exists T_PRODUCT_DIR;

      create table T_PRODUCT_DIR
                (
                        ID                   bigint not null auto_increment,
                        DIR_ID               bigint,
                        PRODUCT_ID           bigint,
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
        results.put("PRODUCT_ID", newField("PRODUCT_ID", "商品ID", "NOT_NULL"));
        results.put("PRODUCT_NAME", newField("PRODUCT_NAME", "商品名称"));

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
        return "DIR_ID,DIR_NAME";
    }

    @Override
    public String getViewFields() {
        return "DIR_ID,DIR_NAME,PRODUCT_ID,PRODUCT_NAME,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "DIR_ID,PRODUCT_ID";
    }

    @Override
    public String getExportFields() {
        return getViewFields();
    }

    @Override
    public String getImportFields() {
        return "DIR_ID,PRODUCT_ID";
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
        return "product";
    }

    @Override
    public String getModule() {
        return "productDir";
    }

    @Override
    public String getModuleCN() {
        return "产品目录";
    }

    @Override
    public String getTableName() {
        return "T_PRODUCT_DIR";
    }

    @Override
    public String getUniqKeys() {
        return "DIR_ID,PRODUCT_ID";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "SELECT A.ID,A.DIR_ID,B.NAME AS DIR_NAME,A.PRODUCT_ID,C.NAME AS PRODUCT_NAME FROM T_PRODUCT_DIR A LEFT JOIN T_DIRECTORY B ON A.DIR_ID = B.ID LEFT JOIN T_PRODUCT C ON A.PRODUCT_ID = C.ID ORDER BY A.DIR_ID,A.PRODUCT_ID,A.ID";
    }

}
