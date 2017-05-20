package com.concentrate.search.codegen;

/**
 * Created by admin on 2017/5/19.
 */
public interface ProjectConfig {
    /**
     * public static String WORKSPACE = "E:/workspace_all/20121102";
     public static String JAVA_SOURCE_HOME = "src/main/java";
     public static String FREEMARKER_SOURCE_HOME = "src/main/webapp/WEB-INF/ftl";
     public static String CONTROLLER_TEMPLATE = "controllerTemplate.gen";
     public static String SERVICE_TEMPLATE = "serviceTemplate.gen";
     public static String DAO_TEMPLATE = "daoTemplate.gen";
     public static String FREEMARKER_TEMPLATE = "freemarkerTemplate.gen";
     public static String CONTEXT = "admin";
     public static String ORG = "concentrate";
     public static String SYSTEM = "search";
     public static String PROJECT = "admin";


     */

    ProjectConfig workspace(String workspace);
    ProjectConfig javaSourceHome(String javaSourceHome);
    ProjectConfig viewHome(String viewHome);
    ProjectConfig controllerTemplate(String controllerTemplate);
    ProjectConfig serviceTemplate(String serviceTemplate);
    ProjectConfig daoTemplate(String daoTemplate);
    ProjectConfig viewTemplate(String viewTemplate);
    ProjectConfig context(String context);
    ProjectConfig org(String org);
    ProjectConfig system(String system);
    ProjectConfig project(String org);

    public String getWorkspace();

    public String getJavaSourceHome();

    public String getViewHome();

    public String getControllerTemplate();

    public String getServiceTemplate();

    public String getDaoTemplate();

    public String getViewTemplate();

    public String getContext();

    public String getOrg();

    public String getSystem();

    public String getProject();

}
