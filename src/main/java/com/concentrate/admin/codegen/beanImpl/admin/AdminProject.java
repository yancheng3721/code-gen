package com.concentrate.admin.codegen.beanImpl.admin;

import com.concentrate.admin.codegen.beanImpl.BaseProject;

/**
 * Created by admin on 2017/5/20.
 */
public class AdminProject extends BaseProject {

    public AdminProject(){
        this.workspace="F:/develop/github/";
        this.javaSourceHome="src/main/java";
        this.viewHome="src/main/webapp/WEB-INF/ftl";
        this.controllerTemplate="bean_template/controllerTemplate.gen";
        this.serviceTemplate="bean_template/serviceTemplate.gen";
        this.daoTemplate="bean_template/daoTemplate.gen";
        this.viewTemplate="bean_template/freemarkerTemplate.gen";
        this.context="admin";
        this.org="concentrate";
        this.system="search";
        this.project="admin";
        this.configPath="/opt/concentrate/";
    }
}
