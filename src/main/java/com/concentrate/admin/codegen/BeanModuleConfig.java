package com.concentrate.admin.codegen;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/20.
 */
public interface BeanModuleConfig {
    LinkedHashMap<String,Map<String,String>> getDefaultFields();

    LinkedHashMap<String,Map<String,String>> getAllFileds();

    LinkedHashMap<String,Map<String,String>> getSelectFileds();//下拉框的值不固定

    LinkedHashMap<String,Map<String,String>> getFixedSelectFileds();//下拉框的值固定

    LinkedHashMap<String,String> getAllReplaceMent();

    String getSearchFileds();

    String getViewFields();

    String getSaveFields();

    String getExportFields();

    String getImportFields();

    String [] getImportTips();

    int getUploadLimit();

    ProjectConfig getProjectConfig();

    String getPackage();

    String getModule();

    String getModuleCN();

    String getTableName();

    String getUniqKeys();

    String getQuerySql();

    List<ModuleRelConfig> getModuleRelConfigs();
}
