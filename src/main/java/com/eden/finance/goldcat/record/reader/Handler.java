package com.eden.finance.goldcat.record.reader;

import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.msutils.core.exception.BizException;

public abstract class Handler {

	public void doResolve(HandlerChain chain, String[] line,ImportRecord importRecord) throws Exception{
		doResolveInternal(line,importRecord);
		chain.doResolve(line, importRecord);
	}

	public abstract void doResolveInternal ( String[] line,ImportRecord importRecord) throws Exception;
}
