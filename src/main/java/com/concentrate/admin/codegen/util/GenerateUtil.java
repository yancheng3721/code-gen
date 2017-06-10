package com.concentrate.admin.codegen.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2017/6/10.
 */
public class GenerateUtil {

    /**
     *
     * @param fieldMap
     * @param field array of field,index at 0 is the key,index at 1 is th name,index 2 to length-1 is feature
     * feature emum:
     * UNIQ 唯一
     * NOT_NULL 不允许为空
     * TIME 日期类型，前台会有选择框
     * @return
     */
    public static void addField(Map<String,Map<String,String>> fieldMap,String ... field){
        if(fieldMap!=null && field.length>=1){
            Map<String,String> fieldInfoMap = new LinkedHashMap<String,String>();
            String key = field[0];
            String cn = key;
            if(field.length>1){
                cn = field[1];
            }
            fieldInfoMap.put("_KEY_",key);
            fieldInfoMap.put("_CN_", cn);
            fieldMap.put(key,fieldInfoMap);
            if(field.length>2){
                for(int i=0;i<field.length;i++){
                    fieldInfoMap.put("_"+field[i]+"_", "1");
                }
            }
        }
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
}
