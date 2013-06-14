package com.demo.util;

import com.demo.bo.AbstractActivity;
import com.demo.bo.UserActivity;

public class ConstConverter {
	public static String ConvertTargetType(String source){
		if(source.equals(AbstractActivity.MOVIE)){
			return "电影";
		}
		if(source.equals(AbstractActivity.ACTOR)){
			return "女优";
		}
		if(source.equals(AbstractActivity.AGENCY)){
			return "发片商";
		}		
		return "";
	}
	
	public static String ConvertActionType(int source){
		if(source==AbstractActivity.PUBLISH){
			return "分享";
		}
		return "";
	}
}
