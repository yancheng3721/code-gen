package com.concentrate.admin.codegen;

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
    ProjectConfig configPath(String configPath);


    /**
     * project sourcecoude workspace absolute path
     * @return
     */
    public String getWorkspace();

    /**
     * generated sourcecoude path e.g src/main/java
     * @return
     */
    public String getJavaSourceHome();

    /**
     * generated viewer path e.g src/main/webapp/WEB-INF/ftl
     * @return
     */
    public String getViewHome();

    /**
     * controller codetemplate path ,relative path of this codegen project
     * @return
     */
    public String getControllerTemplate();

    /**
     * service codetemplate path ,relative path of this codegen project
     * @return
     */
    public String getServiceTemplate();

    /**
     * dao codetemplate path ,relative path of this codegen project
     * @return
     */
    public String getDaoTemplate();

    /**
     * viewer codetemplate path ,relative path of this codegen project
     * @return
     */
    public String getViewTemplate();

    /**
     * webapplication context
     * @return
     */
    public String getContext();

    /**
     * orgnization ,it is similar to groupId of maven project
     * @return
     */
    public String getOrg();

    /**
     * orgnization ,it is similar to groupId of maven project
     * @return
     */
    public String getSystem();

    /**
     * orgnization ,it is similar to artifactId of maven project
     * @return
     */
    public String getProject();

    /**
     * file system based config file path. e.g /opt/concentrate/admin/configs
     * @return
     */
    public String getConfigPath();

}
