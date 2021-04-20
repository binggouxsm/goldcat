package com.eden.finance.goldcat.record.reader.weixin;

import cn.hutool.core.date.DatePattern;
import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.finance.goldcat.record.entity.Record;
import com.eden.finance.goldcat.record.reader.Handler;
import com.eden.finance.goldcat.system.entity.enums.TypeCode;
import com.eden.finance.goldcat.util.DateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RecordHandler extends Handler  {

	private boolean findHeader = false;


	private static final String[] header= new String[]{"交易时间","交易类型","交易对方","商品","收/支","金额(元)","支付方式","当前状态","交易单号","商户单号","备注"};
	@Override
	public void doResolveInternal(String[] line, ImportRecord importRecord) {
		if(findHeader){
			if(line.length == header.length){
				transform(line, importRecord);
			}
		}else{
			findHeader= isHeader(line);
		}
	}

	private boolean isHeader(String[] line){
		if (line == null || line.length != header.length) return false;
		for (int i = 0; i < line.length; i++) {
			if(!line[i].equals(header[i])) return false;
		}
		return true;
	}

	private void transform(String[] item, ImportRecord importRecord){

		DateTimeFormatter df = DatePattern.NORM_DATETIME_FORMATTER;
		ObjectMapper json = new ObjectMapper();

		Record record = new Record();
		record.setRecordId(UUID.randomUUID().toString().replaceAll("-",""));

		Map<String,String> map  = new HashMap<>();
		record.setHappenTime(LocalDateTime.parse(item[0],df));
		map.put("交易类型",item[1]);

		record.setParty(item[2]);
		record.setProduct(item[3]);

		String type = ("/".equals(item[4])) ? "转账" : item[4];
		record.setRecordType(TypeCode.resolveDesc(type));
		record.setCurrency("CNY");
		BigDecimal amt = new BigDecimal(item[5].toCharArray(),1,item[5].length()-1);
		record.setAmount(("/".equals(item[4])) ? amt.negate() : amt);

		map.put("支付方式",item[6]);
		record.setStatus(item[7]);
		record.setSource("微信");
		map.put("交易单号",item[8]);
		map.put("商户单号",item[9]);
		record.setValidflag(true);

		try {
			String ret = json.writeValueAsString(map);
			record.setNote(ret);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		importRecord.getRecords().add(record);
	}

}
