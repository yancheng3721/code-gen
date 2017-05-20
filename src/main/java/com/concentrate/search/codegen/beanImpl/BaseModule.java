package com.concentrate.search.codegen.beanImpl;

import com.concentrate.search.codegen.BeanModuleConfig;
import com.concentrate.search.codegen.ModuleConfig;
import com.concentrate.search.codegen.ProjectConfig;
import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * Created by admin on 2017/5/19.
 */
public abstract class BaseModule implements BeanModuleConfig{

    protected ProjectConfig projectConfig;


    protected BaseModule(ProjectConfig projectConfig){
        this.projectConfig = projectConfig;
    }

    public ProjectConfig getProjectConfig() {
        return projectConfig;
    }

    public LinkedHashMap<String, String> getAllReplaceMent() {
        //@org@.@system@.@project@.dao.@module@

        LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
        replacement.put("@package@", getPackage());
        replacement.put("@module@", getModule());
        replacement.put("@org@", getProjectConfig().getOrg());
        replacement.put("@system@", getProjectConfig().getSystem());
        replacement.put("@project@", getProjectConfig().getProject());
        replacement.put("@upperHeadModule@", String.valueOf(getModule().charAt(0)).toUpperCase()+ getModule().substring(1));
        replacement.put("@moduleCN@", getModuleCN());
        replacement.put("@TBName@", getTableName());
        replacement.put("@uniqKeys@", getUniqKeys());
        replacement
                .put("@querySql@",
                        getQuerySql());

        return replacement;
    }

    public LinkedHashMap<String, Map<String, String>> copyFileds(
            LinkedHashMap<String, Map<String, String>> fields, String str) {
        String[] strings = str.split(",");
        LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
        if (strings != null && strings.length > 0) {
            for (String string : strings) {
                if (fields.get(string) != null) {
                    results.put(string, fields.get(string));
                }
            }
        }
        return results;

    }

    public Map<String, String> newField(String key, String cn,
                                               String... features) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("_KEY_", key);
        result.put("_CN_", cn);
        if (features != null) {
            for (String f : features) {
                result.put("_" + f + "_", "1");
            }
        }
        return result;
    }
}
