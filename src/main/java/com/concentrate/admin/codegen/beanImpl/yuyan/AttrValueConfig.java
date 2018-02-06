package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.ModuleRelConfig;
import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.BaseModule;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/2/2.
 */
public class AttrValueConfig extends BaseModule {

    public AttrValueConfig(ProjectConfig projectConfig) {
        super(projectConfig);
    }

    /**
     * create table T_ATTR_VALUE
     (
     ID                   bigint not null auto_increment,
     ATTR_ID              bigint,
     CODE                 varchar(60),
     NAME                 varchar(120),
     SORT                 int,
     STATE                char(1),
     REMARK               varchar(600),
     CREATE_TIME          timestamp not null,
     UPDATE_TIME          timestamp not null,
     UPDATE_USER          varchar(60) not null,
     primary key (ID)
     )
     auto_increment = 1000000;
     *
     * @return
     */
    @Override
    public LinkedHashMap<String, Map<String, String>> getAllFileds() {
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        results.put("ID", newField("ID", "ID"));
        results.put("ATTR_ID", newField("ATTR_ID", "属性ID", "NOT_NULL"));
        results.put("ATTR_NAME", newField("ATTR_NAME", "属性名称"));
        results.put("ATTR_UNIT", newField("ATTR_UNIT", "属性单位"));
        results.put("CODE", newField("CODE", "属性值编码", "NOT_NULL"));
        results.put("NAME", newField("NAME", "属性值名称", "NOT_NULL"));
        results.put("SORT", newField("SORT", "排序值"));
        results.put("STATE", newField("STATE", "是否有效"));
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
        Map<String, String> status = new LinkedHashMap<String,String>();
        result.put("STATE",status);
        status.put("","请选择");
        status.put("1","是");
        status.put("0","否");
        return result;
    }

    @Override
    public String getSearchFileds() {
        return "ATTR_ID,CODE,NAME,SORT,STATE,REMARK";
    }

    @Override
    public String getViewFields() {
        return "ATTR_ID,ATTR_NAME,ATTR_UNIT,CODE,NAME,SORT,STATE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getSaveFields() {
        return "ATTR_ID,CODE,NAME,SORT,STATE,REMARK";
    }

    @Override
    public String getExportFields() {
        return "ATTR_ID,ATTR_NAME,ATTR_UNIT,CODE,NAME,SORT,STATE,REMARK,CREATE_TIME,UPDATE_TIME,UPDATE_USER";
    }

    @Override
    public String getImportFields() {
        return "ATTR_ID,CODE,NAME,SORT,STATE,REMARK";
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
        return "attrvalue";
    }

    @Override
    public String getModuleCN() {
        return "属性值";
    }

    @Override
    public String getTableName() {
        return "T_ATTR_VALUE";
    }

    @Override
    public String getUniqKeys() {
        return "ATTR_ID,CODE";
    }

    @Override
    public String getQuerySql() {
        //"NAME,ALIAS,STATUS,CREATE_TIME,UPDATE_TIME,UPDATE_USER"
        return "select A.ID,ATTR_ID,B.NAME AS ATTR_NAME,B.UNIT AS ATTR_UNIT,A.CODE,A.NAME,A.SORT,A.STATE,A.REMARK,A.CREATE_TIME,A.UPDATE_TIME,A.UPDATE_USER from T_ATTR_VALUE A LEFT JOIN T_ATTR B ON A.ATTR_ID = B.ID ORDER BY B.NAME,A.SORT";
    }

    @Override
    public List<ModuleRelConfig> getModuleRelConfigs() {
        return null;
    }
}
