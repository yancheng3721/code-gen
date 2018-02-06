package com.concentrate.admin.codegen;

import java.util.Map;

/**
 * Created by admin on 2018/2/7.
 */
public class ModuleRelConfig {
    public Map<String,String> propMaping = null;
    public BeanModuleConfig targetModule;

    public ModuleRelConfig(Map<String,String> propMaping ,BeanModuleConfig targetModule ){
        this.propMaping = propMaping;
        this.targetModule = targetModule;
    }


}
