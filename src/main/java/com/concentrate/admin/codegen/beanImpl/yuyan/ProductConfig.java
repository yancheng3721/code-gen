package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.BeanModuleConfig;
import com.concentrate.admin.codegen.ModuleRelConfig;
import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;
import com.concentrate.admin.codegen.beanImpl.yuyan.relation.ProductDirConfig;

import java.util.*;

/**
 * Created by admin on 2018/2/8.


 */
public class ProductConfig extends BaseModule {

    public ProductConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     *  create table T_PRODUCT
     (
     ID                   bigint not null auto_increment,
     NAME                 varchar(240),
     DESCRIPTION          varchar(600),
     IMAGE                varchar(180),
     REMARK               varchar(600),
     CREATE_TIME          timestamp not null,
     UPDATE_TIME          timestamp not null,
     UPDATE_USER          varchar(60) not null,
     primary key (ID)
     )
     auto_increment = 100000000;
     *
     * @return
     */
    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("NAME", newField("NAME", "商品名称", "NOT_NULL"));
        results.put("DESCRIPTION", newField("DESCRIPTION", "商品卖点"));
        results.put("IMAGE", newField("IMAGE", "商品图片", "NOT_NULL"));
        results.put("REMARK", newField("REMARK", "备注"));


        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
               LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();


        return result;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {

        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();

        return result;
    }

    @Override
    public String getSearchFileds() {
        return "NAME,DESCRIPTION,IMAGE,REMARK";
    }

    @Override
    public String getViewFields() {
        return "NAME,DESCRIPTION,IMAGE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "NAME,DESCRIPTION,IMAGE,REMARK";
    }

    @Override
    public String getExportFields() {
        return "NAME,DESCRIPTION,IMAGE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "NAME,DESCRIPTION,IMAGE,REMARK";
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
        return "product1";
    }//模块已经生成，有手工修改的部分，目前不能nested方式进行重复执行，会覆盖手工修改的代码

    @Override
    public String getModule() {
        return "product";
    }

    @Override
    public String getModuleCN() {
        return "产品";
    }

    @Override
    public String getTableName() {
        return "T_PRODUCT";
    }

    @Override
    public String getUniqKeys() {
        return "";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select A.ID,NAME,DESCRIPTION,IMAGE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER from T_PRODUCT A ORDER BY A.NAME,A.ID";
    }

    @Override
    public List<ModuleRelConfig> getModuleRelConfigs() {
        List<ModuleRelConfig> results = new ArrayList<ModuleRelConfig>();
        Map<String,String> propMap = new HashMap<String,String>();
        propMap.put("ID","PRODUCT_ID");
        propMap.put("NAME","PRODUCT_NAME");
        BeanModuleConfig bmc = new ProductDirConfig(getProjectConfig());
        ModuleRelConfig rel = new ModuleRelConfig(propMap,bmc);
        results.add(rel);
        return results;
    }

}
