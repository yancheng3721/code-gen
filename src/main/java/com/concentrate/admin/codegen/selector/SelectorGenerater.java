package com.concentrate.admin.codegen.selector;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.concentrate.admin.codegen.ProjectConfig;
import com.concentrate.admin.codegen.beanImpl.admin.AdminProject;
import com.concentrate.admin.codegen.beanImpl.yuyan.YuyanProject;
import com.concentrate.admin.codegen.selector.impl.AttrSelector;
import com.concentrate.admin.codegen.selector.impl.UserSelector;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.io.FileUtils;

import com.concentrate.admin.codegen.CodeGenerator;

public class SelectorGenerater {

    static boolean OVERRIDE = true;

    static XStream xstream = new XStream();
	
	
	/**
	@QuerySql@
	@UpperHeadSelectorName@
	@SelectorName@
	@SelectorCNName@
	@SelectorQueryTr@
	@SelectorViewTh@
	@SelectorViewTd@
	@returnArrayStr@
		
	*/
	public static void main(String[] args) throws IOException {
/*        ProjectConfig pc = new AdminProject();
        SelectorConfig sc = new UserSelector(pc);*/

        ProjectConfig yuyan = new YuyanProject();
        SelectorConfig atsc = new AttrSelector(yuyan);
        generateSelector(atsc);
	}
	
	private static void generateSelector(SelectorConfig sc) throws IOException {

		LinkedHashMap<String,Map<String,String>> fields = sc.getAllFileds();
        LinkedHashMap<String,String> replacement = sc.getAllReplaceMent();
        replacement.put("@searchBoxTr@",generateBox(copyFileds(fields,sc.getSearchFileds())));
        replacement.put("@listTH@",generateTH(copyFileds(fields,sc.getViewFields())));
        replacement.put("@listTD@",generateTD(copyFileds(fields,sc.getViewFields())));
        replacement.put("@returnArrayStr@",generateRetrunAry(copyFileds(fields,sc.getReturnFileds())));
        makeModuleSql(sc);
		makeSelectorFtl(replacement,sc);

	}

    private static void makeModuleSql(SelectorConfig sc) throws IOException {
        String configPath = sc.getProjectConfig().getConfigPath();
        String fullPath = configPath+"/admin/configs/";
        String fileName = "sqlContxt.xml";
        File configFile = new File(fullPath+fileName);
        if(!configFile.exists()){
            File dir = new File(fullPath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            configFile.createNewFile();
        }
        String xmlStr = FileUtils.readFileToString(configFile,"utf-8");
        Map<String,String> context = new HashMap<String,String>();
        if(xmlStr!=null && !"".equals(xmlStr)){
            context = (Map<String, String>) xstream.fromXML(xmlStr);
        }
        String module = sc.getSelectorName();
        String sql = sc.getQuerySql();
        if(null == context.get(module) || OVERRIDE){//不存在配置 ，或者强制覆盖
            context.put(module,sql);
            FileUtils.writeStringToFile(configFile,xstream.toXML(context),"utf-8");;
        }

    }

    private static String generateRetrunAry(
			LinkedHashMap<String, Map<String, String>> map) {
		StringBuffer result = new StringBuffer();
		if(map!=null && map.size()>0){
			int i=0;
			for(Entry<String, Map<String, String>> e:map.entrySet()){
				if(i!=0){
					result.append(",");
				}
				Map<String, String> v = e.getValue();
				String field = "'${obj."+v.get("_KEY_")+"}'";
				result.append(field);
				i++;
			}
		}
		return result.toString();
	}

	private static File createFile(String path, String file) {
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		File f = new File(path+"/"+file);
		if(f.exists()&&!OVERRIDE){
			return new File(path+"/"+file+".new");
		}else{
			return f;
		}
		
	}



	public static void makeSelectorFtl(Map<String, String> replacement, SelectorConfig mc) throws IOException {
		File f = createFile(mc.getProjectConfig().getWorkspace()+"/"+mc.getProjectConfig().getProject()+"/"+mc.getProjectConfig().getViewHome()+"/selector",mc.getSelectorName()+".ftl");
		String s = FileUtils.readFileToString(new File(CodeGenerator.class.getClassLoader().getResource("bean_template/selector.gen").getFile()), "utf-8");
		if(replacement!=null&&replacement.size()>0){
			for(Map.Entry<String, String> e:replacement.entrySet()){
				String k = e.getKey();
				String v = e.getValue();
				System.out.println(k+":"+v);
				s=s.replace(k, v);
			}
		}
		FileUtils.writeStringToFile(f, s, "utf-8");
	}



	private static String generateTD(
			LinkedHashMap<String, Map<String, String>> map) {
		StringBuffer result = new StringBuffer();
		if(map!=null && map.size()>0){
			for(Entry<String, Map<String, String>> e:map.entrySet()){
				Map<String, String> v = e.getValue();
				String td = "<td>${obj."+v.get("_KEY_")+"}</td>";
				result.append(td);
			}
		}
		return result.toString();
	}


	private static String generateTH(
			LinkedHashMap<String, Map<String, String>> map) {
		StringBuffer result = new StringBuffer();
		if(map!=null && map.size()>0){
			for(Entry<String, Map<String, String>> e:map.entrySet()){
				
				Map<String, String> v = e.getValue();
				String td = "<th>"+v.get("_CN_")+"</th>";
				result.append(td);
				
			}
		}
		return result.toString();
	}





	private static LinkedHashMap<String, Map<String, String>> copyFileds(
			LinkedHashMap<String, Map<String, String>> fields, String str) {
		String[] strings = str.split(",");
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		if(strings!=null&&strings.length>0){
			for(String string:strings){
				if(fields.get(string)!=null){
					results.put(string, fields.get(string));
				}
			}
		}
		return results;
		
	}


	public static Map<String, String> newFiled(String key, String cn,String... features) {
		Map<String, String> result=new HashMap<String, String>();
		result.put("_KEY_", key);
		result.put("_CN_", cn);
		if(features!=null){
			for(String f:features){
				result.put("_"+f+"_", "1");
			}
		}
		return result;
	}


	private static String generateBox(LinkedHashMap<String, Map<String, String>> map) {
		StringBuffer result = new StringBuffer();
		StringBuffer tr = new StringBuffer();
		int i=0;
		if(map!=null && map.size()>0){
			for(Entry<String, Map<String, String>> e:map.entrySet()){
				
				Map<String, String> v = e.getValue();
				String td = "<td class='tdName'>"+v.get("_CN_")+":</td><td><input name='searchbox."+v.get("_KEY_")+"' type='text' id='searchbox."+v.get("_KEY_")+"'  value='${searchbox[\""+v.get("_KEY_")+"\"]}' /></td>";
				tr.append(td);
				i++;
				if(i%2==0||i==map.size()){
					result.append("<tr>").append(tr).append("</tr>");
					tr = new StringBuffer();
				}
			}
		}
		return result.toString();
	}
}
