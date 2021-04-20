package com.eden.finance.goldcat.record.reader.weixin;

import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.finance.goldcat.record.reader.Handler;
import com.eden.msutils.core.exception.BizException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeHandler extends Handler {

	private static final Pattern startPattern = Pattern.compile("起始时间：\\[([0-9\\: \\-]+)\\]");

	private static final Pattern endPattern = Pattern.compile("终止时间：\\[([0-9\\: \\-]+)\\]");



	@Override
	public void doResolveInternal(String[] line, ImportRecord importRecord) throws Exception {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if((importRecord.getStartDate() == null || importRecord.getEndDate() == null) && line.length>0){
			Matcher m = startPattern.matcher(line[0]);
			LocalDateTime startdate = null ,enddate = null;
			if(m.find()){
				startdate = LocalDateTime.parse(m.group(1),df);
				importRecord.setStartDate(startdate);
			}

			Matcher m1 = endPattern.matcher(line[0]);
			if(m1.find()){
				enddate = LocalDateTime.parse(m1.group(1),df);
				importRecord.setEndDate(enddate);
			}

//			if(startdate!=null && enddate!= null ){
//				 if(startdate.getYear() != enddate.getYear() || startdate.getMonthValue() != enddate.getMonthValue())
//				 	throw new BizException("请导入同年同月的记录，不接受导入跨年或跨月数据");
//			}
		}
	}
}
