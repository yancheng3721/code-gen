package com.concentrate.search.codegen.selector;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;

public class BigPromotionLotterySelector implements SelectorConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", Field.newFiled("ID", "ID"));
		results.put("SUBJECT", Field.newFiled("SUBJECT", "主题"));
		results.put("SHOP_LOGO", Field.newFiled("SHOP_LOGO", "店铺logo"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement.put("@QuerySql@",
				"SELECT ID,SUBJECT,SHOP_LOGO FROM TF_BIG_PROMOTION_LOTTERY");
		replacement.put("@UpperHeadSelectorName@", "BigPromotionLottery");
		replacement.put("@SelectorName@", "bigPromotionLottery");
		replacement.put("@SelectorCNName@", "818特效");
		return replacement;
	}

	@Override
	public String getReturnFileds() {
		return "ID,SUBJECT,SHOP_LOGO";
	}

	@Override
	public String getSearchFileds() {
		return "SUBJECT,SHOP_LOGO";
	}

	@Override
	public String getViewFields() {
		return "ID,SUBJECT,SHOP_LOGO";
	}

}
