package com.concentrate.search.codegen.selector;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ProjectInfo;

public class SelectorGenerater {


	
	
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
		ProjectInfo.WORKSPACE = "D:/workspaces";
		ProjectInfo.PROJECT = "admin-1.0.67";
		ProjectInfo.CONTEXT = "admin";
		ProjectInfo.OVERWRITE=true;
		SelectorConfig mc = new BigPromotionLotterySelector();
		generateSelector(mc);
	}
	
	private static void generateSelector(SelectorConfig mc) throws IOException {

		mc.getAllReplaceMent();
		LinkedHashMap<String,Map<String,String>> fields = mc.getAllFileds();
		Map<String,String> replacement = mc.getAllReplaceMent();
		 
		replacement.put("@searchBoxTr@",generateBox(copyFileds(fields,mc.getSearchFileds())));
		replacement.put("@listTH@",generateTH(copyFileds(fields,mc.getViewFields())));
		replacement.put("@listTD@",generateTD(copyFileds(fields,mc.getViewFields())));
		replacement.put("@returnArrayStr@",generateRetrunAry(copyFileds(fields,mc.getReturnFileds())));
		replacement.put("@context@", ProjectInfo.CONTEXT);
		makeSelectorFtl(replacement);

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
		if(f.exists()){
			return new File(path+"/"+file+".new");
		}else{
			return f;
		}
		
	}



	public static void makeSelectorFtl(Map<String, String> replacement) throws IOException {
		File f = createFile(ProjectInfo.WORKSPACE+"/"+ProjectInfo.PROJECT+"/"+ProjectInfo.FREEMARKER_SOURCE_HOME+"/selector",replacement.get("@SelectorName@")+".ftl");
		String s = FileUtils.readFileToString(new File(CodeGenerator.class.getClassLoader().getResource("com/concentrate/search/codegen/selector.gen").getFile()), "utf-8");
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
