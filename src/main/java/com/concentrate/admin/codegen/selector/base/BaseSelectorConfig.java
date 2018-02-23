package com.concentrate.admin.codegen.selector.base;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.selector.SelectorConfig;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2017/6/7.
 */
public abstract class BaseSelectorConfig implements SelectorConfig {

    ProjectConfig projectConfig = null;
    public BaseSelectorConfig(ProjectConfig projectConfig){
        this.projectConfig = projectConfig;
    }

    public LinkedHashMap<String, String> getAllReplaceMent(){
        LinkedHashMap<String,String> replacement = new LinkedHashMap<String,String>();
        replacement.put("@QuerySql@",getQuerySql());
        replacement.put("@SelectorCNName@",getSelectorCNName());
        replacement.put("@SelectorName@",getSelectorName());
        replacement.put("@UpperHeadSelectorName@",String.valueOf(getSelectorName().charAt(0)).toUpperCase()+ getSelectorName().substring(1));
        replacement.put("@context@", projectConfig.getContext());
        return replacement;
    }


    /**
     *
     * @param key
     * @param cn
     * @param features
     * UNIQ 唯一
     * NOT_NULL 不允许为空
     * TIME 日期类型，前台会有选择框
     * @return
     */
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
