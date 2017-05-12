package com.concentrate.search.codegen.impl.she;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.CodeGenerator;
import com.concentrate.search.codegen.ModuleConfig;

public class IrregularityAppealConfig implements ModuleConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", CodeGenerator.newField("ID", "ID"));
		results.put("IRREGULARITY_ID",
				CodeGenerator.newField("IRREGULARITY_ID", "违规记录ID", "NOT_NULL"));
		results.put("CONTACT",
				CodeGenerator.newField("CONTACT", "联系方式", "NOT_NULL"));
		results.put("REASON",
				CodeGenerator.newField("REASON", "申诉理由", "NOT_NULL"));
		results.put("MESSAGE", CodeGenerator.newField("MESSAGE", "留言"));
		results.put("ATTACHMENT", CodeGenerator.newField("ATTACHMENT", "附件"));
		results.put("STATUS",
				CodeGenerator.newField("STATUS", "申诉状态", "NOT_NULL"));
		results.put("REMARK", CodeGenerator.newField("REMARK", "备注"));
		results.put("AUDIT_TIME",
				CodeGenerator.newField("AUDIT_TIME", "审核状态", "NOT_NULL"));
		results.put("AUDIT_USER",
				CodeGenerator.newField("AUDIT_USER", "审核人", "NOT_NULL"));
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
		return null;
	}

	@Override
	public LinkedHashMap<String, Map<String, String>> getFixedSelectFileds() {
		return null;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@module@", "irregularityappeal");
		replacement.put("@upperHeadModule@", "IrregularityAppeal");
		replacement.put("@moduleCN@", "违规查询");
		replacement.put("@packageController@",
				"com.concentrate.search.she.controller.irregularity");
		replacement.put("@packageService@",
				"com.concentrate.search.she.service.irregularity");
		replacement.put("@packageDao@",
				"com.concentrate.search.she.dao.irregularity");
		replacement.put("@TBName@", "SHE_IRREGULARITY_APPEAL");
		replacement.put("@uniqKeys@", "IRREGULARITY_ID");
		replacement
				.put("@querySql@",
						"SELECT a.ID,a.IRREGULARITY_ID,b.BIZCODE,b.COMMODITY_CODE,b.COMMODITY_NAME,b.HANDLE_TIME,b.HANDLE_METHOD,b.HANDLE_CYCLE,b.IRREGULARITY_TYPE,b.IRREGULARITY_TIME,a.CONTACT,a.REASON,a.MESSAGE,a.ATTACHMENT,a.STATUS,a.REMARK,a.AUDIT_TIME,a.AUDIT_USER FROM SHE_IRREGULARITY_APPEAL as a join SHE_IRREGULARITY as b on b.id = a.IRREGULARITY_ID");

		return replacement;
	}

	@Override
	public String getSearchFileds() {
		return "BIZCODE,COMMODITY_CODE,COMMODITY_NAME";
	}

	@Override
	public String getViewFields() {
		return "ID,IRREGULARITY_ID,BIZCODE,COMMODITY_CODE,COMMODITY_NAME,HANDLE_TIME,HANDLE_METHOD,HANDLE_CYCLE,IRREGULARITY_TYPE,IRREGULARITY_TIME,CONTACT,REASON,MESSAGE,ATTACHMENT,STATUS,REMARK,AUDIT_TIME,AUDIT_USER";
	}

	@Override
	public String getSaveFields() {
		return "ID,IRREGULARITY_ID,CONTACT,REASON,MESSAGE,ATTACHMENT,STATUS,REMARK,AUDIT_TIME,AUDIT_USER";
	}

	@Override
	public String getExportFields() {
		return "ID,IRREGULARITY_ID,BIZCODE,COMMODITY_CODE,COMMODITY_NAME,HANDLE_TIME,HANDLE_METHOD,HANDLE_CYCLE,IRREGULARITY_TYPE,IRREGULARITY_TIME,CONTACT,REASON,MESSAGE,ATTACHMENT,STATUS,REMARK,AUDIT_TIME,AUDIT_USER";
	}

	@Override
	public String getImportFields() {
		return "ID,IRREGULARITY_ID,CONTACT,REASON,MESSAGE,ATTACHMENT,STATUS,REMARK,AUDIT_TIME,AUDIT_USER";
	}

	@Override
	public String[] getExportTips() {
		return "请保证上传数据列数正确;每次上传限制300条;上传文件为CSV格式，GBK编码".split(";");
	}

	@Override
	public int getUploadLimit() {
		return 300;
	}
}
