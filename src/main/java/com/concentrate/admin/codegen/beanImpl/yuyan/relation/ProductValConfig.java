package com.concentrate.admin.codegen.beanImpl.yuyan.relation;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/2/9.
 */
public class ProductValConfig extends BaseModule {

    /**
     *
     */
    public ProductValConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     *
     * drop table if exists T_PRODUCT_ATTR_VAL;
    create table T_PRODUCT_ATTR_VAL
    (
        ID                   bigint not null auto_increment,
        PRODUCT_ID           bigint,
        ATTR_VALUE_ID        bigint,
        REMARK               varchar(600),
        CREATE_TIME          timestamp not null,
        UPDATE_TIME          timestamp not null,
        UPDATE_USER          varchar(60) not null,
        primary key (ID)
    );
     SELECT
     `A`.`ID`,
     `B`.`NAME`,
     `B`.`DESCRIPTION`,
     `B`.`IMAGE`,
     `B`.`REMARK`,
     `A`.`CREATE_TIME`,
     `A`.`UPDATE_TIME`,
     `A`.`UPDATE_USER`,
     `C`.`CODE` AS 'VALUECODE',
     `C`.`NAME` AS 'VALUE',
     `D`.`NAME` AS 'ATTRNAME',
     `D`.`UNIT`
     FROM
     `T_PRODUCT` A
     LEFT JOIN `T_PRODUCT_ATTR_VAL` B ON `A`.`ID` = `B`.`PRODUCT_ID`
     LEFT JOIN `T_ATTR_VALUE` C ON `B`.`ATTR_VALUE_ID` = `C`.`ID`
     LEFT JOIN `T_ATTR` D ON `C`.`ATTR_ID` = `D`.`ID` *
     * @return
     */
    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("PRODUCT_ID", newField("PRODUCT_ID", "商品ID"));
        results.put("ATTR_VALUE_ID", newField("ATTR_VALUE_ID", "属性值ID"));
        results.put("REMARK", newField("REMARK", "备注"));
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
        return "PRODUCT_ID,ATTR_VALUE_ID,REMARK";
    }

    @Override
    public String getViewFields() {
        return "ID,PRODUCT_ID,ATTR_VALUE_ID,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "PRODUCT_ID,ATTR_VALUE_ID,REMARK";
    }

    @Override
    public String getExportFields() {
        return getViewFields();
    }

    @Override
    public String getImportFields() {
        return "PRODUCT_ID,ATTR_VALUE_ID,REMARK";
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
        return "productAttrVal";
    }

    @Override
    public String getModuleCN() {
        return "商品参数";
    }

    @Override
    public String getTableName() {
        return "T_PRODUCT_ATTR_VAL";
    }

    @Override
    public String getUniqKeys() {
        return "PRODUCT_ID,ATTR_VALUE_ID";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "SELECT ID,PRODUCT_ID,ATTR_VALUE_ID,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER FROM T_PRODUCT_ATTR_VAL";
    }

}
