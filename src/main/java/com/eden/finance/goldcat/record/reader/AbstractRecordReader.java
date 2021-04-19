package com.eden.finance.goldcat.record.reader;

import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.msutils.core.exception.BizException;

import java.io.File;

public abstract class AbstractRecordReader implements RecordReader {


	protected  abstract boolean check(File file);

	protected abstract void readFile(File file, ImportRecord importRecord);

	@Override
	public ImportRecord getRecords(File file) throws Exception {

		ImportRecord importRecord = new ImportRecord();
		if(!check(file))
			throw new BizException("不支持的导入文件类型");
		readFile(file,importRecord);
		return importRecord;
	}


}
