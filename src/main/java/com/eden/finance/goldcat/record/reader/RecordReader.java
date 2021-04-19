package com.eden.finance.goldcat.record.reader;

import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.msutils.core.exception.BizException;

import java.io.File;

public interface RecordReader {

	 default boolean support(String filename, String accountName){
		for (String key: getKeywords()){
			if(filename != null && filename.contains(key))
				return true;
		}

		for (String key: getKeywords()){
			if(accountName != null && accountName.contains(key))
				return true;
		}
		return false;
	}

	default String[] getKeywords(){
		return new String[]{};
	}

	ImportRecord getRecords(File file) throws Exception;
}
