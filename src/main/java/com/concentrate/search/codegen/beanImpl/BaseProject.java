package com.concentrate.search.codegen.beanImpl;

import com.concentrate.search.codegen.ProjectConfig;

/**
 * Created by admin on 2017/5/19.
 */
public class BaseProject implements ProjectConfig {
    protected String workspace;
    protected String javaSourceHome;
    protected String viewHome;
    protected String controllerTemplate;
    protected String serviceTemplate;
    protected String daoTemplate;
    protected String viewTemplate;
    protected String context;
    protected String org;
    protected String system;
    protected String project;
    
    @Override
    public ProjectConfig workspace(String workspace) {
        this.workspace=workspace;
        return this;
    }

    @Override
    public ProjectConfig javaSourceHome(String javaSourceHome) {
        this.javaSourceHome=javaSourceHome;
        return this;
    }

    @Override
    public ProjectConfig viewHome(String viewHome) {
        this.viewHome=viewHome;
        return this;
    }

    @Override
    public ProjectConfig controllerTemplate(String controllerTemplate) {
        this.controllerTemplate=controllerTemplate;
        return this;
    }

    @Override
    public ProjectConfig serviceTemplate(String serviceTemplate) {
        this.serviceTemplate=serviceTemplate;
        return this;
    }

    @Override
    public ProjectConfig daoTemplate(String daoTemplate) {
        this.daoTemplate=daoTemplate;
        return this;
    }

    @Override
    public ProjectConfig viewTemplate(String viewTemplate) {
        this.viewTemplate=viewTemplate;
        return this;
    }

    @Override
    public ProjectConfig context(String context) {
        this.context=context;
        return this;
    }

    @Override
    public ProjectConfig org(String org) {
        this.org=org;
        return this;
    }

    @Override
    public ProjectConfig system(String system) {
        this.system=system;
        return this;
    }

    @Override
    public ProjectConfig project(String org) {
        this.org=org;
        return this;
    }

    public String getWorkspace() {
        return workspace;
    }

    public String getJavaSourceHome() {
        return javaSourceHome;
    }

    public String getViewHome() {
        return viewHome;
    }

    public String getControllerTemplate() {
        return controllerTemplate;
    }

    public String getServiceTemplate() {
        return serviceTemplate;
    }

    public String getDaoTemplate() {
        return daoTemplate;
    }

    public String getViewTemplate() {
        return viewTemplate;
    }

    public String getContext() {
        return context;
    }

    public String getOrg() {
        return org;
    }

    public String getSystem() {
        return system;
    }

    public String getProject() {
        return project;
    }
}
