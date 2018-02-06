package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.BeanModuleConfig;
import com.concentrate.admin.codegen.ModuleRelConfig;
import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.*;

/**
 * Created by admin on 2018/2/2.
 */
public class AttrConfig extends BaseModule {

    public AttrConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     * create table T_ATTR
     (
     ID                   bigint not null auto_increment,
     CODE                 varchar(60),
     NAME                 varchar(120),
     SORT                 int,
     MUST                 char(1),
     FACET_ABLE           char(1),
     INDEX_ABLE           char(1),
     REMARK               varchar(600),
     CREATE_TIME          timestamp not null,
     UPDATE_TIME          timestamp not null,
     UPDATE_USER          varchar(60) not null,
     primary key (ID)
     )
     auto_increment = 100000;
     *
     * @return
     */
    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("TEMPLATE_ID", newField("TEMPLATE_ID", "模版ID", "NOT_NULL"));
        results.put("TEMPLATE_NAME", newField("TEMPLATE_NAME", "模版名称"));
        results.put("CODE", newField("CODE", "编码", "NOT_NULL"));
        results.put("NAME", newField("NAME", "属性名称", "NOT_NULL"));
        results.put("UNIT", newField("UNIT", "单位"));
        results.put("SORT", newField("SORT", "排序值"));
        results.put("REMARK", newField("REMARK", "备注"));
        results.put("MUST", newField("MUST", "必填"));
        results.put("FACET_ABLE", newField("FACET_ABLE", "高级筛选"));
        results.put("INDEX_ABLE", newField("INDEX_ABLE", "全文检索"));

        return results;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> select = new HashMap<String,String>();
        select.put("ID,TEMPLATE_NAME","select ID,TEMPLATE_NAME from T_DIR_ATTR");
        result.put("TEMPLATE_ID",select);

        return result;
    }

    @Override
    public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {

        LinkedHashMap<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();
        Map<String, String> status = new LinkedHashMap<String,String>();
        result.put("MUST",status);
        result.put("FACET_ABLE",status);
        result.put("INDEX_ABLE",status);
        status.put("","请选择");
        status.put("1","是");
        status.put("0","否");
        return result;
    }

    @Override
    public String getSearchFileds() {
        return "TEMPLATE_NAME,CODE,NAME,MUST,UNIT,FACET_ABLE,INDEX_ABLE";
    }

    @Override
    public String getViewFields() {
        return "TEMPLATE_NAME,CODE,NAME,SORT,MUST,UNIT,FACET_ABLE,INDEX_ABLE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "TEMPLATE_ID,CODE,NAME,SORT,MUST,UNIT,FACET_ABLE,INDEX_ABLE,REMARK";
    }

    @Override
    public String getExportFields() {
        return "TEMPLATE_NAME,CODE,NAME,SORT,MUST,UNIT,FACET_ABLE,INDEX_ABLE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "TEMPLATE_ID,CODE,NAME,SORT,MUST,UNIT,FACET_ABLE,INDEX_ABLE,REMARK";
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
        return "attr";
    }

    @Override
    public String getModuleCN() {
        return "属性";
    }

    @Override
    public String getTableName() {
        return "T_ATTR";
    }

    @Override
    public String getUniqKeys() {
        return "CODE";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select A.ID,A.TEMPLATE_ID,B.TEMPLATE_NAME,A.CODE,A.NAME,A.SORT,A.MUST,A.UNIT,A.FACET_ABLE,A.INDEX_ABLE,A.REMARK,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER from T_ATTR A LEFT JOIN T_DIR_ATTR B ON A.TEMPLATE_ID = B.ID ORDER BY A.NAME,A.ID";
    }

    @Override
    public List<ModuleRelConfig> getModuleRelConfigs() {
        List<ModuleRelConfig> results = new ArrayList<ModuleRelConfig>();
        Map<String,String> propMap = new HashMap<String,String>();
        propMap.put("ID","ATTR_ID");
        propMap.put("NAME","ATTR_NAME");
        BeanModuleConfig bmc = new AttrValueConfig(getProjectConfig());
        ModuleRelConfig rel = new ModuleRelConfig(propMap,bmc);
        results.add(rel);
        return results;
    }
}
