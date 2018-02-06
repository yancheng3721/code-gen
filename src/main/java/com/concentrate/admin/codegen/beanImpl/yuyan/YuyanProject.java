package com.concentrate.admin.codegen.beanImpl.yuyan;

import com.concentrate.admin.codegen.beanImpl.BaseProject;

/**
 * Created by admin on 2017/5/20.
 */
public class YuyanProject extends BaseProject {

    /**
     * com.@org@.@system@.@project@.controller.@package@;
     */
    public YuyanProject(){
        this.workspace="F:/develop/yuyan/";
        this.javaSourceHome="src/main/java";
        this.viewHome="src/main/webapp/WEB-INF/ftl";
        this.controllerTemplate="bean_template/controllerTemplate.gen";
        this.serviceTemplate="bean_template/serviceTemplate.gen";
        this.daoTemplate="bean_template/daoTemplate.gen";
        this.viewTemplate="bean_template/freemarkerTemplate.gen";
        this.context="yuyan";
        this.org="yuyan";
        this.system="emall";
        this.project="admin";
        this.configPath="/opt/yuyan/";
    }
}
