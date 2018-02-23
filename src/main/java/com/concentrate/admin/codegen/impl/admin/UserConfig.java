package com.concentrate.admin.codegen.impl.admin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.admin.codegen.CodeGenerator;
import com.concentrate.admin.codegen.ModuleConfig;

public class UserConfig implements ModuleConfig {

    /*
       drop table if exists T_USER;
       create table T_USER
               (
                       ID                   bigint not null auto_increment,
                       PASSWORD             varchar(120) not null,
       STATUS               smallint not null,
       ALIAS                varchar(120) not null,
       NAME                 varchar(120) not null,
       CREATE_TIME          timestamp not null,
       UPDATE_TIME          timestamp not null,
       UPDATE_USER          varchar(60),
       primary key (ID)
       );
   */
    @Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("NAME", CodeGenerator.newField("NAME", "用户名", "NOT_NULL"));
		results.put("ALIAS", CodeGenerator.newField("ALIAS", "别名"));
		results.put("PASSWORD",
				CodeGenerator.newField("PASSWORD", "密码", "NOT_NULL"));
		results.put("STATUS",
				CodeGenerator.newField("STATUS", "账号状态", "NOT_NULL"));
		results.put("UPDATE_USER",
				CodeGenerator.newField("UPDATE_USER", "更新用户"));
		results.put("CREATE_TIME",
				CodeGenerator.newField("CREATE_TIME", "创建时间"));
		results.put("UPDATE_TIME",
				CodeGenerator.newField("UPDATE_TIME", "更新时间"));
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getSelectFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> cacheType = new HashMap<String, String>();
		cacheType.put("ID,NAME", "SELECT ID,NAME FROM T_ROLE");
		results.put("ROLE_ID", cacheType);
		return null;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
        replacement.put("@module@", "user");
        replacement.put("@package@", "com.concentrate.search.admin");
        replacement.put("@upperHeadModule@", "User");
		replacement.put("@moduleCN@", "用户管理");
		replacement.put("@packageController@",
				"com.concentrate.search.admin.controller.system");
		replacement.put("@packageService@",
				"com.concentrate.search.admin.service.system");
		replacement.put("@packageDao@", "com.concentrate.search.admin.dao.system");
		replacement.put("@TBName@", "T_USER");
		replacement.put("@uniqKeys@", "NAME");
		replacement
				.put("@querySql@",
						"SELECT A.ID,A.NAME,A.ALIAS,A.STATUS FROM T_USER AS A ORDER BY A.NAME");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "NAME,ALIAS";
	}

	@Override
	public String getViewFields() {
		return "NAME,ALIAS,STATUS";
	}

	@Override
	public String getSaveFields() {
		return "NAME,ALIAS,PASSWORD,STATUS";
	}

	@Override
	public String getExportFields() {
		return "NAME,ALIAS";
	}

	@Override
	public String getImportFields() {
		return "NAME,ALIAS,PASSWORD,STATUS";
	}

	@Override
	public String[] getExportTips() {
		return "1 请保证上传数据列数正确;2 每次上传限制1000条;3 上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		return 300;
	}

}
