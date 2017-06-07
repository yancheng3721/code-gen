package com.concentrate.search.codegen.selector.base;

import com.concentrate.search.codegen.ProjectConfig;
import com.concentrate.search.codegen.ProjectInfo;
import com.concentrate.search.codegen.selector.SelectorConfig;

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




}
