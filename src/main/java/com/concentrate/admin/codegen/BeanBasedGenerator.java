package com.concentrate.admin.codegen;

import com.concentrate.admin.codegen.beanImpl.BaseModule;
import com.concentrate.admin.codegen.beanImpl.admin.*;
import com.concentrate.admin.codegen.beanImpl.yuyan.YuyanProject;
import com.concentrate.admin.codegen.beanImpl.yuyan.relation.ProductDirConfig;
import com.concentrate.admin.codegen.util.JSONUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by admin on 2017/5/20.
 */
public class BeanBasedGenerator {

    static boolean OVERWRITE = true;
    public static void main(String[] args) throws IOException {
        ProjectConfig pc = new YuyanProject();
        /**
        BaseModule user = new com.concentrate.admin.codegen.beanImpl.yuyan.UserConfig(pc);
        generateSingleModule(user);
        BaseModule role = new com.concentrate.admin.codegen.beanImpl.yuyan.RoleConfig(pc);
        generateSingleModule(role);
        BaseModule menu = new com.concentrate.admin.codegen.beanImpl.yuyan.MenuConfig(pc);
        generateSingleModule(menu);
        BaseModule resource = new com.concentrate.admin.codegen.beanImpl.yuyan.ResourceConfig(pc);
        generateSingleModule(resource);
        BaseModule module = new com.concentrate.admin.codegen.beanImpl.yuyan.SysModuleConfig(pc);
        generateSingleModule(module);

        BaseModule doc = new com.concentrate.admin.codegen.beanImpl.yuyan.DocConfig(pc);
        generateSingleModule(doc);
        BaseModule detail = new com.concentrate.admin.codegen.beanImpl.yuyan.DetailConfig(pc);
        generateSingleModule(detail);

        BaseModule successCase = new com.concentrate.admin.codegen.beanImpl.yuyan.SuccessCaseConfig(pc);
        generateSingleModule(successCase);

        BaseModule dir = new com.concentrate.admin.codegen.beanImpl.yuyan.DirectoryConfig(pc);
        generateSingleModule(dir);

        BaseModule attr = new com.concentrate.admin.codegen.beanImpl.yuyan.AttrConfig(pc);
        generateSingleModule(attr);

        BaseModule attrvalue = new com.concentrate.admin.codegen.beanImpl.yuyan.AttrValueConfig(pc);
        generateSingleModule(attrvalue);


        BaseModule product = new com.concentrate.admin.codegen.beanImpl.yuyan.ProductConfig(pc);
        generateSingleModule(product);

        BaseModule prodDir = new com.concentrate.admin.codegen.beanImpl.yuyan.relation.ProductDirConfig(pc);
        generateSingleModule(prodDir);

        BaseModule prodVal = new com.concentrate.admin.codegen.beanImpl.yuyan.relation.ProductValConfig(pc);
        generateSingleModule(prodVal);**/

        BaseModule dirattr = new com.concentrate.admin.codegen.beanImpl.yuyan.relation.DirAttrConfig(pc);
        generateSingleModule(dirattr);


    }

    public static void generateByProjectConfig(BaseModule mc) throws IOException {


    }

    public static void generateSingleModule(BeanModuleConfig mc) throws IOException {
        // mc.getAllReplaceMent();
        LinkedHashMap<String, Map<String, String>> fields = mc.getAllFileds();
        fields.putAll(mc.getDefaultFields());
        Map<String, String> replacement = mc.getAllReplaceMent();
        replacement.put("@allFieldsStr@",
                JSONUtil.toJSONString(fields.values(), ""));
        replacement.put("@searchBoxTr@",
                generateBox(copyFileds(fields, mc.getSearchFileds()), mc));
        replacement.put("@listTH@",
                generateTH(copyFileds(fields, mc.getViewFields())));
        replacement.put("@listTD@",
                generateTD(copyFileds(fields, mc.getViewFields()), mc));
        replacement.put("@relsBtn@",generateRelsBtns(mc));


        replacement.put("@saveboxTR@",
                generateSaveBox(copyFileds(fields, mc.getSaveFields()), mc));
        replacement.put("@importColumnLimit@",
                mc.getImportFields().split(",").length + "");
        replacement.put("@exportFields@", mc.getExportFields());
        replacement.put("@uploadLimit@", mc.getUploadLimit() + "");
        replacement.put("@importFields@", mc.getImportFields());
        replacement
                .put("@exportTemplate@",
                        generateExportTemplate(copyFileds(fields,
                                mc.getExportFields())));
        replacement.put("@exportTips@", generateExportTips(mc.getImportTips()));
        replacement.put("@dropDownSelect@",
                generateSelect(mc));
        replacement.put("@context@", mc.getProjectConfig().getContext());

        makeFtl(replacement,mc);
        makeController(replacement,mc);
        makeService(replacement,mc);
        makeDao(replacement,mc);
    }

    private static String generateRelsBtns(BeanModuleConfig mc) {
        String result = "";
        if(mc!=null && mc.getModuleRelConfigs()!=null){
            List<ModuleRelConfig> rels = mc.getModuleRelConfigs();
            if(rels!=null){
                for(ModuleRelConfig mrc : rels){
                    if(mrc!=null){
                        Map<String,String> propMap = mrc.propMaping;
                        BeanModuleConfig target = mrc.targetModule;
                        if(propMap!=null && target!=null){
                            result +="<a  href=\"javascript:void(0)\" onclick=\"openWinCenter('/"+mc.getProjectConfig().getContext()+"/"+target.getModule()+"/manage"+target.getAllReplaceMent().get("@upperHeadModule@")+".do?";
                            for(Map.Entry<String,String> entry:propMap.entrySet()){
                                String key = entry.getKey();
                                String value = entry.getValue();
                                result +="&defaultbox."+value+"=${obj."+key+"}";
                            }
                            result +="',800,600)\">"+target.getModuleCN()+"管理</a>&nbsp;|";
                        }
                    }
                }
            }
        }
        return result;
    }

    // map.put("@SELECT@Select",
    // dropDownSelectService.query(@SELECT_SQL@,@SELECT_FIELD@));
    private static String generateSelect(BeanModuleConfig mc) {
        LinkedHashMap<String, Map<String, String>> map = mc.getSelectFileds();
        String result = "";
        if (map != null && map.size() > 0) {
            Set<String> keySet = map.keySet();
            for (String k : keySet) {
                String select = k;
                String[] field = new String[2];
                String sql = "";
                Map<String, String> mm = map.get(k);
                Set<String> keySet1 = mm.keySet();
                for (String ss : keySet1) {
                    field = ss.split(",");
                    sql = (String) mm.get(ss);
                }
                result += "map.put(\"" + select
                        + "Select\", dropDownSelectService.query(\"" + sql
                        + "\",\"" + field[0] + "\",\"" + field[1] + "\"));\r\n";
            }
        }
        return result;
    }

    private static void makeAuthorization(Map<String, String> replacement,BeanModuleConfig mc)
            throws IOException {
        File f = createFile(mc.getProjectConfig().getWorkspace() + "/" + mc.getProjectConfig().getProject() + "/"
                        + mc.getProjectConfig().getJavaSourceHome() + "/"
                        + "com/"+mc.getProjectConfig().getOrg()+"/"+mc.getProjectConfig().getSystem()+"/"+mc.getProjectConfig().getProject()+"/dao/"+mc.getModule(),
                replacement.get("@upperHeadModule@") + "Auth.sql");
        // String s = FileUtils.readFileToString(new
        // File(WORKSPACE+"/"+PROJECT+"/"+TEMPLATE_HOME+"/"+"auth.gen"),
        // "utf-8");
        String s = FileUtils.readFileToString(
                new File(CodeGenerator.class.getClassLoader()
                        .getResource("bean_template/auth.gen")
                        .getFile()), "utf-8");
        // String s =
        // CodeGenerator.class.getClassLoader().getResource("com/concentrate/search/codegen/auth.gen").getFile();
        if (replacement != null && replacement.size() > 0) {
            for (Map.Entry<String, String> e : replacement.entrySet()) {
                String k = e.getKey();
                String v = e.getValue();
                System.out.println(k + ":" + v);
                s = s.replace(k, v);
            }
        }
        FileUtils.writeStringToFile(f, s, "utf-8");
    }

    private static String generateExportTips(String[] exportTips) {
        StringBuffer sb = new StringBuffer();
        if (exportTips != null && exportTips.length > 0) {
            for (int i = 0; i < exportTips.length; i++) {
                sb.append("<li>").append(exportTips[i]).append("</li>");
            }

        }
        return sb.toString();
    }

    private static String generateExportTemplate(
            LinkedHashMap<String, Map<String, String>> copyFileds) {
        StringBuffer result = new StringBuffer();
        if (copyFileds != null && copyFileds.size() > 0) {
            for (Map.Entry<String, Map<String, String>> e : copyFileds.entrySet()) {
                Map<String, String> v = e.getValue();
                String td = "<th>" + v.get("_CN_") + "</th>";
                result.append(td);
            }
        }
        return result.toString();
    }

    /**
     *
     @module@
      * @upperHeadModule@
     * @packageDao@
     * @TBName@
     * @querySql@ ________________up is dao template vars
     * @param replacement
     * @throws IOException
     */
    private static void makeDao(Map<String, String> replacement,BeanModuleConfig mc)
            throws IOException {
        File f = createFile(mc.getProjectConfig().getWorkspace() + "/" + mc.getProjectConfig().getProject() + "/"
                        + mc.getProjectConfig().getJavaSourceHome() + "/"
                        + "com/"+mc.getProjectConfig().getOrg()+"/"+mc.getProjectConfig().getSystem()+"/"+mc.getProjectConfig().getProject()+"/dao/"+mc.getPackage(),
                replacement.get("@upperHeadModule@") + "DAO.java");
        String s = FileUtils.readFileToString(
                new File(CodeGenerator.class
                        .getClassLoader()
                        .getResource(
                                mc.getProjectConfig().getDaoTemplate())
                        .getFile()), "utf-8");
        if (replacement != null && replacement.size() > 0) {
            for (Map.Entry<String, String> e : replacement.entrySet()) {
                String k = e.getKey();
                String v = e.getValue();
                System.out.println(k + ":" + v);
                s = s.replace(k, v);
            }
        }
        FileUtils.writeStringToFile(f, s, "utf-8");
    }

    private static File createFile(String path, String file) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File f = new File(path + "/" + file);
        if (f.exists() && !OVERWRITE) {
            return new File(path + "/" + file + ".new");
        } else {
            return f;
        }

    }

    private static void makeService(Map<String, String> replacement,BeanModuleConfig mc)
            throws IOException {
        File f = createFile(mc.getProjectConfig().getWorkspace() + "/" + mc.getProjectConfig().getProject() + "/"
                + mc.getProjectConfig().getJavaSourceHome() + "/"
                + "com/"+mc.getProjectConfig().getOrg()+"/"+mc.getProjectConfig().getSystem()+"/"+mc.getProjectConfig().getProject()+"/service/"+mc.getPackage()
                , replacement.get("@upperHeadModule@")
                        + "Service.java");
        String s = FileUtils
                .readFileToString(
                        new File(
                                CodeGenerator.class
                                        .getClassLoader()
                                        .getResource(
                                                mc.getProjectConfig().getServiceTemplate())
                                        .getFile()), "utf-8");
        if (replacement != null && replacement.size() > 0) {
            for (Map.Entry<String, String> e : replacement.entrySet()) {
                String k = e.getKey();
                String v = e.getValue();
                System.out.println(k + ":" + v);
                s = s.replace(k, v);
            }
        }
        FileUtils.writeStringToFile(f, s, "utf-8");
    }

    private static void makeController(Map<String, String> replacement,BeanModuleConfig mc)
            throws IOException {
        File f = createFile(mc.getProjectConfig().getWorkspace() + "/" + mc.getProjectConfig().getProject() + "/"
                        + mc.getProjectConfig().getJavaSourceHome() + "/"
                        + "com/"+mc.getProjectConfig().getOrg()+"/"+mc.getProjectConfig().getSystem()+"/"+mc.getProjectConfig().getProject()+"/controller/"+mc.getPackage(),
                replacement.get("@upperHeadModule@") + "Controller.java");
        String s = FileUtils
                .readFileToString(
                        new File(
                                CodeGenerator.class
                                        .getClassLoader()
                                        .getResource(
                                                mc.getProjectConfig().getControllerTemplate())
                                        .getFile()), "utf-8");
        if (replacement != null && replacement.size() > 0) {
            for (Map.Entry<String, String> e : replacement.entrySet()) {
                String k = e.getKey();
                String v = e.getValue();
                System.out.println(k + ":" + v);
                s = s.replace(k, v);
            }
        }
        FileUtils.writeStringToFile(f, s, "utf-8");
    }

    public static void makeFtl(Map<String, String> replacement,BeanModuleConfig mc)
    throws IOException {
        File f = createFile(
                mc.getProjectConfig().getWorkspace() + "/" + mc.getProjectConfig().getProject() + "/"
                        + mc.getProjectConfig().getViewHome() + "/"
                        + mc.getPackage(),
                "manage" + replacement.get("@upperHeadModule@") + ".ftl");
        String s = FileUtils
                .readFileToString(
                        new File(
                                CodeGenerator.class
                                        .getClassLoader()
                                        .getResource(
                                                mc.getProjectConfig().getViewTemplate())
                                        .getFile()), "utf-8");
        if (replacement != null && replacement.size() > 0) {
            for (Map.Entry<String, String> e : replacement.entrySet()) {
                String k = e.getKey();
                String v = e.getValue();
                System.out.println(k + ":" + v);
                s = s.replace(k, v);
            }
        }
        FileUtils.writeStringToFile(f, s, "utf-8");
    }

    private static String generateSaveBox(
            LinkedHashMap<String, Map<String, String>> map, BeanModuleConfig mc) {
        StringBuffer result = new StringBuffer();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Map<String, String>> e : map.entrySet()) {
                Map<String, String> v = e.getValue();
                String a = null;
                String attr = "";
                if ("1".equals(v.get("_READONLY_"))) {
                    attr = "readOnly='true' ";
                }
                if ("1".equals(v.get("_TIME_"))) {
                    a = "<tr style='height:35px;'> \r\n<td width='140px' align='right'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td> <input type='text' class='savebox Wdate' onClick='WdatePicker({dateFmt:\"yyyy-MM-dd HH:mm:ss\"})' name='savebox"
                            + v.get("_KEY_")
                            + "' id='savebox"
                            + v.get("_KEY_")
                            + "' " + attr + "></td>\r\n</tr>\r\n";
                } else if ("1".equals(v.get("_URL_"))) {
                    a = "<tr style='height:35px;'> \r\n<td width='140px' align='right'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td> <input type='url' class='savebox' name='savebox"
                            + v.get("_KEY_")
                            + "' id='savebox"
                            + v.get("_KEY_")
                            + "' " + attr + "></td>\r\n</tr>\r\n";
                } else if (mc.getSelectFileds() != null
                        && mc.getSelectFileds().get(e.getKey()) != null) {// 下拉框
                    a = "<tr style='height:35px;'> \r\n"
                            + "<td width='140px' align='right'>"
                            + v.get("_CN_")
                            + "：</td>\r\n"
                            + "<td><select style='width:100%;' class='savebox'  name='savebox"
                            + v.get("_KEY_")
                            + "' id='savebox"
                            + v.get("_KEY_")
                            + "'>\r\n\t"
                            + "<option value=''>选择"
                            + v.get("_CN_")
                            + "</option>\r\n"
                            + "<#if "
                            + v.get("_KEY_")
                            + "Select??>\r\n<#list "
                            + v.get("_KEY_")
                            + "Select?keys as key>\r\n\t"
                            + "<option value='${key}'>${"
                            + v.get("_KEY_")
                            + "Select[key]}</option>\r\n</#list>\r\n</#if>\r\n\t</select>\r\n</td>\r\n"
                            + "</tr>\r\n";
                } else if ("1".equals(v.get("_DIRECTORY_"))) {
                    a = "<tr style='height:35px;'>\r\n<td width='140px' align='right'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td> <input type='text' class='savebox' name='savebox"
                            + v.get("_KEY_")
                            + "' id='savebox"
                            + v.get("_KEY_")
                            + "' "
                            + attr
                            + "><button type='button' onclick='showDirectoryTree(0)' id='selectDirectory'><span><span>选择</span></span></button></td>\r\n</tr>\r\n"
                            + "<tr style='height:35px;'>\r\n<td width='140px' align='right'>目录名称：</td>\r\n"
                            + "<td> <input class='showbox'  name='showboxNAME' id='showboxNAME' readonly='true' style='background-color:#CFCFCF;width:140px;height:20px;border: 1px solid #999;border-radius:3px;'/>\r\n</td>\r\n</tr>";
                } else if (mc.getFixedSelectFileds() != null
                        && mc.getFixedSelectFileds().get(e.getKey()) != null) {
                    a = "<tr style='height:35px;'>\r\n<td width='140px' align='right'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td> <select style='width:100%;' class='savebox'  name='savebox"
                            + v.get("_KEY_")
                            + "' id='savebox"
                            + v.get("_KEY_")
                            + "'>\r\n\t ";
                    Map<String, String> mm = mc.getFixedSelectFileds().get(
                            e.getKey());
                    Set<String> keySet = mm.keySet();
                    for (String key : keySet) {
                        a = a + "<option value='" + key + "'>" + mm.get(key)
                                + "</option>\r\n";
                    }
                    a = a + "</select>\r\n</td>\r\n</tr>\r\n";
                } else {
                    a = "<tr style='height:35px;'>\r\n<td width='140px' align='right'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td> <input type='text' class='savebox'  name='savebox"
                            + v.get("_KEY_")
                            + "' id='savebox"
                            + v.get("_KEY_")
                            + "' " + attr + "></td>\r\n</tr>\r\n";
                }

                result.append(a);
            }
        }
        return result.toString();
    }

    private static String generateTD(
            LinkedHashMap<String, Map<String, String>> map, BeanModuleConfig mc) {
        StringBuffer result = new StringBuffer();
        LinkedHashMap<String, Map<String, String>> fixedSelect = mc
                .getFixedSelectFileds();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Map<String, String>> e : map.entrySet()) {
                Map<String, String> v = e.getValue();
                String td = "";
                if (fixedSelect != null) {
                    Map<String, String> mm = fixedSelect.get(v.get("_KEY_"));
                    if (mm != null) {
                        String ss = "obj." + v.get("_KEY_") + "='";
                        Set<String> keySet = mm.keySet();
                        int i = 1;
                        for (String key : keySet) {
                            String temp = "";
                            temp = ss + key + "'>" + mm.get(key);
                            if (i == 1) {
                                temp = "<#if " + temp;
                            } else {
                                temp = "<#elseif " + temp;
                            }
                            i++;
                            td = td + temp;
                        }
                        td = "<td>" + td + "</#if></td>\r\n";
                    }
                }
                if (td.isEmpty()) {
                    td = "<td>${obj." + v.get("_KEY_") + "}</td>\r\n";
                }
                result.append(td);
            }
        }
        return result.toString();
    }

    private static String generateTH(
            LinkedHashMap<String, Map<String, String>> map) {
        StringBuffer result = new StringBuffer();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Map<String, String>> e : map.entrySet()) {

                Map<String, String> v = e.getValue();
                String td = "<th>" + v.get("_CN_") + "</th>\r\n";
                result.append(td);

            }
        }
        return result.toString();
    }

    private static LinkedHashMap<String, Map<String, String>> copyFileds(
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

    public static Map<String, String> newField(String key, String cn,
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

    private static String generateBox(
            LinkedHashMap<String, Map<String, String>> map, BeanModuleConfig mc) {
        StringBuffer result = new StringBuffer();
        StringBuffer tr = new StringBuffer();
        int i = 0;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Map<String, String>> e : map.entrySet()) {
                Map<String, String> v = e.getValue();
                String td = "";
                if ("1".equals(v.get("_TIME_"))) {
                    td = "<td class='tdName'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td style='width:140px;'> <input type='text' class='searchbox Wdate' onClick='WdatePicker({dateFmt:\"yyyy-MM-dd HH:mm:ss\"})' name='searchbox."
                            + v.get("_KEY_") + "' id='searchbox."
                            + v.get("_KEY_") + "' value='${searchbox[\""
                            + v.get("_KEY_") + "\"]}'/></td>\r\n";
                } else if (mc.getSelectFileds() != null
                        && mc.getSelectFileds().get(e.getKey()) != null) {
                    td = "<td class='tdName'>"
                            + v.get("_CN_")
                            + "：</td>\r\n"
                            + "<td>\r\n\t<select style='width:140px;' name='searchbox."
                            + v.get("_KEY_")
                            + "' id='searchbox."
                            + v.get("_KEY_")
                            + "'>\r\n\t"
                            + "<option value=''>选择"+ v.get("_CN_")+ "</option>\r\n\t"
                            + "<#if "+ v.get("_KEY_") + "Select??>\r\n<#list "
                            + v.get("_KEY_")
                            + "Select?keys as key>"
                            + "\r\n<#if searchbox[\""
                            + v.get("_KEY_")
                            + "\"] == key >\r\n\t"
                            + "<option value='${key}' selected='selected'>${"
                            + v.get("_KEY_")
                            + "Select[key]}</option>\r\n<#else>\r\n\t"
                            + "<option value='${key}'>${"
                            + v.get("_KEY_")
                            + "Select[key]}</option>\r\n</#if></#list></#if>\r\n\t</select>\r\n</td>\r\n";
                } else if (mc.getFixedSelectFileds() != null
                        && mc.getFixedSelectFileds().get(e.getKey()) != null) {
                    td = "<td class='tdName'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td> <select style='width:140px;' class='searchbox.'  name='searchbox."
                            + v.get("_KEY_") + "' id='searchbox."
                            + v.get("_KEY_") + "'>\r\n\t ";
                    Map<String, String> mm = mc.getFixedSelectFileds().get(
                            e.getKey());
                    Set<String> keySet = mm.keySet();
                    for (String key : keySet) {
                        td = td + "<option value='" + key
                                + "' <#if searchbox[\"" + v.get("_KEY_") + "\"] ==\'" + key+ "\'> selected='selected'</#if>>"
                                + mm.get(key) + "</option>\r\n";
                    }
                    td = td + "</select>\r\n</td>\r\n";
                } else if ("1".equals(v.get("_DIRECTORY_"))) {
                    td = "<td class='tdName'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td style='width:140px;'> <input type='text' class='searchbox'  name='searchbox."
                            + v.get("_KEY_")
                            + "' id='searchbox."
                            + v.get("_KEY_")
                            + "'><button type='button' onclick='showDirectoryTree(1)' id='selectDirectory'><span><span>选择</span></span></button></td>\r\n</tr>\r\n"
                            + "<tr style='height:35px;'>\r\n<td width='140px' align='right'>目录名称：</td>\r\n"
                            + "<td> <input class='showbox'  name='showboxNAME' id='showboxNAME' readonly='true' style='background-color:#CFCFCF;width:140px;border: 1px solid #999;border-radius:3px;'/>\r\n</td>\r\n";
                } else {
                    td = "<td class='tdName'>"
                            + v.get("_CN_")
                            + "：</td>\r\n<td style='width:140px;'>\r\n<input name='searchbox."
                            + v.get("_KEY_") + "' type='text' id='searchbox."
                            + v.get("_KEY_") + "'  value='${searchbox[\""
                            + v.get("_KEY_") + "\"]}' />\r\n</td>";
                }
                tr.append(td);
                i++;
                if (i % 3 == 0 || i == map.size()) {
                    result.append("<tr>\r\n").append(tr).append("</tr>\r\n");
                    tr = new StringBuffer();
                }
            }
        }
        return result.toString();
    }
}
