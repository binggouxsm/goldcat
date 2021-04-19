package com.eden.finance.goldcat.record.reader.weixin;

import com.eden.finance.goldcat.record.reader.CSVRecordReader;
import com.eden.finance.goldcat.record.reader.HandlerChain;
import org.springframework.stereotype.Component;

@Component
public class WeixinRecordReader extends CSVRecordReader  {


	@Override
	public String[] getKeywords() {
		return new String[]{"微信","weixin"};
	}

	@Override
	protected HandlerChain getChain() {
		HandlerChain chain = new HandlerChain();
		chain.addHandler(new TimeHandler());
		chain.addHandler(new RecordHandler());
		return chain;
	}

}
