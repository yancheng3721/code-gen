package com.concentrate.search.codegen.selector;

import java.util.LinkedHashMap;
import java.util.Map;

import com.concentrate.search.codegen.field.Field;

public class CustomLotterySelector implements SelectorConfig {

	@Override
	public LinkedHashMap<String, Map<String, String>> getAllFileds() {
		LinkedHashMap<String, Map<String, String>> results = new LinkedHashMap<String, Map<String, String>>();
		results.put("ID", Field.newFiled("ID", "ID"));
		results.put("PRE_LOTTERY_IMAGE",
				Field.newFiled("PRE_LOTTERY_IMAGE", "抽奖前图片"));
		results.put("POST_LOTTERY_IMAGE",
				Field.newFiled("POST_LOTTERY_IMAGE", "抽奖结果图片"));
		return results;
	}

	@Override
	public LinkedHashMap<String, String> getAllReplaceMent() {
		LinkedHashMap<String, String> replacement = new LinkedHashMap<String, String>();
		replacement
				.put("@QuerySql@",
						"SELECT ID,PRE_LOTTERY_IMAGE,POST_LOTTERY_IMAGE FROM TF_CUSTOM_LOTTERY");
		replacement.put("@UpperHeadSelectorName@", "CustomLottery");
		replacement.put("@SelectorName@", "customLottery");
		replacement.put("@SelectorCNName@", "通用抽奖");
		return replacement;
	}

	@Override
	public String getReturnFileds() {
		return "ID,PRE_LOTTERY_IMAGE,POST_LOTTERY_IMAGE";
	}

	@Override
	public String getSearchFileds() {
		return "PRE_LOTTERY_IMAGE,POST_LOTTERY_IMAGE";
	}

	@Override
	public String getViewFields() {
		return "ID,PRE_LOTTERY_IMAGE,POST_LOTTERY_IMAGE";
	}

}
