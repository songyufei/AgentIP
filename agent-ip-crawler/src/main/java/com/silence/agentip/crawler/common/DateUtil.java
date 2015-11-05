package com.silence.agentip.crawler.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	@SuppressWarnings("finally")
	public static Date spellDateStr(String date,String time){
		Date resultDate = null;
		try {
			SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			resultDate = frm.parse("20"+date+" "+time);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			return resultDate;
		}
	}
	
}
