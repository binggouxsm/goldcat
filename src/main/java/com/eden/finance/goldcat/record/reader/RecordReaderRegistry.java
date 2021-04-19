package com.eden.finance.goldcat.record.reader;

import com.eden.finance.goldcat.record.reader.weixin.WeixinRecordReader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RecordReaderRegistry implements ApplicationContextAware, InitializingBean {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	private final List<RecordReader> readers = new ArrayList<>();

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, RecordReader> map = applicationContext.getBeansOfType(RecordReader.class);
		map.values().forEach((reader) -> {
			readers.add(reader);
		});
	}

	public RecordReader getReader(String filename, String accountName){
		for (RecordReader reader : readers){
			if (reader.support(filename, accountName)){
				return reader;
			}
		}
		return null;
	}



}
